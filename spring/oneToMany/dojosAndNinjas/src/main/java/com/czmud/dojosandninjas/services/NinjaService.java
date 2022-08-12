package com.czmud.dojosandninjas.services;

import org.springframework.stereotype.Service;

import com.czmud.dojosandninjas.models.Ninja;
import com.czmud.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService( NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public Ninja createNinja( Ninja ninja ) {
		return ninjaRepository.save( ninja );
	}
	
	
	
}
