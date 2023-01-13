package com.shrek.validators;



import com.shrek.model.EmploymentDTO;
import com.shrek.model.ScoringDataDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import static com.shrek.model.EmploymentDTO.EmploymentStatusEnum.UNEMPLOYED;


public class ScoringDataDTOValidator implements Validator {

    @Override

    public boolean supports(@NotNull Class<?> clazz) {
        return ScoringDataDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {

        ScoringDataDTO params = (ScoringDataDTO) target;
        EmploymentDTO employmentDTO = (EmploymentDTO) params.getEmployment();

        BigDecimal amount = params.getAmount();
        String gender = String.valueOf(params.getGender());
        LocalDate birthdate = params.getBirthdate();
        String maritalStatus = String.valueOf(params.getMaritalStatus());
        String employmentStatus = String.valueOf(employmentDTO.getEmploymentStatus());
        BigDecimal salary = employmentDTO.getSalary();
        String position = String.valueOf(employmentDTO.getPosition());
        Integer workExperienceTotal = employmentDTO.getWorkExperienceTotal();
        Integer workExperienceCurrent = employmentDTO.getWorkExperienceCurrent();

        if (employmentStatus.equals(String.valueOf(UNEMPLOYED))) {
            errors.reject("employmentStatus", "We can't help you. Please find a jod and try again");
        }
        if (amount.compareTo(salary.multiply(BigDecimal.valueOf(20))) > 0) {
            errors.reject("amount,salary", "The sum you are want to loan is too large");
        }
        if ((LocalDate.now().getYear() - birthdate.getYear()) > 60 || (LocalDate.now().getYear() - birthdate.getYear()) < 20) {
            errors.reject("age", "Wrong age. It should be >20&<60");
        }
        if (workExperienceTotal < 12) {
            errors.reject("workExperienceTotal", "Too little workExperienceTotal");
        }
        if (workExperienceCurrent < 3) {
            errors.reject("workExperienceCurrent", "Too little workExperienceCurrent");
        }
    }
}
