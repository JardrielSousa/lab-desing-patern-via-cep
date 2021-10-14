package br.com.diocursos.gof.service;

import br.com.diocursos.gof.model.Cliente;

public interface ClienteService {
	Iterable<Cliente> findAll();
	Cliente findById(Long id);
	void insert(Cliente client);
	void update(Long id,Cliente client);
	void delete(Long id);
}
