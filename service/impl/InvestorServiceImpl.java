package com.enviro.assessment.grad001.siyathandazamqhamane.service.impl;

import com.enviro.assessment.grad001.siyathandazamqhamane.entity.Investor;
import com.enviro.assessment.grad001.siyathandazamqhamane.entity.Product;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.InvestorCreationRequest;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.InvestorCreationResponse;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.InvestorProduct;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.InvestorRequest;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.InvestorResponse;
import com.enviro.assessment.grad001.siyathandazamqhamane.repository.InvestorRepository;
import com.enviro.assessment.grad001.siyathandazamqhamane.repository.ProductRepository;
import com.enviro.assessment.grad001.siyathandazamqhamane.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvestorServiceImpl implements InvestorService {

    @Autowired
    InvestorRepository investorRepository;
    @Autowired
    ProductRepository productRepository;
    public final String successMessage = "Investor account created successfully ";

    @Override
    public InvestorCreationResponse investorCreation(InvestorCreationRequest investorCreationRequest) {
       try {
           Investor investor = new Investor();
           investor.setLastName(investorCreationRequest.getLastName());
           investor.setFirstName(investorCreationRequest.getFirstName());
           investor.setGender(investorCreationRequest.getGender().getGender());
           investor.setAge(investorCreationRequest.getAge());
           investor.setStreet(investorCreationRequest.getStreet());
           investor.setSuburb(investorCreationRequest.getSuburb());
           investor.setCity(investorCreationRequest.getCity());
           investor.setPostal_code(Integer.parseInt(investorCreationRequest.getPostalCode()));
           investor.setPhoneNumber(investorCreationRequest.getPhoneNumber());
           investor.setEmailAddress(investorCreationRequest.getEmailAddress());
           investor.setFaxNumber(investorCreationRequest.getFaxNumber());
           Investor investorResponse = investorRepository.save(investor);
           return InvestorCreationResponse.createInvestorCreationResponse(investorCreationRequest.getCorrelationId(), successMessage, investorResponse.getInvestorId());
       }catch (Exception ex){
           return InvestorCreationResponse.createInvestorCreationResponse(investorCreationRequest.getCorrelationId(), ex.getMessage(), null);
       }
    }

    @Override
    public InvestorResponse getInvestorInformation(InvestorRequest investorRequest) {
        Investor investor = investorRepository.findByInvestorId(investorRequest.getInvestorId());
        List<Product> productList =  productRepository.findByInvestorId(investorRequest.getInvestorId());
        List<InvestorProduct> addProduct = new ArrayList<>();
        InvestorResponse investorResponse = new InvestorResponse();
        investorResponse.setAge(investor.getAge());
        investorResponse.setFirstName(investor.getFirstName());
        investorResponse.setLastName(investor.getLastName());
        investorResponse.setGender(investor.getGender());
        investorResponse.setEmail_address(investor.getEmailAddress());
        investorResponse.setCity(investor.getCity());
        investorResponse.setStreet(investor.getStreet());
        investorResponse.setSuburb(investor.getSuburb());
        investorResponse.setPostal_code(investor.getPostal_code());
        investorResponse.setCellphone_number(investor.getPhoneNumber());

         for(Product product :productList){
          InvestorProduct investorProduct = new InvestorProduct();
             investorProduct.setProduct_id(product.getProductId());
             investorProduct.setProduct_type(product.getProductType());
             investorProduct.setName(product.getName());
             investorProduct.setBalance(product.getBalance());
             addProduct.add(investorProduct);
         }
        investorResponse.setProductlist(addProduct);
        return investorResponse;
    }

    @Override
    public InvestorResponse getByInvestorId(Long investorId) {
        Investor investor = investorRepository.findByInvestorId(investorId);
        InvestorResponse InvestorResponse = new InvestorResponse();
        InvestorResponse.setFirstName(investor.getFirstName());
        InvestorResponse.setLastName(investor.getLastName());
        InvestorResponse.setGender(investor.getGender());
        InvestorResponse.setAge(investor.getAge());
        InvestorResponse.setStreet(investor.getStreet());
        InvestorResponse.setCity(investor.getCity());
        InvestorResponse.setCellphone_number(investor.getPhoneNumber());
        InvestorResponse.setSuburb(investor.getSuburb());
        InvestorResponse.setEmail_address(investor.getEmailAddress());
        InvestorResponse.setFax_number(investor.getFaxNumber());
        InvestorResponse.setPostal_code(investor.getPostal_code());

        return InvestorResponse;
    }

}
