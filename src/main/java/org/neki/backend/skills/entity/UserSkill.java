package org.neki.backend.skills.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="user_skill", schema="teste_residencia")
public class UserSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="skill_id")
	private Skill skill;
	
	@Column(name="knowledge_level", nullable = false)
	private Integer knowledgeLevel;
	
	@Column(name="created_at")
	private LocalDate createdAt;
	
	@Column(name="updated_at")
	private LocalDate updatedAt;
	
	public UserSkill() {
		super();
	}

	public UserSkill(Integer id) {
		super();
		this.id = id;
	}
	
	public UserSkill(Integer id, User user, Skill skill, Integer knowledgeLevel, LocalDate createdAt,
			LocalDate updatedAt) {
		super();
		this.id = id;
		this.user = user;
		this.skill = skill;
		this.knowledgeLevel = knowledgeLevel;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

}
