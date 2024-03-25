package com.example.backend0.model.user;

import lombok.Getter;

@Getter
public class LoginRequest {
	private String username;
	private String password;


	public LoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}