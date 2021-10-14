package br.com.diocursos.gof.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diocursos.gof.model.Cliente;
import br.com.diocursos.gof.model.Endereco;
import br.com.diocursos.gof.repository.ClienteRepository;
import br.com.diocursos.gof.repository.EnderecoRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepService viaCepService;

	@Override
	public Iterable<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	public void insert(Cliente client) {
		saveClientWithCEP(client);
	}

	@Override
	public void update(Long id, Cliente client) {
		Optional<Cliente> clienteBD = clienteRepository.findById(id);
		if (clienteBD.isPresent()) {
			saveClientWithCEP(client);
		}
		
	}

	@Override
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

	private void saveClientWithCEP(Cliente client) {
		String cep = client.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findByCep(cep).orElseGet(()->{
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		client.setEndereco(endereco);
		clienteRepository.save(client);
	}
}
