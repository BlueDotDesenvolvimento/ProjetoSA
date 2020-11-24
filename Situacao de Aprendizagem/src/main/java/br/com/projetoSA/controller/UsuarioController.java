package br.com.projetoSA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.projetoSA.model.Permissao;
import br.com.projetoSA.model.Usuario;
import br.com.projetoSA.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/cadastro/usuario")
	public String addUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "/cadastro/usuario";
	}
	
	@PostMapping("/cadastro/usuario/save")
	public String saveUsuario(Usuario usuario, Permissao permissao) {
		try {
			String encodedPassword = bCryptPasswordEncoder.encode(usuario.getSenha());
			usuario.setSenha(encodedPassword);
			usuarioRepository.save(usuario);
			
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return "redirect:/login";
	}

}
