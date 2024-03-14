package com.example.backend0;

import com.example.backend0.model.user.User;
import com.example.backend0.model.user.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Backend0ApplicationTests { // 여기서 data 잘 들어가나 test 할 수 있음

	@Autowired
	private UserDao userDao;


	@Test
	void addUserTest() {
		User user = new User();
		user.setId("parangggg@naver.com");
		user.setPassword("123456");
		userDao.save(user);
	}

	@Test
	void getAllUsersAndDeleteThem() {
		List<User> users = userDao.getAllUsers(); // 받아온 걸 users에 저장해서
		for (User user : users) {
			userDao.delete(user.getId());
			userDao.delete(user.getPassword());// 다 지움
		}
	}
}



