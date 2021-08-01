package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.PersonajeResponse;
import service.RickAndMorty;

@RestController
@RequestMapping({"/api"})
public class ObjectController {
	
	private static Logger LOG = LoggerFactory.getLogger(RickAndMorty.class);
	
	@Autowired
	private RickAndMorty rickandmorty;
	

	@PostMapping("/obtenerPersonaje")
	public int getPersonaje(@RequestBody  int id) {
		LOG.info("Entro a obtenerPersonaje");
		LOG.info("ID"+id);
		//PersonajeResponse response= rickandmorty.obtenerPersonaje(id);
		//return response.toString();
		return id;
	}

	
}
