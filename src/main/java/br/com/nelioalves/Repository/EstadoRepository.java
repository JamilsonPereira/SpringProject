package br.com.nelioalves.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nelioalves.domain.Categoria;
import br.com.nelioalves.domain.Cidade;
import br.com.nelioalves.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
