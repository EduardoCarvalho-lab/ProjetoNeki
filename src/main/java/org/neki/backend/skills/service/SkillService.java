package org.neki.backend.skills.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.neki.backend.skills.domain.Skill;
import org.neki.backend.skills.repository.SkillRepository;
import org.neki.backend.skills.DTO.SkillDTO;

	@Service
	public class SkillService {
		
		@Autowired
		private SkillRepository skillRepository;
		
		public List<Skill> findAll() {
			return skillRepository.findAll();
		}
		
		public Skill save(SkillDTO dto) {
			Skill skill = new Skill();
			skill.setName(dto.getName());
			skill.setVersion(dto.getVersion());
			skill.setDescription(dto.getDescription());
			skill.setImage(dto.getImage());
			return skillRepository.save(skill);
		}
		
		public Skill findById(Integer id) {
			Optional<Skill> entity = skillRepository.findById(id);
				if (entity.isPresent()) {
					return entity.get();
				}
				
				throw new RuntimeException();
		}
		
		public Skill update(Skill skill, SkillDTO dto) {
			skill.setName(dto.getName());
			skill.setVersion(dto.getVersion());
			skill.setDescription(dto.getDescription());
			skill.setImage(dto.getImage());
			return skillRepository.save(skill);
		}
		
		public void delete(Integer id) {
			skillRepository.deleteById(id);
		}
}
