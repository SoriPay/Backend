package com.example.backend0.model.user;


import lombok.Getter;

@Getter
public class LoginResponse {
	private boolean success;
	private String message;

	public LoginResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}