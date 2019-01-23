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
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import it.objectmethod.leggixml.model.Allegato;

public class SAXQueryDemo {
	
   public static void main(String[] args) {
	   

      try {
         File inputFile = new File("src/it/objectmethod/main/IT02355260981_0H2e7.xml");
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         UserHandler userhandler = new UserHandler();
         saxParser.parse(inputFile, userhandler);  
         Allegato allegato = userhandler.allegato;
         stampa(allegato);
      } catch (Exception e) {
         e.printStackTrace();
      }
      
   }
   
   public static void stampa(Allegato allegato){
	   System.out.println("Nome Attachment: "+allegato.getNomeAttachment());
	   System.out.println("Formato Attachment: "+allegato.getFormatoAttachment());
	   System.out.println("Attachment: "+allegato.getAttachment());
	   String attachment = allegato.getAttachment();
	   
	   byte[] bytesEncoded = Base64.decodeBase64(attachment.getBytes());
	   
//	   byte[] octets = Base64.decodeBase64(bytesEncoded);
//	   writeFile(bytesEncoded);
//	   try {
//		FileUtils.writeByteArrayToFile(new File("C:\\Users\\Francesco Altarelli\\Documents\\file2"), bytesEncoded);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	   
	   try(OutputStream out = new FileOutputStream("filename3.pdf")){
		    out.write(bytesEncoded);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	  
	   
	   
	   
	   
   }
   
//public static void writeFile(byte[] bytesEncoded) {
//	String path = "C:/file.txt";
//	try {
//		File file = new File(path);
//		FileWriter fw = new FileWriter(file);
//		fw.write(bytesEncoded);
//		fw.flush();
//		fw.close();
//	}
//	catch(IOException e) {
//		e.printStackTrace();
//	}
//}
   
}


