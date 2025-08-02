package com.example.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
public class TestController {
	
	@GetMapping("/hello")
    public String hello() {
        return "Merhaba Controller çalışıyor!";
    }

}
