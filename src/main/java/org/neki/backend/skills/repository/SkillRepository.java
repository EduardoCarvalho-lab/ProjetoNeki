package org.neki.backend.skills.repository;

import org.neki.backend.skills.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

	public interface SkillRepository extends JpaRepository<Skill, Integer> {

	}
