package org.neki.backend.skills.controller;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.ResponseStatus;
	import org.springframework.web.bind.annotation.RestController;

	import org.neki.backend.skills.entity.UserSkill;
	import org.neki.backend.skills.DTO.UserSkillDTO;
	import org.neki.backend.skills.repository.UserSkillRepository;
	import org.neki.backend.skills.service.UserSkillService;
	import io.swagger.annotations.ApiOperation;
	import io.swagger.annotations.ApiResponse;
	import io.swagger.annotations.ApiResponses;

	@RestController
	@RequestMapping("/api")
	public class UserSkillController {
		
		@Autowired
		private UserSkillRepository userSkillRepository;
		
		@Autowired
		private UserSkillService userSkillService;
		
		@GetMapping("/habilidadeUsuario")
		@ApiOperation(value = "Listar Habilidades do Usuário ", notes = "Listar Habilidades do Usuário")
		@ApiResponses(value = { @ApiResponse(code = 200, message = " Habilidades do Usuário listados com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		
		public List<UserSkill> getUserSkill(){
			return userSkillRepository.findAll();
		}
		
		@GetMapping("/habilidadeUsuarioPorId/{id}")
		@ApiOperation(value = "Buscar habilidade usuário por ID", notes = "Buscar habilidado do usuário por ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade do usuário encontrado com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		
		public ResponseEntity<UserSkill> listarUserSkillUnica(@PathVariable Integer id) {
			Optional<UserSkill> habilidadeUsu = Optional.ofNullable(userSkillService.findById(id));
			if(habilidadeUsu.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(habilidadeUsu.get());
		}
		
		@PostMapping("/cadastrarUserSkill")
		@ApiOperation(value = "Cadastrar Habilidades do Usuário ", notes = "Cadastrar Habilidades do Usuário")
		@ApiResponses(value = { @ApiResponse(code = 200, message = " Habilidades do Usuário Cadastradas com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		
		@ResponseStatus(HttpStatus.CREATED)
		public UserSkill registerUserSkill(@RequestBody UserSkillDTO dto) {
			return userSkillService.save(dto);
		}
		
		@PutMapping("/atualizarUserSkill/{id}")
		@ApiOperation(value = "Atualizar habilidade usuário por ID", notes = "Atualizar habilidado do usuário por ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade do usuário atualizada com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		
		public UserSkill updateUserSkill(@RequestBody UserSkillDTO dto, @PathVariable Integer id) {
			UserSkill habilidadeUsu = userSkillService.findById(id);
			return userSkillService.update(habilidadeUsu, dto);
		}
		
		@DeleteMapping("deletarHabilidadeUsuario/{id}")
		@ApiOperation(value = "Excluir habilidade usuário por ID", notes = "Excluir habilidado do usuário por ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade do usuário excluída com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		
		public void deleteUserSkill(@PathVariable Integer id) {
			userSkillService.delete(id);
		}
		
		@GetMapping("/habilidadePorIdUsuario/{id}")
		public List<UserSkill> habilidadePorIdUsuario(@PathVariable Integer id) {
			return userSkillService.findByUser(id);
		}
}
