package com.wolken.wolkenapp.garage_webservice_consumable;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wolken.wolkenapp.garage_webservice_consumable.dto.ConsumableGarageDTO;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// post();
		// get();
		// put();
		delete();

	}

	static void get() {

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<ConsumableGarageDTO> entity = new HttpEntity<ConsumableGarageDTO>(headers);

		ResponseEntity<Object[]> responseEntity = restTemplate
				.exchange("http://localhost:8080/garage-webservices/getAll", HttpMethod.GET, entity, Object[].class);

		for (Object obj : responseEntity.getBody()) {
			System.out.println(obj);

		}

	}

	static void post() {

		RestTemplate restTemplate = new RestTemplate();

		ConsumableGarageDTO consumableGarageDTO = new ConsumableGarageDTO();

		consumableGarageDTO.setId(10);
		consumableGarageDTO.setColor("Black");
		consumableGarageDTO.setName("Maruti");
		consumableGarageDTO.setNoOfWheels(4);
		consumableGarageDTO.setPrice(40000);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<ConsumableGarageDTO> entity = new HttpEntity<ConsumableGarageDTO>(consumableGarageDTO, headers);

		ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8080/garage-webservices/save",
				HttpMethod.POST, entity, String.class);

		System.out.println(responseEntity.getBody());

	}

	static void put() {

		RestTemplate restTemplate = new RestTemplate();

		ConsumableGarageDTO consumableGarageDTO = new ConsumableGarageDTO();

		consumableGarageDTO.setName("Maruti");
		consumableGarageDTO.setPrice(45000);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<ConsumableGarageDTO> entity = new HttpEntity<ConsumableGarageDTO>(consumableGarageDTO, headers);

		ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8080/garage-webservices/update",
				HttpMethod.PUT, entity, String.class);

		System.out.println(responseEntity.getBody());

	}

	static void delete() {

		RestTemplate restTemplate = new RestTemplate();

		ConsumableGarageDTO consumableGarageDTO = new ConsumableGarageDTO();

		consumableGarageDTO.setName("Maruti");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<ConsumableGarageDTO> entity = new HttpEntity<ConsumableGarageDTO>(consumableGarageDTO, headers);

		ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8080/garage-webservices/delete",
				HttpMethod.DELETE, entity, String.class);

		System.out.println(responseEntity.getBody());

	}

}