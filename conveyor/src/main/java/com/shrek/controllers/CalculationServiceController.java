package com.shrek.controllers;

import com.shrek.controller.CalculationServiceApiController;
import com.shrek.model.CreditDTO;
import com.shrek.model.ScoringDataDTO;
import com.shrek.servises.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;




@RestController
@Validated


public class CalculationServiceController extends CalculationServiceApiController {

    CalculationService calculationService;

    @Autowired
    public CalculationServiceController(NativeWebRequest request,CalculationService calculationService) {
        super(request);
        this.calculationService = calculationService;
    }


@Override
public ResponseEntity<CreditDTO> createCreditDTO(@RequestParam ScoringDataDTO scoringDataDTO)  {
        return ResponseEntity.ok(calculationService.createCreditDTO(scoringDataDTO));
}

    }



