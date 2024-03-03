package com.example.backend0.model.user;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class User {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) // 여기서는 increasing key로 primary key를 자동생성해주지만, 나는 id를 primary key로 생성해줬기 때문에 필요없다
	private String id; // 이게 id
	private String password;

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", password='" + password +
				'}';
	}
}