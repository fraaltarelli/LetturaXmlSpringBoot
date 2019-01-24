package it.objectmethod.main;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import it.objectmethod.leggixml.model.Allegato;

class UserHandler extends DefaultHandler {

	   boolean bNomeAttachment = false;
	   boolean bFormatoAttachment = false;
	   boolean bAttachment = false;
	   String tempValueAttachment = "";
	   Allegato allegato = new Allegato();
	   String buffer = "";

	   @Override
	   public void startElement(String uri, 
	      String localName, String qName, Attributes attributes)
	      throws SAXException {
	       
	      if (qName.equalsIgnoreCase("NomeAttachment")) {
	         bNomeAttachment = true;
	      } 
	      if (qName.equalsIgnoreCase("FormatoAttachment")) {
	         bFormatoAttachment = true;
	      } 
	      if (qName.equalsIgnoreCase("Attachment")) {
	    	  bAttachment = true;;
	      }
	   }
	   
	   
	   @Override
	   public void endElement(
	      String uri, String localName, String qName) throws SAXException {
		   
	      if (qName.equalsIgnoreCase("NomeAttachment")) {
	         allegato.setNomeAttachment(buffer);
	         
	      }
	      if (qName.equalsIgnoreCase("FormatoAttachment")) {
		         allegato.setFormatoAttachment(buffer);
		      }
	      if (qName.equalsIgnoreCase("Attachment")) {
		         allegato.setAttachment(buffer);
		      }
	      buffer="";
	   }


	   @Override
	   public void characters(
	      char ch[], int start, int length) throws SAXException {
		   
	         buffer += new String(ch,start, length);
	       
	      } 
	   
	}