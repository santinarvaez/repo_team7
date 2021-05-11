package ar.edu.unju.fi.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.service.ICompraService;

@Controller
public class CompraController {
	@Autowired
	Compra compra;
	
	@Autowired
	@Qualifier("CompraImp")
	private ICompraService compraService;
	
	
	@GetMapping("/compra")
	public String getCompraPage(){
		return "compra";
	}
	
	
	@PostMapping("/compra/producto")
	public ModelAndView guardarCompra(@ModelAttribute("compra")Compra compra) {
		ModelAndView modelView = new ModelAndView("compra");
		compraService.guardarCompras(compra);
		modelView.addObject("listacompras",compraService.obtenerCompras());
		return modelView;
	}
	
	
	@GetMapping("/compra/listado")
	public ModelAndView getCompraListadoPage() {
		
		ModelAndView modelView = new ModelAndView("compra");
	
		if(compraService.obtenerCompras()==null) {
			compraService.generarTablaCompras();
		}
		modelView.addObject("listacompras",compraService.obtenerCompras());
		return modelView;
	}
	
}