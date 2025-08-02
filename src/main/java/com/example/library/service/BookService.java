package com.example.library.service;


import com.example.library.entity.Book;
import com.example.library.exception.BookNotFoundException;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {
	
	private final BookRepository bookRepository;
	
	public Book addBook(Book book) {
		
		List<Book>existingBooks= bookRepository.findByYayınEvi(book.getYayınEvi());
		
		if(existingBooks!=null  && !existingBooks.isEmpty()) {
			
			System.out.println("Bu yayınevine ait kitap var, bu kitap da ekleniyor");
			
			
	
		}
		
		return bookRepository.save(book);
		
		
	}

	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	
	public Book getBookbyId(Long id) {
		
		Book book= bookRepository.findById(id).orElse(null);
		
		
		if(book==null) {
			throw new BookNotFoundException("Kitap bulunamadı");
		}
		
		else {
			return book;
		}
		
		
	}
	
	public void deleteBook(Long id) {
		
		
		Book book =bookRepository.findById(id).orElse(null);
		
		if(book==null) {
			throw new RuntimeException("Silinecek kitap bulunamadı");
			
			
		}
		else {
			bookRepository.delete(book);
		}
	}
	
	
	public void updateBookStock(Long id, int newStock) {
		
		Book book=bookRepository.findById(id).orElse(null);
		
		if(book==null) {
			throw new RuntimeException("Kitap bulunamadı, stok güncellenemedi");
		}
		
		else {
			book.setStock(newStock);
			bookRepository.save(book);
			
		}
		
		
		
	}
	
	
}
