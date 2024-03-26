package com.example.backend0.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {

	@PostMapping("/login")
	public JSONObject login(@RequestBody JSONObject body) {
		JSONObject response = new JSONObject();

		String id = (String) body.get("id");
		String pw = (String) body.get("pw");

		// JDBC 연결 설정
		String url = "jdbc:mysql://localhost:3306/userlog";
		String username = "parang";
		String password = "backend";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			// 사용자 로그인 확인
			PreparedStatement selectStatement = connection.prepareStatement("SELECT UID FROM User WHERE id=? AND password=?");
			selectStatement.setString(1, id);
			selectStatement.setString(2, pw);
			ResultSet resultSet = selectStatement.executeQuery();

			if (!resultSet.next()) {
				// 로그인 실패
				System.out.println("로그인 실패");
				response.put("UID", -1);
			} else {
				// 로그인 성공
				System.out.println("로그인 성공");
				response.put("UID", resultSet.getInt("UID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// 예외 처리 (예: 로깅, 사용자에게 메시지 반환 등)
		}

		return response;
	}
/*
	@Autowired
	private UserService userService;

	@PostMapping("/checkEmailRegistration")
	public ResponseEntity<Boolean> checkEmailRegistration(@RequestBody String id) {
		boolean isRegistered = userService.isEmailRegistered(id);
		return ResponseEntity.ok(isRegistered);
	}

	/*@PostMapping("/checkEmailRegistration")
	public boolean checkEmailRegistration(@RequestBody String id) {
		// JDBC 연결 및 이메일 등록 여부 확인
		String url = "jdbc:mysql://192.168.228.8:3306/userlog";
		String dbId = "parang";
		String dbPassword = "backend";
		Connection connection = null;
		boolean isRegistered = false;

		try {
			connection = DriverManager.getConnection(url, dbId, dbPassword);
			String sql = "SELECT COUNT(*) FROM User WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				isRegistered = count > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isRegistered;
	}



	 */
}
