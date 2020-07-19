package proPets.converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import proPets.converter.configuration.BeanConfiguration;
import proPets.converter.configuration.ConverterConfiguration;
import proPets.converter.dto.ConvertedLocationData;
import proPets.converter.dto.ConvertedPostDto;
import proPets.converter.dto.PostRequestDto;
import proPets.converter.service.ConverterService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/convert/v1")

public class ConverterServiceController {

	@Autowired
	ConverterService converterService;

	@Autowired
	ConverterConfiguration converterConfiguration;

	@RefreshScope
	@GetMapping("/config")
	public  BeanConfiguration getRefreshedData() {
		return new BeanConfiguration(converterConfiguration.getGeoKey(),converterConfiguration.getGeoUrl(),converterConfiguration.getUrl());
	}
	
	@PutMapping ("/post")
	public ResponseEntity<ConvertedPostDto> convertPost(@RequestBody PostRequestDto postRequestDto) throws Exception {
		System.out.println("im in converter service");
		HttpHeaders newHeaders = new HttpHeaders();
		newHeaders.add("Content-Type", "application/json");
		ConvertedPostDto body = converterService.convertToConvertedPost(postRequestDto);
		System.out.println(body.getId());
		return ResponseEntity.ok().headers(newHeaders).body(body);
	}
	
	@PutMapping ("/location")
	public ResponseEntity<ConvertedLocationData> getLocationData(@RequestParam ("address") String address) throws Exception {
		HttpHeaders newHeaders = new HttpHeaders();
		newHeaders.add("Content-Type", "application/json");
		ConvertedLocationData body = converterService.getLocationData(address);
		return ResponseEntity.ok().headers(newHeaders).body(body);
	}
}
