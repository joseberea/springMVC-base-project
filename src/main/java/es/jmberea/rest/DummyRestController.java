package es.jmberea.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/api/dummy")
public class DummyRestController {

	@RequestMapping()
	private void getAll() {
		
	}
	
}
