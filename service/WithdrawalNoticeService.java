package com.enviro.assessment.grad001.siyathandazamqhamane.service;

import com.enviro.assessment.grad001.siyathandazamqhamane.entity.WithdrawalNotice;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.StatementRequest;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.WithdrawalNoticeRequest;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.WithdrawalNoticeResponse;

import java.time.LocalDate;
import java.util.List;

public interface WithdrawalNoticeService {
    WithdrawalNoticeResponse createWithdrawalNotice(WithdrawalNoticeRequest withdrawalNoticeRequest);
    List<WithdrawalNotice> getNoticesByInvestorId(Long investorId);

    List<WithdrawalNotice> getStatementInvestorIdAndDateRange(Long investorId, LocalDate startDate, LocalDate endDate);

    WithdrawalNoticeResponse getByWithdrawaId(Long withdrawal_Id);
}
