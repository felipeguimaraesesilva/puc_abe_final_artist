package com.guimaraes.resource;

import lombok.Data;

@Data
public class ClienteResource {
	private long id;
	private String nome;
	private String endereco;
	private Integer idade;
}
