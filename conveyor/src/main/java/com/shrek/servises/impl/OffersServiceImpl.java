package com.shrek.servises.impl;


import com.shrek.model.LoanApplicationRequestDTO;
import com.shrek.model.LoanOfferDTO;
import com.shrek.servises.OffersService;
import com.shrek.validators.LoanApplicationRequestDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import com.shrek.exceptions.ParametersValidationException;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;



@Service

public class OffersServiceImpl implements OffersService {

 // private final List<LoanOfferDTO> loanOfferDTOList;

    @Value("${BASE_RATE}")
    private BigDecimal BASE_RATE;
    @Value("${IS_INSURANCE_RATE}")
    private BigDecimal IS_INSURANCE_RATE;




    @Override
    @Autowired
    public List<LoanOfferDTO> constructListOfPossibleLoanOffers(LoanApplicationRequestDTO loanApplicationRequestDTO) {


        DataBinder dataBinder = new DataBinder(loanApplicationRequestDTO);
        dataBinder.addValidators(new LoanApplicationRequestDTOValidator());
        dataBinder.validate();
        if (dataBinder.getBindingResult().hasErrors()) {
            ObjectError objectError = dataBinder.getBindingResult().getAllErrors().get(0);
            throw new ParametersValidationException(objectError.getDefaultMessage());
        }


        List<LoanOfferDTO> loanOfferDTOList=new ArrayList<>();

        loanOfferDTOList.add(createLoanOffer(loanApplicationRequestDTO, false, false));
        loanOfferDTOList.add(createLoanOffer(loanApplicationRequestDTO, false, true));
        loanOfferDTOList.add(createLoanOffer(loanApplicationRequestDTO, true, false));
        loanOfferDTOList.add(createLoanOffer(loanApplicationRequestDTO, true, true));

        Comparator<LoanOfferDTO> rateComparator = Comparator.comparing(LoanOfferDTO::getRate);
        loanOfferDTOList.sort(Collections.reverseOrder(rateComparator));
        return loanOfferDTOList;

    }



    public LoanOfferDTO createLoanOffer(@NotNull LoanApplicationRequestDTO loanApplicationRequestDTO, @NotNull Boolean isInsuranceEnabled, Boolean isSalaryClient) {

        BigDecimal totalAmount = loanApplicationRequestDTO.getAmount();


        if (isInsuranceEnabled) {
            totalAmount = totalAmount.add(IS_INSURANCE_RATE.multiply(totalAmount).divide(BigDecimal.valueOf(100)));// TODO: 07.01.2023

        }// TODO: 06.01.2023  check the possibility of rounding

        BigDecimal finalRate = changeRateForPreScoring(isInsuranceEnabled, isSalaryClient);

        return new LoanOfferDTO().applicationId((long) new Random().nextInt()).rate(finalRate).totalAmount(totalAmount);
    }

    public BigDecimal changeRateForPreScoring(@NotNull Boolean isInsuranceEnabled, @NotNull Boolean isSalaryClient) {
        BigDecimal finalRate = BASE_RATE;// TODO: 06.01.2023 change rate ref

        if (isSalaryClient) {
            finalRate = finalRate.subtract(BigDecimal.valueOf(1));
        }
        if (isInsuranceEnabled) {
            finalRate = finalRate.subtract(BigDecimal.valueOf(3));
        }


        return finalRate;
    }


}






