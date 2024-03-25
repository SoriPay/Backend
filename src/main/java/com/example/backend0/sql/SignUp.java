package com.example.backend0.sql;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class SignUp {

	@PostMapping("/register")
	public JSONObject register(@RequestBody JSONObject body) {
		JSONObject response = new JSONObject();

		String id = (String) body.get("id");

		String url = "jdbc:mysql://192.168.228.8:3306/userlog";
		String username = "parang";
		String password = "backend";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM User WHERE id=?");
			selectStatement.setString(1, id);
			ResultSet resultSet = selectStatement.executeQuery();

			if (!resultSet.next()) {
				// 사용 가능한 이메일인 경우
				response.put("message", true);
				System.out.println("사용 가능한 이메일입니다.");
			} else {
				// 이미 등록된 이메일인 경우
				response.put("message", false);
				System.out.println("이미 등록된 이메일입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.put("message", "error");
		}

		return response;
	}
}

