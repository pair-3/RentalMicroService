package com.appsdevelopersblog.rentacar.api.user.dataAccess.abstracts;

import com.appsdevelopersblog.rentacar.api.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {

	User getByEmail(String email);
	boolean existsByEmail(String email);
	boolean existsUserByEmail(String email);
}
