package org.neki.backend.skills.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skill", schema="teste_residencia")
public class Skill {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="id")
		private Integer id;
		
		@Column(name="name", nullable = false )
		private String name;
		
		@Column(name="version", nullable = true)
		private String version;
		
		@Column(name="description", nullable = false)
		private String description;
		
		@Column(name="image_url", nullable= true)
		private String image;
		
		public Skill() {
			super();
		}
		
		public Skill(Integer id) {
			super();
			this.id = id;
		}

		public Skill(Integer id, String name, String version, String description, String image) {
			super();
			this.id = id;
			this.name = name;
			this.version = version;
			this.description = description;
			this.image = image;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}
}
