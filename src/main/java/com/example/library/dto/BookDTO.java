package com.example.library.dto;
import java.util.List;

public class BookDTO {
	
	private String title;
	private String categoryOfTheBook;
	private List<String> yazarIsimleri;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategoryOfTheBook() {
		return categoryOfTheBook;
	}
	public void setCategoryOfTheBook(String categoryOfTheBook) {
		this.categoryOfTheBook = categoryOfTheBook;
	}
	public List<String> getYazarIsimleri() {
		return yazarIsimleri;
	}
	public void setYazarIsimleri(List<String> yazarIsimleri) {
		this.yazarIsimleri = yazarIsimleri;
	}
	
	

}
