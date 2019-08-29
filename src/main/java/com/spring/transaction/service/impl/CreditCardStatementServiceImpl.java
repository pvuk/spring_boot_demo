package com.spring.transaction.service.impl;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.transaction.model.CreditCardStatement;
import com.spring.transaction.service.CreditCardStatementService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CreditCardStatementServiceImpl implements CreditCardStatementService {

	@Override
	public CreditCardStatement uploadStatement(MultipartFile file, String password) throws IOException {
		String filename = file.getOriginalFilename();
		
		byte[] bytes = file.getBytes();
		
		PDDocument document = PDDocument.load(bytes, password);
		PDPageTree pdPageTree = document.getPages();
        log.info("Total files to be converted -> "+ pdPageTree.getCount());

        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String text = pdfTextStripper.getText(document);
        log.info("Reading File Data of : {}", filename);
        log.info(text);
        
		return null;
	}

}
