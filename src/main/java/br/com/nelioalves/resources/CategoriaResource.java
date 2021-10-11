package br.com.nelioalves.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Anotação do Rest para controller 
@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return  "Rest Funcionando";
	}
	
}
