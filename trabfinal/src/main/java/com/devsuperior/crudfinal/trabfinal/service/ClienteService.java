package com.devsuperior.crudfinal.trabfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.crudfinal.trabfinal.dto.ClientDTO;
import com.devsuperior.crudfinal.trabfinal.entities.Client;
import com.devsuperior.crudfinal.trabfinal.repositories.ClientRepository;

public class ClienteService {

	@Autowired
	private ClientRepository repository; 

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		Page<Client> clientList = repository.findAll(pageRequest);
		return clientList.map(x-> new ClientDTO(x));
	}
	
	/*@Transactional(readOnly = true)
	public Page<CategoryDTO> findAllPaged(PageRequest pageRequest) {
		Page<Category> list = repository.findAll(pageRequest);
		return list.map(x -> new CategoryDTO(x));
	}*/
}
