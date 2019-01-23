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
	        
//		   currentElement = true;
//	      if (qName.equalsIgnoreCase("allegato")) {
//	         rollNo = attributes.getValue("rollno");
//	      }
//	      if(("393").equals(rollNo) && qName.equalsIgnoreCase("student")) {
//	         System.out.println("Start Element :" + qName);      
//	      }       
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

//	      if (bNomeAttachment) {
//	    	 buffer+= new String(ch, start, length);
//	         System.out.println("Nome Attachment: " + nomeAttachment);
//	    	 bNomeAttachment = false;
//	      } 
//	      if (bFormatoAttachment) {
//	    	 buffer+=new String(ch, start, length);
//	         System.out.println("Formato Attachment: " + formatoAttachment);
//	         System.out.print("Attachment: ");
//	         bFormatoAttachment = false;
//	      } 
	         buffer += new String(ch,start, length);
	       
	      } 
	   
	}