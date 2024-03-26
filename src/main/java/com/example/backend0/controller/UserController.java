package com.example.backend0.controller;

import com.example.backend0.model.user.LoginRequest;
import com.example.backend0.model.user.LoginResponse;
import com.example.backend0.model.user.User;
import com.example.backend0.model.user.UserDao;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.hibernate.internal.util.collections.CollectionHelper.listOf;

@RestController
public class UserController {

	@Autowired
	private UserDao userDao;

	@GetMapping("/user/get-all") // 나중에 android에서 요청할 때
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}

	// android에서 새로운 정보를 입력받는다면
	@PostMapping("/user/save")
	public User save(@RequestBody User user){ // @RequestBody로 data 받아옴
		return userDao.save(user);

	}




	/*@PostMapping("user/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		User user = userDao.findByUsername(request.getUsername());
		if (user != null && user.getPassword().equals(request.getPassword())) {
			return new LoginResponse(true, "로그인 성공");
		} else {
			return new LoginResponse(false, "아이디 또는 비밀번호가 올바르지 않습니다.");
		}
	}

	 */
}

