package com.cadastro.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.dto.ClienteDto;
import com.cadastro.model.Cliente;
import com.cadastro.service.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	private ModelMapper mapper;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> getList(){
		return service.getList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDto createCliente(@RequestBody ClienteDto clienteDto) {
		mapper = new ModelMapper();
		Cliente cliente = mapper.map(clienteDto, Cliente.class);
		Cliente clienteSalvo = service.save(cliente);
		return mapper.map(clienteSalvo, ClienteDto.class);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody ClienteDto clienteDto) {
		mapper = new ModelMapper();
			Cliente cliente = mapper.map(clienteDto, Cliente.class);
			cliente.setId(id);
			service.save(cliente);
			
		
	}

}
