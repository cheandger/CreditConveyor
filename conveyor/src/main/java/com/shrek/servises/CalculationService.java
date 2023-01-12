package com.shrek.servises;


import com.shrek.model.CreditDTO;
import com.shrek.model.ScoringDataDTO;
import org.springframework.beans.factory.annotation.Autowired;

public interface CalculationService {

    CreditDTO createCreditDTO(ScoringDataDTO scoringDataDTO);

}
