package ar.edu.unju.fi.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tp4.model.Compra;

@Controller
public class CompraController {
	@Autowired
	private Compra compra;
	
	@GetMapping("/compras")
	public String getCompraPage(Model model) {
		model.addAttribute("compra",compra);
		return "compra";
	}
	
	
	
}