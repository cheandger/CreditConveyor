package com.shrek.controllers;
import com.shrek.controller.OffersServiceApiController;
import com.shrek.model.LoanApplicationRequestDTO;
import com.shrek.model.LoanOfferDTO;
import com.shrek.servises.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@Validated


public class OffersServiceController extends OffersServiceApiController {

        private final OffersService offersService;
@Autowired
    public OffersServiceController(NativeWebRequest request, OffersService offersService) {
        super(request);
        this.offersService = offersService;
    }

    @Override
    public ResponseEntity<List<LoanOfferDTO>> constructListOfPossibleLoanOffers(@RequestParam LoanApplicationRequestDTO loanApplicationRequestDTO)  {

        return ResponseEntity.ok(offersService.constructListOfPossibleLoanOffers(loanApplicationRequestDTO));
        }
    }

