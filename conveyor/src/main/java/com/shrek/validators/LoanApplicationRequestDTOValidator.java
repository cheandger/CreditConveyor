package com.shrek.validators;

import com.shrek.model.LoanApplicationRequestDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

public class LoanApplicationRequestDTOValidator implements Validator {


        @NotNull

        public boolean supports( Class<?>  clazz) {
            return LoanApplicationRequestDTO.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(@NotNull Object target, @NotNull Errors errors) {// TODO: 06.01.2023 ask for David, why it wants @notNull
            LoanApplicationRequestDTO params = (LoanApplicationRequestDTO) target;
            Optional<LocalDate> birthDate = Optional.ofNullable(params.getBirthdate());
            Optional<LocalDate> today = Optional.of(LocalDate.now());
            if ((((birthDate.isPresent())&&(today.get().getYear() - birthDate.get().getYear()) <18))) {
                errors.reject("Invalid age", "The date of birth must be at least 18 years old before today");

            }

        }
    }

