package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library.entity.Loan;
import java.util.List;
import java.time.LocalDate;


public interface LoanRepository extends JpaRepository<Loan, Long>{
	
List<Loan> findByUserId(Long userId);

List<Loan> findByBookId(Long bookId);

List<Loan> findByLoanDate(LocalDate loanDate);

List<Loan> findByReturnDateBefore(LocalDate date);

}
