package com.shrek.servises;


import com.shrek.model.LoanApplicationRequestDTO;
import com.shrek.model.LoanOfferDTO;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public interface OffersService {
    List <LoanOfferDTO> constructListOfPossibleLoanOffers(LoanApplicationRequestDTO loanApplicationRequestDTO);

}
