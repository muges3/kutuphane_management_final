package com.example.library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.security.PrivateKey;
import java.util.List;
import com.example.library.entity.Category; 


import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.*; 



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private int year;
	private int stock;
	private int sayfa;
	private String yayınEvi;
	
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	
	
	
	@ManyToMany
	@JoinTable(
			
			name="book_author",
			joinColumns = @JoinColumn(name= "book_id"),
			inverseJoinColumns=@JoinColumn(name="author_id")
			)
	
	private List<Author> yazarlar;
	
	
	@OneToMany (mappedBy = "book")
	private List<Loan> ödünç;



	
	
}
