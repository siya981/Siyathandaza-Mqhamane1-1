package com.enviro.assessment.grad001.siyathandazamqhamane.controller;

import com.enviro.assessment.grad001.siyathandazamqhamane.entity.WithdrawalNotice;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.InvestorCreationRequest;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.InvestorCreationResponse;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.InvestorRequest;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.InvestorResponse;
import com.enviro.assessment.grad001.siyathandazamqhamane.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/investors")
public class InvestorController {

    @Autowired
    @Qualifier("investorServiceImpl")
    private InvestorService investorService;

    @PostMapping("/investor_creation")
    InvestorCreationResponse creatInvestor( @Valid @RequestBody InvestorCreationRequest investorCreationRequest) {
        return investorService.investorCreation(investorCreationRequest);
    }
    @GetMapping("/{investorid}")
    InvestorResponse getByInvestorId(@PathVariable Long investorid) {
        return investorService.getByInvestorId(investorid);
    }

    @PostMapping("/retrieve_investor_information")
    InvestorResponse getInvestorInformation( @Valid @RequestBody InvestorRequest investorRequest) {
        return investorService.getInvestorInformation(investorRequest);
    }
}
