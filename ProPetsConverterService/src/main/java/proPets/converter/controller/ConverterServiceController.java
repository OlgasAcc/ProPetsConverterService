package proPets.converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proPets.converter.service.ConverterService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1")

public class ConverterServiceController {

	@Autowired
	ConverterService converterService;

	
}
