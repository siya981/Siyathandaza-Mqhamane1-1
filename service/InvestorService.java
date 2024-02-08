package com.enviro.assessment.grad001.siyathandazamqhamane.service;

import com.enviro.assessment.grad001.siyathandazamqhamane.model.*;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.InvestorCreationRequest;

public interface InvestorService {
    InvestorCreationResponse investorCreation(InvestorCreationRequest investorCreationRequest);
    InvestorResponse getInvestorInformation(InvestorRequest InvestorRequest);
    InvestorResponse getByInvestorId(Long investorId);


}
