package com.example.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.library.entity.Book;
import com.example.library.entity.Author;



public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findByYayınEvi(String yayınEvi);
	List<Book> findBySayfaGreaterThan(int minPage);
	
	@Query ("SELECT b FROM Book b WHERE b.category.name = :categoryName")
	List<Book> findByCategory(@Param("categoryName") String categoryName);
	


	@Query("SELECT b FROM Book b JOIN b.yazarlar a WHERE a.name = :authorName")
	List<Book> findBooksByAuthorName(@Param("authorName") String authorName);




}
