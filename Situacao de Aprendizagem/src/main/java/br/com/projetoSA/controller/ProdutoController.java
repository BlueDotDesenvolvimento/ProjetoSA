package br.com.projetoSA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {

	@GetMapping("/produto/view")
	public String produtoView() {
		return "produto/view";
	}
	
	@GetMapping("/produto/edit")
	public String produtoEdit() {
		return "produto/edit";
	}
	
	@GetMapping("/produto/add")
	public String produtoAdd() {
		return "produto/add";
	}
}
