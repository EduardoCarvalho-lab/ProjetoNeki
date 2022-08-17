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

	import org.neki.backend.skills.entity.Skill;
	import org.neki.backend.skills.DTO.SkillDTO;
	import org.neki.backend.skills.repository.SkillRepository;
	import org.neki.backend.skills.service.SkillService;
	import io.swagger.annotations.ApiOperation;
	import io.swagger.annotations.ApiResponse;
	import io.swagger.annotations.ApiResponses;

	@RestController
	@RequestMapping ("/api")
	public class SkillController {

		@Autowired
		private SkillRepository skillRepository;
		
		@Autowired
		private SkillService skillService;
		
		@GetMapping("/Habilidade")
		@ApiOperation(value = "Listar Habilidades ", notes = "Listar Habilidades")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidades listadas com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		
		public List<Skill> getSkill(){
			return skillRepository.findAll();
		}
		
		@GetMapping("/habilidadePorId/{id}")
		@ApiOperation(value = "Buscar habilidade por ID", notes = "Buscar habilidade por ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade encontrada com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		
		public ResponseEntity<Skill> listUniqueSkill(@PathVariable Integer id) {
			Optional<Skill> skill = Optional.ofNullable(skillService.findById(id));
			if(skill.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(skill.get());
		}
		
		@PostMapping("/cadastrarHabilidade")
		@ApiOperation(value = "Cadastrar habilidade", notes = "Cadastrar habilidade")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade inserida com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		
		@ResponseStatus(HttpStatus.CREATED)
		public Skill registerSkill(@RequestBody SkillDTO dto) {
			return skillService.save(dto);
		}
		
		@PutMapping("/atualizarSkill/{id}")
		@ApiOperation(value = "Atualizar habilidade por ID", notes = "Atualizar habilidade por ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade atualizada com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		
		public Skill upgradeSkill(@RequestBody SkillDTO dto, @PathVariable Integer id) {
			Skill skill = skillService.findById(id);
			return skillService.update(skill, dto);
		}
		
		@DeleteMapping("deletarSkill/{id}")
		@ApiOperation(value = "Excluir habilidade por ID", notes = "Excluir habilidade por ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade excluída com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		
		public void deleteSkill(@PathVariable Integer id) {
			skillService.delete(id);
		}
}
