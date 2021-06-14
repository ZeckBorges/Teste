package br.com.ezequiel.desafiozup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ezequiel.desafiozup.model.ModelUsuario;
import br.com.ezequiel.desafiozup.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/salvar")
	public String salvaUsuario(@RequestBody @Valid ModelUsuario modelUsuario) {
		usuarioRepository.save(modelUsuario);
		
		return "Usuário salvo com Sucesso!";
		
	}

}
