package org.neki.backend.skills.repository;

import org.neki.backend.skills.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByLoginAndPassword(String login, String senha);

}

