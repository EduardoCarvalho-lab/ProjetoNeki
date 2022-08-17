package org.neki.backend.skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.neki.backend.skills.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByLoginAndPassword(String login, String senha);

}

