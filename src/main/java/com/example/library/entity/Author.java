package com.example.library.entity;

import java.util.List;

import jakarta.persistence.*; 

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private int KitapSayısı;
	
	@ManyToMany(mappedBy = "yazarlar")
	private List<Book> books;

}
