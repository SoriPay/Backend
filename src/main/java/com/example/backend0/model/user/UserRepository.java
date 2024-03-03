package com.example.backend0.model.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, String> { // 우리 primary key는 id인 string
	// crudrepository : create, read, update, delete 할 수 있는 유용한 클래스

}
