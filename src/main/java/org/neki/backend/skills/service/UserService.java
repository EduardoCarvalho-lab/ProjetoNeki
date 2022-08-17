package org.neki.backend.skills.service;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import org.neki.backend.skills.domain.User;
	import org.neki.backend.skills.DTO.UserDTO;
	import org.neki.backend.skills.repository.UserRepository;

	@Service
	public class UserService {
		
		@Autowired
		private UserRepository userRepository;

		
		public List<User> findAll() {
			return userRepository.findAll();
		}
		
		public User save(UserDTO dto) {
			User user = new User();
			user.setLogin(dto.getLogin());
			user.setPassword(dto.getPassword());
			user.setLastLoginDate(dto.getLastLoginDate());
			return userRepository.save(user);
		}
		
		public User findById(Integer id) {
			Optional<User> entity = userRepository.findById(id);
				if (entity.isPresent()) {
					return entity.get();
				}
				
				throw new RuntimeException();
		}
		
		public User update(User user, UserDTO dto) {
			user.setLogin(dto.getLogin());
			user.setPassword(dto.getPassword());
			user.setLastLoginDate(dto.getLastLoginDate());
			return userRepository.save(user);
		
		}
		
		public void delete(Integer id) {
			userRepository.deleteById(id);
		}
		
		public UserDTO login(String login, String password) {
			User User = userRepository.findByLoginAndPassword(login, password);
			UserDTO UserDTO = new UserDTO();
			UserDTO.setLogin(User.getLogin());
			UserDTO.setId(User.getId());
			UserDTO.setLastLoginDate(User.getLastLoginDate());
			return UserDTO;
		}
}
