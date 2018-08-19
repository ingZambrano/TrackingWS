package com.avior.controller;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;


public class PasswordEncoderGenerator {

	public static void main(String[] args) {
				
		String password = "L3brum3T";
		String mail = "jmanuel.zambrano25@gmail.com";
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
		String hashedPassword = passwordEncoder.encodePassword(password, mail); 

		System.out.println(hashedPassword);
		

	}

}