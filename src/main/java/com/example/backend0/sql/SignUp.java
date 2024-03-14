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
public class SignUp {

	@PostMapping("/register")
	public JSONObject register(@RequestBody JSONObject body) {
		JSONObject response = new JSONObject();

		String id = (String) body.get("id");
		String pwd = (String) body.get("password");

		// JDBC 연결 설정
		String url = "jdbc:mysql://localhost:3306/userlog";
		String username = "parang";
		String password = "backend";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			// 사용자가 이미 등록되어 있는지 확인
			PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM User WHERE id=?");
			selectStatement.setString(1, id);
			ResultSet resultSet = selectStatement.executeQuery();

			if (!resultSet.next()) {
				// 사용자 등록
				PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO User(id, password) VALUES (?, ?)");
				insertStatement.setString(1, id);
				insertStatement.setString(2, pwd);
				insertStatement.executeUpdate();

				response.put("message", true);
				System.out.println("회원가입 성공");
			} else {
				// 이미 등록된 사용자
				response.put("message", false);
				System.out.println("회원가입 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// 예외 처리 (예: 로깅, 사용자에게 메시지 반환 등)
		}

		return response;
	}
}