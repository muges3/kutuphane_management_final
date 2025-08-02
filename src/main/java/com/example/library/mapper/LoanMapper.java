package com.example.library.mapper;

import com.example.library.dto.LoanDTO;
import com.example.library.entity.Loan;

public class LoanMapper {
	
	public static LoanDTO toDTO (Loan loan) {
		
		LoanDTO dto=new LoanDTO();
		
		if (loan.getUser()!=null) {
			dto.setUserName(loan.getUser().getName());
			
		}
		
		else {
			dto.setUserName("Bu kullanıcı sistemde yok");
		}
		
		
		if(loan.getBook()!=null) {
			
			dto.setBookTitle(loan.getBook().getTitle());
			
			
		}
		
		else {
			dto.setBookTitle("Bu kitap kütüphanede yok");
		}
		
		dto.setLoanDate(loan.getLoanDate());
		dto.setReturnDate(loan.getReturnDate());
		
		
		return dto;
	}
	

}
