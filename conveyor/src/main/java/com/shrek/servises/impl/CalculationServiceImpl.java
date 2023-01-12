package com.shrek.servises.impl;

import com.shrek.validators.ScoringDataDTOValidator;
import com.shrek.exceptions.ParametersValidationException;
import com.shrek.model.CreditDTO;
import com.shrek.model.EmploymentDTO;
import com.shrek.model.PaymentScheduleElement;
import com.shrek.model.ScoringDataDTO;
import com.shrek.servises.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;





@Service
public class CalculationServiceImpl implements CalculationService {

    @Value("${BASE_RATE}")
    private BigDecimal BASE_RATE;
    @Value("${IS_INSURANCE_RATE}")
    private BigDecimal IS_INSURANCE_RATE;


    @Override
    @Autowired
    public CreditDTO createCreditDTO(ScoringDataDTO scoringDataDTO) {

        DataBinder dataBinder = new DataBinder(scoringDataDTO);
        dataBinder.addValidators(new ScoringDataDTOValidator());
        dataBinder.validate();
        if (dataBinder.getBindingResult().hasErrors()) {
            ObjectError objectError = dataBinder.getBindingResult().getAllErrors().get(0);
            throw new ParametersValidationException(objectError.getDefaultMessage());
        }

        BigDecimal totalAmount = scoringDataDTO.getAmount();

        if (scoringDataDTO.getIsInsuranceEnabled())

            totalAmount = totalAmount.add((IS_INSURANCE_RATE.multiply(totalAmount)
                    .divide(BigDecimal.valueOf(100)))
                    .divide(BigDecimal.valueOf(12))
                    .multiply(BigDecimal.valueOf(scoringDataDTO.getTerm())));


        BigDecimal finalRate = evaluationRateForScoring(scoringDataDTO);

        BigDecimal aHundredthPartOfMonthlyRate = finalRate.divide(BigDecimal.valueOf(12)).divide(BigDecimal.valueOf(100));

        BigDecimal monthlyPayment = totalAmount.multiply((aHundredthPartOfMonthlyRate
                .add((aHundredthPartOfMonthlyRate
                        .divide(((BigDecimal.valueOf(1)
                                .add(aHundredthPartOfMonthlyRate))
                                .pow(scoringDataDTO.getTerm()))
                                .subtract(BigDecimal.valueOf(1)))))));


        BigDecimal firstMonthInterestPayment = totalAmount.multiply(aHundredthPartOfMonthlyRate);

        BigDecimal firstMonthDeptPayment = monthlyPayment.subtract(firstMonthInterestPayment);

        List<PaymentScheduleElement> scheduleList = new ArrayList<>();

        PaymentScheduleElement firstMonth = new PaymentScheduleElement()
                .number(1)
                .date(LocalDate.now().plusMonths(1))
                .totalPayment(totalAmount)
                .interestPayment(totalAmount.multiply(aHundredthPartOfMonthlyRate))
                .debtPayment(totalAmount.subtract(firstMonthInterestPayment))
                .remainingDebt(totalAmount.subtract(firstMonthDeptPayment));

        for (Integer i = 0; i < scoringDataDTO.getTerm(); i++) { // TODO: 07.01.2023   Made a List of payments
            if (i == 0) {
                scheduleList.add(firstMonth);
            } else {
                scheduleList.add(new PaymentScheduleElement()
                        .number(i + 1)
                        .date(firstMonth.getDate().plusMonths(1 + i))
                        .totalPayment(monthlyPayment)// TODO: 07.01.2023 УЗнать у Димы что это поточнее, я думаю, что это своюный месячный платеж
                        .interestPayment(scheduleList.get(i - 1).getRemainingDebt().multiply(aHundredthPartOfMonthlyRate))
                        .debtPayment(monthlyPayment.subtract(scheduleList.get(i).getInterestPayment()))
                        .remainingDebt(scheduleList.get(i - 1).getRemainingDebt().subtract(scheduleList.get(i).getDebtPayment()))
                );
            }

        }
        return  new CreditDTO().amount(scoringDataDTO.getAmount())
                .term(scoringDataDTO.getTerm())
                .monthlyPayment(monthlyPayment)
                .rate(finalRate)
                .psk(totalAmount)
                .isInsuranceEnabled(scoringDataDTO.getIsInsuranceEnabled())
                .isSalaryClient(scoringDataDTO.getIsSalaryClient())
                .paymentSchedule(scheduleList);


    }

/*   credDTO
            "amount": "BigDecimal", передадим
            "term": "Integer",      передадим
          "monthlyPayment": "BigDecimal", посчитали
          "rate": "BigDecimal",  посчитали
          "psk": "BigDecimal",   посчитали
          "isInsuranceEnabled": "Boolean", предадим
          "isSalaryClient": "Boolean", передадим
          "paymentSchedule": "List<PaymentScheduleElement>"todo//needed to calc

*/

    public BigDecimal evaluationRateForScoring(ScoringDataDTO scoringDataDTO) {


        BigDecimal preEvalRate = BASE_RATE;

        EmploymentDTO employmentDTO = (EmploymentDTO) scoringDataDTO.getEmployment();


        switch (employmentDTO.getEmploymentStatus()) {
            case SELF_EMPLOYED -> preEvalRate = preEvalRate.add(BigDecimal.valueOf(1));
            case BUSSINESS_OWNER -> preEvalRate = preEvalRate.add(BigDecimal.valueOf(3));
        }
        switch (employmentDTO.getPosition()) {
            case MID_MANAGER -> preEvalRate = preEvalRate.subtract(BigDecimal.valueOf(2));
            case TOP_MANAGER -> preEvalRate = preEvalRate.subtract(BigDecimal.valueOf(4));
        }
        if (scoringDataDTO.getIsInsuranceEnabled()) {

            preEvalRate = preEvalRate.subtract(BigDecimal.valueOf(3));
        }
        if (scoringDataDTO.getIsSalaryClient()) {
            preEvalRate = preEvalRate.subtract(BigDecimal.valueOf(1));
        }
        switch (scoringDataDTO.getMaritalStatus()) {
            case MARRIED -> preEvalRate = preEvalRate.subtract(BigDecimal.valueOf(3));
            case DIVORCED -> preEvalRate = preEvalRate.add(BigDecimal.valueOf(1));
        }
        if (scoringDataDTO.getDependentAmount() > 1)
            preEvalRate = preEvalRate.add(BigDecimal.valueOf(1));

        switch (scoringDataDTO.getGender()) {
            case MALE:
                if ((LocalDate.now().getYear() - scoringDataDTO.getBirthdate().getYear()) < 55 ||
                        (LocalDate.now().getYear() - scoringDataDTO.getBirthdate().getYear()) > 30)
                    preEvalRate = preEvalRate.subtract(BigDecimal.valueOf(3));


            case FEMALE:
                if ((LocalDate.now().getYear() - scoringDataDTO.getBirthdate().getYear()) < 60 ||
                        (LocalDate.now().getYear() - scoringDataDTO.getBirthdate().getYear()) > 35)
                    preEvalRate = preEvalRate.subtract(BigDecimal.valueOf(3));

            case NON_BINARY:
                preEvalRate = preEvalRate.add(BigDecimal.valueOf(3));
        }

        return preEvalRate;
    }

}



 /*   credDTO
            "amount": "BigDecimal", передадим
            "term": "Integer",      передадим
          "monthlyPayment": "BigDecimal", посчитали
          "rate": "BigDecimal",  посчитали
          "psk": "BigDecimal",   посчитали
          "isInsuranceEnabled": "Boolean", предадим
          "isSalaryClient": "Boolean", передадим
          "paymentSchedule": "List<PaymentScheduleElement>"todo//needed to calc

*/