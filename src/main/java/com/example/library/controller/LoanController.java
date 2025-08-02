package com.example.library.controller;

import com.example.library.dto.LoanDTO;
import com.example.library.mapper.LoanMapper;
import com.example.library.entity.Loan;
import com.example.library.service.LoanService;
import com.example.library.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequiredArgsConstructor
@RequestMapping("/loans")
public class LoanController {
	
	private final LoanService loanService;
	private final LoanRepository loanRepository;
	
	
	@PostMapping("/borrow")
	public void borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
		
		loanService.borrowBook(userId, bookId);
		
		
	}
	
	@PostMapping("/return")
	public void returnBook(@RequestParam Long loanId) {
		loanService.returnBook(loanId);
	}
	
	@GetMapping("/user/{userId}")
	public List<LoanDTO> getLoansByUser(@PathVariable Long userId){
	
	List<Loan> loans=loanRepository.findByUserId(userId);
	return loans.stream().map(LoanMapper::toDTO).toList();
	
	}
	
	
	@GetMapping("/today")
	public List<LoanDTO> getTodayLoans(){
		
		List<Loan> loans=loanRepository.findByLoanDate(LocalDate.now());
		 return loans.stream().map(LoanMapper::toDTO).toList();
		 
	}
	
	@GetMapping("/late")
	public List<LoanDTO> getLateLoans(){
		
		List<Loan> loans=loanRepository.findByReturnDateBefore(LocalDate.now());
		
		return loans.stream().map(LoanMapper::toDTO).toList();
	}
	

}
