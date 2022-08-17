package org.neki.backend.skills.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.neki.backend.skills.repository.UserSkillRepository;
import org.neki.backend.skills.DTO.UserSkillDTO;
import org.neki.backend.skills.entity.UserSkill;

	@Service
	public class UserSkillService {

		@Autowired
		private UserSkillRepository userSkillRepository;
		UserSkill userSkill = new UserSkill();
		
		public List<UserSkill> findAll() {
			return userSkillRepository.findAll();
		}
		
		public UserSkill save(UserSkillDTO dto) {
			LocalDate localDate = LocalDate.now();
			userSkill.setUser(dto.getUser());
			userSkill.setSkill(dto.getSkill());
			userSkill.setKnowledgeLevel(dto.getKnowledgeLevel());
			userSkill.setCreatedAt(localDate);
			userSkill.setUpdatedAt(localDate);
			return userSkillRepository.save(userSkill);
		}
		
		public UserSkill findById(Integer id) {
			Optional<UserSkill> entity = userSkillRepository.findById(id);
				if (entity.isPresent()) {
					return entity.get();
				}
				
				throw new RuntimeException();
		}
		
		public UserSkill update(UserSkill userSkill, UserSkillDTO dto) {
			userSkill.setUser(dto.getUser());
			userSkill.setSkill(dto.getSkill());
			userSkill.setKnowledgeLevel(dto.getKnowledgeLevel());
			userSkill.setCreatedAt(dto.getDataCriacao());
			userSkill.setUpdatedAt(dto.getDataAtualizacao());
			return userSkillRepository.save(userSkill);
		}
		
		public void delete(Integer id) {
			userSkillRepository.deleteById(id);
		}
		
		public List<UserSkill> findByUser(Integer id) {
			List<UserSkill> entity = userSkillRepository.findByUserId(id);
			return entity;
		}

}
