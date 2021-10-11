package br.com.nelioalves;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.nelioalves.Repository.CategoriaRepository;
import br.com.nelioalves.Repository.ProdutoRepository;
import br.com.nelioalves.domain.Categoria;
import br.com.nelioalves.domain.Produto;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	
	//Metodo é iniciado toda vez que a aplicação é startada
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto prod1 = new Produto(null, "Computador", 2000.00);
		Produto prod2 = new Produto(null, "Impressora", 800.00);
		Produto prod3 = new Produto(null, "Mouse", 80.00);
		//Esta linha está executando a associação de categorias com produtos
		//utilizndo o getProdutos.addAll, operação usada para adicionar todos 
		//os produtos que tem relacionamento com Categorias
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod2.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2) );
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
	}

}
