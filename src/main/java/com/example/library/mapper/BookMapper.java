package com.example.library.mapper;

import com.example.library.dto.BookDTO;
import com.example.library.entity.Book;
import com.example.library.entity.Author;

import java.util.stream.Collectors;

public class BookMapper {
	
	public static BookDTO toDTO(Book book) {
		
		
		BookDTO dto= new BookDTO();
		
		dto.setTitle(book.getTitle());
		
		
		if(book.getCategory()!=null) {
			
			dto.setCategoryOfTheBook(book.getCategory().getName());
			
		}
		else {
			dto.setCategoryOfTheBook("kategori yok");
		}
		
		if(book.getYazarlar() !=null) {
			
			dto.setYazarIsimleri(
					book.getYazarlar().stream().map(Author::getName)
					.collect(Collectors.toList()));
			
			
		}
				
				
		else {
			dto.setYazarIsimleri(null);
		}
			
				return dto;
		
		
		
	}
	
}
