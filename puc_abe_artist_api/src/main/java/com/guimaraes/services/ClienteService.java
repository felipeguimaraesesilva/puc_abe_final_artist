package com.guimaraes.services;

import java.util.List;

import com.guimaraes.resource.ClienteResource;

public interface ClienteService {

	void insereNovoCliente(ClienteResource cliente);

	List<ClienteResource> buscarTodos();
}
