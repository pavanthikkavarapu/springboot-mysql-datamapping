package com.example.basicapp.view;
import java.io.File;
import java.io.FileNotFoundException;

import com.itextpdf.io.IOException;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
public class MyPdfView {
	  public static final String DEST = "D:\\dev\\DAL\\MyMLC1.pdf";
      
      public static void main(String args[]) throws IOException {
          File file = new File(DEST);
          file.getParentFile().mkdirs();
          try {
              new MyPdfView().createPdf(DEST);
          } catch (FileNotFoundException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } catch (java.io.IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
      }
      
      public void createPdf(String dest) throws IOException, java.io.IOException {
          
          PdfWriter writer = new PdfWriter(dest);
          PdfDocument pdf = new PdfDocument(writer);
          Document document = new Document(pdf);
          // Create a PdfFont
          PdfFont fontBold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
          PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
          
          // Add a Paragraph
          document.add(new Paragraph("MORTGAGE LOAN COMMITMENT")
                  .setTextAlignment(TextAlignment.CENTER)
                  .setFont(fontBold).setFontSize(14));
          
          document.add(new Paragraph("HOMESTEAD MORTGAGE CORPORATION1 WIT")
                  .setTextAlignment(TextAlignment.CENTER)
                  .setFont(font).setFontSize(10));

          document.add(new Paragraph("26400, LAHSER RD1, SOUTHFIELD OH 48071 ")
                  .setTextAlignment(TextAlignment.CENTER)
                  .setFont(font).setFontSize(10));
      
          document.add(new Paragraph("Loan Number :A552")
                  .setTextAlignment(TextAlignment.LEFT)
                  .setFont(font).setFontSize(10));
      
          document.add(new Paragraph("Date : Jan 12, 2017")
                  .setTextAlignment(TextAlignment.LEFT)
                  .setFont(font).setFontSize(10));

          document.add(new Paragraph("To :")
                  .setTextAlignment(TextAlignment.LEFT)
                  .setFont(font).setFontSize(10));

          document.add(new Paragraph("Property Address :")
                  .setTextAlignment(TextAlignment.LEFT)
                  .setFont(font).setFontSize(10));
          
          document.add(new Paragraph("We are pleased to inform you that your mortgage loan application has been     Final Approved    , subject to the following terms and conditions")
                  .setTextAlignment(TextAlignment.LEFT)
                  .setFont(font).setFontSize(10));
          

          document.close();
          
          System.out.println("Successfully created");
  }       

}
