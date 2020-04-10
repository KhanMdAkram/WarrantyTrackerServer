package com.warrantytracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@GetMapping("vi/auth/")
	public ResponseEntity<String> login() {
		System.out.print("auth api called");
		return new ResponseEntity<String>("auth succes :  ", HttpStatus.OK);
	}


}
