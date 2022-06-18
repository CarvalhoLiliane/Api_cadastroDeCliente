package com.cadastro.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.model.Cliente;
import com.cadastro.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public List<Cliente> getList(){
		return repository.findAll();
	}
	
	public Cliente getById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, null));
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}
