package it.objectmethod.main;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import it.objectmethod.leggixml.model.Allegato;

@Component
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


