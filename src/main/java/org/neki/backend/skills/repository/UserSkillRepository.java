package org.neki.backend.skills.repository;

import java.util.List;

import org.neki.backend.skills.entity.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;

	public interface UserSkillRepository extends JpaRepository<UserSkill, Integer> {
			
		List<UserSkill> findByUserId(Integer id);
	}
