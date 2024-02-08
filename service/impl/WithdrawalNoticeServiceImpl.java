package com.enviro.assessment.grad001.siyathandazamqhamane.service.impl;

import com.enviro.assessment.grad001.siyathandazamqhamane.entity.Investor;
import com.enviro.assessment.grad001.siyathandazamqhamane.entity.Product;
import com.enviro.assessment.grad001.siyathandazamqhamane.entity.WithdrawalNotice;
import com.enviro.assessment.grad001.siyathandazamqhamane.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.*;
import com.enviro.assessment.grad001.siyathandazamqhamane.repository.InvestorRepository;
import com.enviro.assessment.grad001.siyathandazamqhamane.repository.ProductRepository;
import com.enviro.assessment.grad001.siyathandazamqhamane.repository.WithdrawalNoticeRepository;
import com.enviro.assessment.grad001.siyathandazamqhamane.service.WithdrawalNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Service
public class WithdrawalNoticeServiceImpl implements WithdrawalNoticeService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    InvestorRepository investorRepository;

    @Autowired
    WithdrawalNoticeRepository withdrawalNoticeRepository;

    public final String successMessage = "Withdrawal Notice created successfully";
    @Override
    public WithdrawalNoticeResponse createWithdrawalNotice(WithdrawalNoticeRequest withdrawalNoticeRequest) {

        try {
            Investor investor = investorRepository.findByInvestorId(withdrawalNoticeRequest.getInvestorId());
            if (investor == null) {

                throw new ResourceNotFoundException("Investor with investor id %s does not exist", withdrawalNoticeRequest.getInvestorId());
            }
            Product product = productRepository.findByInvestorIdAndProductType(withdrawalNoticeRequest.getInvestorId(),
                    withdrawalNoticeRequest.getProduct_type().getProduct());
            if (product == null) {

                throw new ResourceNotFoundException("Investor's product type %s does not exist", withdrawalNoticeRequest.getProduct_type().getProduct());
            }

            //ToDo: If WITHDRAWAL AMOUNT is greater than current BALANCE, then a validation error must be returned
            if(withdrawalNoticeRequest.getWithDrawalAmount().compareTo(product.getBalance()) > 0) {
                throw new IllegalArgumentException("Requested withdrawal amount exceeds the remaining balance");
            }
            BigDecimal ninetyPercent = calculate90PercentOfBalance(product.getBalance());
            if (withdrawalNoticeRequest.getWithDrawalAmount().compareTo(ninetyPercent) > 0) {
                throw new IllegalArgumentException("Investors cannot withdraw an AMOUNT more than 90% of the current balance");
            }
            //ToDo: set WithdrawalNotice and save
            WithdrawalNotice withdrawalNotice = new WithdrawalNotice();
            withdrawalNotice.setWithdrawalAmount(withdrawalNoticeRequest.getWithDrawalAmount());
            withdrawalNotice.setWithdrawalDate(LocalDate.now());
            withdrawalNotice.setProductType(withdrawalNoticeRequest.getProduct_type().getProduct());
            withdrawalNotice.setInvestorId(withdrawalNoticeRequest.getInvestorId());
            WithdrawalNotice withdrawalNoticeResponse = withdrawalNoticeRepository.save(withdrawalNotice);

            if (product != null) {
                BigDecimal newBalance = product.getBalance().subtract(withdrawalNoticeRequest.getWithDrawalAmount());
                product.setBalance(newBalance);
                productRepository.save(product);
            }

            return WithdrawalNoticeResponse.createWithdrawalNoticeResponse(withdrawalNoticeRequest.getCorrelationId(),successMessage,withdrawalNoticeResponse.getWithdrawalId());
        }catch (Exception ex){
            return WithdrawalNoticeResponse.createWithdrawalNoticeResponse(withdrawalNoticeRequest.getCorrelationId(), ex.getMessage(), null);

        }

    }

    @Override
    public List<WithdrawalNotice> getNoticesByInvestorId(Long productId) {
        return null;
    }

    @Override
    public  List<WithdrawalNotice> getStatementInvestorIdAndDateRange(Long investorId, LocalDate startDate, LocalDate endDate) {

        List<WithdrawalNotice> withdrawalNotice =
                withdrawalNoticeRepository.findByInvestorIdAndWithdrawalDateIsBetween(investorId, startDate, endDate);

        return withdrawalNotice;
    }

    public static BigDecimal calculate90PercentOfBalance(BigDecimal amount) {

        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }

        BigDecimal ninetyPercent = amount.multiply(new BigDecimal("0.9"));
        return ninetyPercent;
    }
     @Override
    public WithdrawalNoticeResponse getByWithdrawaId(Long withdrawal_Id) {
        WithdrawalNotice withdrawalNotice = withdrawalNoticeRepository.findByWithdrawalId(withdrawal_Id);
        WithdrawalNoticeResponse withdrawalNoticeResponse = new WithdrawalNoticeResponse();
        withdrawalNoticeResponse.setWithdrawalId(withdrawalNotice.getWithdrawalId());
        withdrawalNoticeResponse.setWithdrawalAmount(withdrawalNotice.getWithdrawalAmount());
        withdrawalNoticeResponse.setWithdrawalDate(withdrawalNotice.getWithdrawalDate());
        withdrawalNoticeResponse.setProductType(withdrawalNotice.getProductType());
        withdrawalNoticeResponse.setInvestorId(withdrawalNotice.getInvestorId());
        return withdrawalNoticeResponse;

    }
}

