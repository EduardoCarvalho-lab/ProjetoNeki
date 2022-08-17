package org.neki.backend.skills.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.neki.backend.skills.domain.UserSkill;

	public interface UserSkillRepository extends JpaRepository<UserSkill, Integer> {
			
		List<UserSkill> findByUserId(Integer id);
	}
