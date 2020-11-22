package br.com.projetoSA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.projetoSA.model.Usuario;
import br.com.projetoSA.repository.UsuarioRepository;

@Controller
public class CadastroController {

	@Autowired
	public Usuario usuario;
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@GetMapping("/cadastro/addUsuario")
	public String addUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "cadastro/addUsuario";		
	}
	
	@PostMapping("/cadastro/saveUsuario")
	public String saveUsuario(Usuario usuario) {
		try {
			if (usuario != null) {
				usuarioRepository.save(usuario);
			}	
		} catch (Exception e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		}
		return "/";
	}
}
