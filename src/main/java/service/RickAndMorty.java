package service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.*;

import org.slf4j.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.PersonajeResponse;

@Service
public class RickAndMorty implements RickAndMortyImpl {

	@Value("${url.getPersonaje}")
	private String urlGetPersonaje;

	// guardar log en la consola de springboot
	private static Logger LOG = LoggerFactory.getLogger(RickAndMorty.class);


	@Override
	public PersonajeResponse obtenerPersonaje(int id) {

		LOG.info("Entro a obtenerPersonaje");
		final String url = urlGetPersonaje + id;

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders httpHeaders = getHeaders();
		HttpEntity<PersonajeResponse> httpEntity = new HttpEntity<>(httpHeaders);
		PersonajeResponse personajeResponse = new PersonajeResponse();

		try {
			ResponseEntity<PersonajeResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
					PersonajeResponse.class);

			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				personajeResponse = responseEntity.getBody();
				LOG.info("Se ha obtenido al personaje : " + personajeResponse.getName());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return personajeResponse;
	}

	private static HttpHeaders getHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Accept", "application/json");
		httpHeaders.set("Content-Type", "application/json");

		return httpHeaders;
	}
}
