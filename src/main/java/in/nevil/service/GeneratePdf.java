package in.nevil.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdf {
	
	  public static void main(String[] args) throws FileNotFoundException {
		
	
	   //public static void ticketPDFGenerator() throws FileNotFoundException {
		   
		   Document document = new Document();
	   try {
		   PdfWriter writer =PdfWriter.getInstance(document, new FileOutputStream(new File("eTicket.Pdf")));
		   document.open();
		   document.add(new Paragraph("E-Ticket Summary "));
		   document.close();
		   writer.close();
	   }
	   catch(DocumentException e) {
		   e.printStackTrace();
	   }
	   }
}
