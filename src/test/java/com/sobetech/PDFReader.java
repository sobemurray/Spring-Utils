/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Team Focus / Peak6, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;

/**
 *
 *
 * @author John Murray
 *
 * @since Aug 8, 2024
 *
 */
public class PDFReader
{
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@SuppressWarnings("resource")
	@Test
	public void givenSamplePdf_whenUsingApachePdfBox_thenCompareOutput() throws IOException 
	{
		System.out.println("######### Using PDFBox #########");
		// Use try-with-resources so the streams will close
		try(PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile("src/test/resources/2023_01_GB_CHI.pdf")))
		{
			
			PDFTextStripper stripper = new PDFTextStripper();
			
			for (PDPage page : document.getPages())
			{
				boolean hasContents = page.hasContents();
				LOG.debug("Page has contents", hasContents);

			}
			
			//stripper.setStartPage(1);
			//stripper.setEndPage(2);
			
			String text = stripper.getText(document);
			System.out.println(text);
			LOG.debug(text);
			document.close();
		}
	}
	
	@Test
	public void givenSamplePdf_whenUsingiTextPdf_LocationTextExtractionStrategy() throws IOException {
		System.out.println("######### Using iText #########");
	    
	    PdfReader reader = new PdfReader("src/test/resources/2023_01_GB_CHI.pdf");
	    int pages = reader.getNumberOfPages();
    	
    	boolean inPlayByPlay = false;

	    for (int i = 1; i <= pages; i++) {
	    	System.out.println("---- Page " + i + " iText - LocationTextExtractionStrategy ----");
	    	
	    	String pageText = PdfTextExtractor.getTextFromPage(reader, i, new LocationTextExtractionStrategy());
	    	
	    	if(pageText.contains("Play By Play"))
	    	{
	    		inPlayByPlay = true;
	    	}
	    	
	    	if(pageText.contains("Miscellaneous Statistics Report"))
	    	{
	    		inPlayByPlay = false;
	    	}
	    	
	    	if(inPlayByPlay)
	    	{
	    		System.out.println(pageText);
	    	}
	    	
			//System.out.println(PdfTextExtractor.getTextFromPage(reader, i, new SimpleTextExtractionStrategy()));

	    }
	    reader.close();
	    
	}
	
	@Test
	public void givenSamplePdf_whenUsingiTextPdf_SimpleTextExtractionStrategy() throws IOException {
		System.out.println("######### Using iText - SimpleTextExtractionStrategy #########");
	    
	    PdfReader reader = new PdfReader("src/test/resources/2023_01_GB_CHI.pdf");
	    int pages = reader.getNumberOfPages();

	    for (int i = 1; i <= pages; i++) {
	    	System.out.println("---- Page " + i + " iText - SimpleTextExtractionStrategy ----");
	    	
	    	String pageText = PdfTextExtractor.getTextFromPage(reader, i, new SimpleTextExtractionStrategy());
	    	
	    	if(pageText.contains("Play By Play"))
	    	{
	    		System.out.println(pageText);
	    	}
	    	
			//System.out.println(PdfTextExtractor.getTextFromPage(reader, i, new SimpleTextExtractionStrategy()));

	    }
	    reader.close();
	    
	}
}
