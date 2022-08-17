package org.neki.backend.skills.DTO;

public class SkillDTO {

		private Integer id;
		private String name;
		private String version;
		private String description;
		private String image;
		
		public SkillDTO() {
			super();
		}

		public SkillDTO(Integer id, String name, String version, String description, String image) {
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
