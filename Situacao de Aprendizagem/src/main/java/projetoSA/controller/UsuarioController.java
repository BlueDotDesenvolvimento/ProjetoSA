package projetoSA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import projetoSA.model.Usuario;
import projetoSA.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuario/edit/{id}")
	public String editUsuario(@PathVariable long id, Model model){
		model.addAttribute("usuario", usuarioRepository.findById(id));
		return "usuario/edit";
	}
	@GetMapping("/usuario/view/{id}/{salvo}")
	public String viewUsuario(@PathVariable long id,@PathVariable  boolean salvo, Model model){
		model.addAttribute("usuario", usuarioRepository.findById(id));
		model.addAttribute("salvo", salvo);
		return "usuario/view";
	}
		
}
