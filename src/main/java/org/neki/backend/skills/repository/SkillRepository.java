package org.neki.backend.skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.neki.backend.skills.domain.Skill;

	public interface SkillRepository extends JpaRepository<Skill, Integer> {

	}
