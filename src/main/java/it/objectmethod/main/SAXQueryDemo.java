package it.objectmethod.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import it.objectmethod.leggixml.model.Allegato;


public class SAXQueryDemo {
	
	byte[] pdf;
	private String nomeFile;

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public byte[] leggiPdfDaXml(String nomeFileXml,String pathXml) {

		try {
			File inputFile = new File(pathXml+nomeFileXml+".xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			UserHandler userhandler = new UserHandler();
			saxParser.parse(inputFile, userhandler);  
			Allegato allegato = userhandler.allegato;
			System.out.println("Nome Attachment: "+allegato.getNomeAttachment());
			System.out.println("Formato Attachment: "+allegato.getFormatoAttachment());
			System.out.println("Attachment: "+allegato.getAttachment());
			String attachment = allegato.getAttachment();
			nomeFile = allegato.getNomeAttachment();

			byte[] bytesEncoded = Base64.decodeBase64(attachment.getBytes());

			pdf = bytesEncoded;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pdf;

	}

}


