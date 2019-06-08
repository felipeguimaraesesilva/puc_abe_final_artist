package com.guimaraes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guimaraes.entity.ClienteEntity;
import com.guimaraes.repository.ClienteRepository;
import com.guimaraes.resource.ClienteResource;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void insereNovoCliente(ClienteResource cliente) {
		ClienteEntity newCliente = new ClienteEntity();
		newCliente.setNome(cliente.getNome());
		newCliente.setEndereco(cliente.getEndereco());
		newCliente.setIdade(cliente.getIdade());

		clienteRepository.save(newCliente);
	}

	@Override
	public List<ClienteResource> buscarTodos() {
		List<ClienteResource> resultado = new ArrayList<>();
		Iterable<ClienteEntity> clientes = clienteRepository.findAll();

		for (ClienteEntity cliente : clientes) {
			ClienteResource c = new ClienteResource();
			c.setId(cliente.getId());
			c.setNome(cliente.getNome());
			c.setEndereco(cliente.getEndereco());
			c.setIdade(cliente.getIdade());
			resultado.add(c);
		}

		return resultado;
	}

}
