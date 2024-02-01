package com.example.demo.services;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class EmailService {
	
    @Autowired
    private JavaMailSender javaMailSender;	
    
    public void sendEmailWithAttachment(String receiver,String sender, String subject, String text, JasperPrint jasperReport) {
    		    try {
    		    	MimeMessage message = javaMailSender.createMimeMessage();   
        		    MimeMessageHelper helper = new MimeMessageHelper(message, true);
        		    
        		    helper.setFrom(sender);
        		    helper.setTo(receiver);
        		    helper.setSubject(subject);
					helper.setText(text);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
		            JasperExportManager.exportReportToPdfStream(jasperReport, baos);

		            ByteArrayDataSource dataSource = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
		            helper.addAttachment("zaduzenjaZaKnjige.pdf", dataSource);
        		    javaMailSender.send(message);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		        
    		
    		}
}