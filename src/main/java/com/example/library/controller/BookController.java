package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping ("/books")
public class BookController {

    private final BookRepository bookRepository;

	private final BookService bookService;


	
	@GetMapping
	public List<Book> getAllBooks(){
		
		return bookService.getAllBooks();
		
	}
	
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		
		return bookService.getBookbyId(id);
		
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteBook (@PathVariable Long id) {
		bookService.deleteBook(id);
	}
	
	
	@PutMapping("/{id}/stock")
	public void updateBookStock(@PathVariable Long id, @RequestParam int newStock) {
		
		bookService.updateBookStock(id, newStock);
		
	}
	
	@GetMapping("/publisher/{yayinevi}")
	public List<Book> getBooksByPublisher(@PathVariable String yayinevi){
		
		return bookRepository.findByYayınEvi(yayinevi);
	}
	
	
	@GetMapping("/author/{authorName}")
	public List<Book> getBooksByAuthor(@PathVariable String authorName){
		
		return bookRepository.findBooksByAuthorName(authorName);
	}
	
	
	@GetMapping("/pages")
	public List<Book> getBookByPageCount(@RequestParam int min){
		
		return bookRepository.findBySayfaGreaterThan(min);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
