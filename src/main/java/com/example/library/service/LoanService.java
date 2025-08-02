package com.example.library.service;


import com.example.library.entity.Book;
import com.example.library.entity.Loan;
import com.example.library.entity.User;
import com.example.library.exception.StockNotAvailableException;
import com.example.library.repository.BookRepository;
import com.example.library.repository.LoanRepository;
import com.example.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import javax.management.RuntimeErrorException;


@Service
@RequiredArgsConstructor
public class LoanService {
	
	private final LoanRepository loanRepository;
	private final BookRepository bookRepository;
	private final UserRepository userRepository;
	
	
	public void borrowBook(Long userId, Long bookId) {
		
		
		
		User user =userRepository.findById(userId).orElse(null);
		
		if(user==null) {
			throw new RuntimeException("Böyle bir kullanıcı bulunamadı");
		}
		
		
		
		
		Book book =bookRepository.findById(bookId).orElse(null);
		if(book==null) {
			throw new RuntimeException("Böyle bir kullanıcı bulunamadı");
			
		}
		
		
		if(book.getStock()<=0) {
			
			throw new StockNotAvailableException("Kitap stokta yok");
			
		}
		
		Loan loan= new Loan();
		loan.setUser(user);
		loan.setBook(book);
		loan.setLoanDate(LocalDate.now());
		loan.setReturnDate(LocalDate.now().plusDays(14));
		
		loanRepository.save(loan);
		
		book.setStock(book.getStock()-1);
		bookRepository.save(book);
		
	}
	
	
	
	public void returnBook(Long loanId) {
		
		Loan loan=loanRepository.findById(loanId).orElse(null);
		if(loan==null) {
			throw new RuntimeException("Ödünç alınma kaydı bulunamadı");
			
		}
		
		loan.setReturnDate(LocalDate.now());
		loanRepository.save(loan);
		
		
		Book book=loan.getBook();
		
		if(book!=null) {
			book.setStock(book.getStock()+1);
			bookRepository.save(book);
		}
		
		
		
	}
	
	

}
