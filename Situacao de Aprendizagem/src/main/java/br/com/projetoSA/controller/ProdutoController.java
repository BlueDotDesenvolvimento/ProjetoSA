package br.com.projetoSA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {

	@GetMapping("/produto/view")
	public String viewProduto() {
		return "produto/view";
	}
	
	@GetMapping("/produto/edit")
	public String editProduto() {
		return "produto/edit";
	}
	
	@GetMapping("/produto/add")
	public String addProduto() {
		return "produto/add";
	}
}
