package com.czmud.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.czmud.dojosandninjas.models.Dojo;
import com.czmud.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService( DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public Dojo createDojo( Dojo dojo ) {
		return dojoRepository.save( dojo );
	}
	
	public Dojo getDojoById( Long id ) {
		Optional<Dojo> dojo = dojoRepository.findById( id );
		if(dojo.isPresent()) {
			return dojo.get();
		}
		return null;
	}
	
	public List<Dojo> getAllDojos(){
		return dojoRepository.findAll();
	}
	
}
