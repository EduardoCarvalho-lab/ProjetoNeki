package org.neki.backend.skills.DTO;

import java.time.LocalDate;

	public class UserDTO {

		private Integer id;
		private String login;
		private String password;
		private LocalDate lastLoginDate;
		
		public UserDTO() {
			super();
		}

		public UserDTO(Integer id, String login, String password, LocalDate lastLoginDate) {
			super();
			this.id = id;
			this.login = login;
			this.password = password;
			this.lastLoginDate = lastLoginDate;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public LocalDate getLastLoginDate() {
			return lastLoginDate;
		}

		public void setLastLoginDate(LocalDate lastLoginDate) {
			this.lastLoginDate = lastLoginDate;
		}

}
