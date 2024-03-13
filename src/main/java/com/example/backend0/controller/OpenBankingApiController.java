/*
package com.example.backend0.controller;


import com.example.backend0.model.user.UserDao;
import com.example.backend0.service.OpenBankingApiService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/openBanking")
public class OpenBankingApiController {

	private final OpenBankingApiService openBankingApiService;
	private final UserDao userDao;

	@Autowired
	public OpenBankingApiController(OpenBankingApiService openBankingApiService, UserDao userDao) {
		this.openBankingApiService = openBankingApiService;
		this.userDao = userDao;
	}

	public OpenBankingAPIController(UserDao userDao) {
		this.userDao = userDao;
	}

	public OpenBankingApiController() {
	}

	//사용자인증 uri
	//https://testapi.openbanking.or.kr/oauth/2.0/authorize?response_type=code&client_id=6cc9ec2e-52e9-473a-a392-4a783fed7443&redirect_uri=http%3A%2F%2Flocalhost%3A9099%2FopenBanking%2Fcode&scope=login%20inquiry%20transfer&client_info=test&state=b80BLsfigm9OokPTjy03elbJqRHOfGSY&auth_type=0&cellphone_cert_yn=Y&authorized_cert_yn=Y&account_hold_auth_yn=N&register_info=A

	//사용자 인증api로 코드를 신규발급 받은 후, 돌아올 메소드(리턴 uri)
	//코드값이 있을경우, 받아서 db에 등록해준다.
	@GetMapping(value = "/code")
	@ResponseHeader
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public Map<String, String> addUserCode(HttpServletRequest request) {
		Map<String, String> response = new HashMap<>();

		String code = request.getParameter("code");
		String id = userDao.getMyUserWithAuthorities().get().getId();

		int response_code = openBankingAPIService.addUserCode(code, id);

		if (response_code == 0) {
			response.put("result", "코드가 정상적으로 등록되었습니다");
		}else {
			response.put("result", "코드 등록을 실패 하였습니다");
		}
		return response;
	}

	//오픈뱅킹을 사용하기위한 토큰을 발급받는 메소드
	@PostMapping(value = "/gettoken")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public Map<String, String> getToken(HttpSession httpSession){
		Map<String, String> response = new HashMap<>();

		int response_code = openBankingAPIService.getToken();

		if (response_code == 0) {
			response.put("result", "코드가 정상적으로 등록되었습니다");
		}else{
			response.put("result", "코드 등록을 실패 하였습니다");
		}

		return response;
	}


*/