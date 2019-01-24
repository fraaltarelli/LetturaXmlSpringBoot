package it.objectmethod.leggixml.controller.rest;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.main.SAXQueryDemo;

@RestController
@RequestMapping("/api")
public class AllegatoRestController {
	
	@Autowired
	SAXQueryDemo saxQuery;

	
	@Value("${proprieta.xml}")
	private String pathXml;
	
	
	@RequestMapping(value = "allegato/leggiAttachment/{nomeFileXml}", method = RequestMethod.GET)
	public HttpEntity<byte[]> createPdf(
	                 @PathVariable("nomeFileXml") String nomeFileXml) throws IOException {

	    byte[] documentBody = saxQuery.leggiPdfDaXml(nomeFileXml,pathXml);
	    String nomeFile = saxQuery.getNomeFile().trim();

	    HttpHeaders header = new HttpHeaders();
	    header.setContentType(MediaType.APPLICATION_PDF);
	    header.set(HttpHeaders.CONTENT_DISPOSITION,
	                   "attachment; filename=" + nomeFile.replace(" ", "_"));
	    header.setContentLength(documentBody.length);

	    return new HttpEntity<byte[]>(documentBody, header);
	}


}
