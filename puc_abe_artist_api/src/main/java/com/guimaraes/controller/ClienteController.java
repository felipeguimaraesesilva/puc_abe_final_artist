package com.guimaraes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.constant.AppConstants;
import com.guimaraes.resource.ClienteResource;
import com.guimaraes.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	private static final String RESOURCE_NAME = "/cliente";
	private static final String CONTEXT_RESOURCE = "/" + AppConstants.VERSION_V1 + RESOURCE_NAME;

	@PostMapping(CONTEXT_RESOURCE)
	public void insereNovoCliente(@RequestBody ClienteResource cliente) {
		clienteService.insereNovoCliente(cliente);
	}

	@GetMapping(CONTEXT_RESOURCE)
	public List<ClienteResource> getAll() {
		return clienteService.buscarTodos();
	}

}
