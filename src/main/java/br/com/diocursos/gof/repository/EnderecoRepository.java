package br.com.diocursos.gof.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.diocursos.gof.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String>{
	Optional<Endereco> findByCep(String cep);
}
