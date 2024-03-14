package com.example.backend0.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;
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
}
