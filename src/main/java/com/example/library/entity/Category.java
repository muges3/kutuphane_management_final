package com.example.library.entity;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*; 

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "category")
	
	private List<Book>kitap;
	
	
	
		
	
}
