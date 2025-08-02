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
public class User {

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private long id;


private String name;
private String durum;
private String email;

@OneToMany(mappedBy = "user")
private List<Loan> ödünç;


	
	
	
	
	
	
}
