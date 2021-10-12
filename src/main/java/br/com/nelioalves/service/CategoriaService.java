package br.com.nelioalves.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nelioalves.Repository.CategoriaRepository;
import br.com.nelioalves.domain.Categoria;
import br.com.nelioalves.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		//Metodo Para lançar excessao.
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id 
							+ ", Tipo" + Categoria.class.getName());
		}
		return obj.get();
	}
	
}
