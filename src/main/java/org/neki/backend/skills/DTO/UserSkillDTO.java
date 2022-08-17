package org.neki.backend.skills.DTO;

import java.time.LocalDate;

import org.neki.backend.skills.domain.User;
import org.neki.backend.skills.domain.Skill;

	public class UserSkillDTO {
		
		private Integer id;
		private User user;
		private Skill skill;
		private Integer knowledgeLevel;
		private LocalDate creationDate;
		private LocalDate atualizationDate;
		

		public UserSkillDTO() {
			super();
		}

		public UserSkillDTO(Integer id, User user, Skill skill, Integer knowledgeLevel, LocalDate creationDate,
				LocalDate atualizationDate) {
			super();
			this.id = id;
			this.user = user;
			this.skill = skill;
			this.knowledgeLevel = knowledgeLevel;
			this.creationDate = creationDate;
			this.atualizationDate = atualizationDate;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Skill getSkill() {
			return skill;
		}

		public void setSkill(Skill skill) {
			this.skill = skill;
		}

		public Integer getKnowledgeLevel() {
			return knowledgeLevel;
		}

		public void setKnowledgeLevel(Integer knowledgeLevel) {
			this.knowledgeLevel = knowledgeLevel;
		}

		public LocalDate getDataCriacao() {
			return creationDate;
		}

		public void setDataCriacao(LocalDate creationDate) {
			this.creationDate = creationDate;
		}

		public LocalDate getDataAtualizacao() {
			return atualizationDate;
		}

		public void setDataAtualizacao(LocalDate atualizationDate) {
			this.atualizationDate = atualizationDate;
		}

}
