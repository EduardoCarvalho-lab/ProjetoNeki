package org.neki.backend.skills.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus; 
import org.springframework.web.bind.annotation.RestController;
import org.neki.backend.skills.repository.UserRepository;
import org.neki.backend.skills.DTO.UserDTO;
import org.neki.backend.skills.entity.User;
import org.neki.backend.skills.service.UserService; 
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

@RequestMapping("/api") public class UserController {

@Autowired private UserRepository userRepository;

@Autowired private UserService userService;

@GetMapping("/Usuario")

@ApiOperation(value = "Listar Usuários ", notes = "Listar Usuários")

@ApiResponses(value = { @ApiResponse(code = 200, message =
"Usuários listados com sucesso"),

@ApiResponse(code = 401, message = "Erro de autenticação"),

@ApiResponse(code = 403, message =
"Usuário sem permissão de acesso ao recurso."),

@ApiResponse(code = 404, message = "Recurso Indisponível"),

@ApiResponse(code = 500, message = "Erro interno do servidor"),

@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

public List<User> listarUsuario(){ return userRepository.findAll(); }

@GetMapping("/UsuarioPorId/{id}")

@ApiOperation(value = "Buscar usuário por ID", notes =
"Buscar usuário por ID")

@ApiResponses(value = { @ApiResponse(code = 200, message =
"Usuário encontrado com sucesso"),

@ApiResponse(code = 401, message = "Erro de autenticação"),

@ApiResponse(code = 403, message =
"Sem permissão para acessar o recurso"),

@ApiResponse(code = 404, message = "Recurso Indisponível"),

@ApiResponse(code = 500, message = "Erro interno do servidor"),

@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

public ResponseEntity<User> listarUsuarioUnico(@PathVariable Integer id) {
Optional<User> user = Optional.ofNullable(userService.findById(id));
if(user.isEmpty()) { return ResponseEntity.notFound().build(); }

return ResponseEntity.ok(user.get()); }

@PostMapping("/cadastrarUsuario")

@ApiOperation(value = "Cadastrar Usuários ", notes = "Cadastrar Usuários")

@ApiResponses(value = { @ApiResponse(code = 200, message =
"Cadastro realizado com sucesso"),

@ApiResponse(code = 401, message = "Erro de autenticação"),

@ApiResponse(code = 403, message =
"Sem permissão para acessar o recurso"),

@ApiResponse(code = 404, message = "Recurso Indisponível"),

@ApiResponse(code = 500, message = "Erro interno do servidor"),

@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

@ResponseStatus(HttpStatus.CREATED) public User
cadastrarUsuario(@RequestBody UserDTO dto) {
	BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
	String encryptedKey = crypt.encode(dto.getPassword());
	dto.setPassword(encryptedKey);
	return userService.save(dto);
}

@PutMapping("/atualizarUsuario/{id}")

@ApiOperation(value = "Atualizar usuário por ID", notes =
"Atualizar usuário por ID")

@ApiResponses(value = { @ApiResponse(code = 200, message =
"Usuário atualizado com sucesso"),

@ApiResponse(code = 401, message = "Erro de autenticação"),

@ApiResponse(code = 403, message =
"Sem permissão para acessar o recurso"),

@ApiResponse(code = 404, message = "Recurso Indisponível"),

@ApiResponse(code = 500, message = "Erro interno do servidor"),

@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

public User atualizeUser(@RequestBody UserDTO dto, @PathVariable Integer id) { 
	User user = userService.findById(id); 
	return userService.update(user, dto); 
}

@DeleteMapping("deletarUsuario/{id}")

@ApiOperation(value = "Excluir usuário por ID", notes = "Excluir usuário por ID")

@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário excluído com sucesso"),

@ApiResponse(code = 401, message = "Erro de autenticação"),

@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),

@ApiResponse(code = 404, message = "Recurso Indisponível"),

@ApiResponse(code = 500, message = "Erro interno do servidor"),

@ApiResponse(code = 505, message = "Ocorreu uma exceção")
})

public void deleteUser(@PathVariable Integer id) {
userService.delete(id);
}

@PostMapping("/login") public UserDTO Login( @RequestBody User user) { 
	return userService.login(user.getLogin(), user.getPassword());
}

}