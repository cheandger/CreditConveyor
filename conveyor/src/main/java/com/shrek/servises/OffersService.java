package com.shrek.servises;


import com.shrek.model.LoanApplicationRequestDTO;
import com.shrek.model.LoanOfferDTO;



import java.util.List;

public interface OffersService {
    List <LoanOfferDTO> offers (LoanApplicationRequestDTO loanApplicationRequestDTO);

}
