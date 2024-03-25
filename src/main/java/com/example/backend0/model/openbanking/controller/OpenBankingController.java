/*
package com.example.backend0.model.openbanking.controller;

import com.example.backend0.model.openbanking.dto.AccountListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend0.model.openbanking.dto.AccountListDto;
import com.example.backend0.model.openbanking.dto.TokenRequestDto;
import com.example.backend0.model.openbanking.dto.TokenResponseDto;
import com.example.backend0.model.openbanking.feign.OpenBankingFeign;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class OpenBankingController {
	@Autowired
	private OpenBankingFeign openBankingFeign;

	@Value("${client_secret}")
	private String client_secret;

	@PostMapping("/requestToken")
	public TokenResponseDto requestToken(@RequestBody TokenRequestDto tokenRequest) {
		tokenRequest.setClient_secret(client_secret);
		TokenResponseDto tokenResponse = openBankingFeign.requestToken(tokenRequest.getCode(), tokenRequest.getClient_id(), tokenRequest.getClient_secret(), tokenRequest.getRedirect_uri(), tokenRequest.getGrant_type());
		return tokenResponse;
	}

	@GetMapping("/account/list")
	public AccountListDto getAccountList(String access_token, String user_seq_no, String include_cancel_yn, String sort_order) {
		return openBankingFeign.requestAccountList("Bearer " + access_token, user_seq_no, include_cancel_yn, sort_order);
	}
}

 */