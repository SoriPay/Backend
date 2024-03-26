package com.example.backend0.model.user;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Account {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	// 여기서는 increasing key로 primary key를 자동생성해주지만, 나는 id를 primary key로 생성해줬기 때문에 필요없다
	//private String name;
	//@GeneratedValue
	//private String id; // 이게 id

	private String account;
	private String account_pwd;



	public void setAccount(String account) {
		this.account = account;
	}


	public void getAccount(String account) {
		this.account= account;
	}

	public void setAccount_pwd(String account_pwd) {
		this.account_pwd = account_pwd;
	}

	@Override
	public String toString() {
		return "Account{" +
				"account=" + account +
				", account_pwd='" + account_pwd + '\'' +
				'}';
	}
}