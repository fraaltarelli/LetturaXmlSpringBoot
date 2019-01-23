package it.objectmethod.leggixml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
	
	@GetMapping("inizio")
	public String inizio() {
		return "inizio";
	}

}
