package kr.jetstream.mail.controller;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.stereotype.Repository;
@Repository
	public class AmazonSES  {

    static final String FROM = "no-reply@jetstream.kr";  
    static final String TO = "�޴� ���";   
                                                       
    static final String BODY = "����";
    static final String SUBJECT = "����";
    
    static final String SMTP_USERNAME = "AKIAIOI6MPOLUEUNKXNQ"; 
    static final String SMTP_PASSWORD = "As3fqPCjxo2TVM1zhLOXEZV1furedDDKzQD/39fHiDg+";  
    
    // �츮�� �����Ͼ�
    static final String HOST = "email-smtp.us-east-1.amazonaws.com";    
    
    static final int PORT = 25;
    
    //�ѱ�ó��
    static String encodingUth8 = "UTF-8";

    public void sendmail(String email, String name,String msg1) throws Exception {
    	System.out.println(email);
    	System.out.println(msg1);
    	
    	if(msg1.equals("welcome")){
    		msg1 = "jetstream�� ������ �����մϴ�.";
    	}
      
    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", PORT); 
    	
  
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.starttls.required", "true");
 
    	Session session = Session.getDefaultInstance(props);

        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        msg.setSubject(msg1);
        msg.setContent("welcome to jetstream : " + name + "���� ������ �����մϴ�!","text/plain; charset=" + encodingUth8);
            
              
        Transport transport = session.getTransport();
      
        try
        {
            System.out.println("Attempting to send an email through the Amazon SES SMTP interface...");

            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally
        {
            transport.close();        	
        }
    }
    
    public void sendmail02(String email, String password, String name, String msg2) throws Exception {
    	System.out.println(email);
    	System.out.println(password);
    	System.out.println(msg2);
    	
    	if(msg2.equals("findPass")){
    		msg2 = "jetstream ��й�ȣ ã��";
    	}
        
    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", PORT); 
    	
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.starttls.required", "true");
 
    	Session session = Session.getDefaultInstance(props);

        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        msg.setSubject(msg2);
        msg.setContent(name + "���� ��й�ȣ : " + password + " �Դϴ�.","text/plain; charset=" + encodingUth8);
               
        Transport transport = session.getTransport();
        
        try
        {
            System.out.println("Attempting to send an email through the Amazon SES SMTP interface...");

            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
        	
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally
        {
            transport.close();        	
        }
    }
}