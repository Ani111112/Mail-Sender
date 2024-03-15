package org.example;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.*;

public class Mail {
    public void mailSender() {
        TreeSet<String> emailSet = new TreeSet<>();
        emailSet.add("skannekanti@unocareer.com");
        emailSet.add("krithika.bharatraj@cerner.com");
        emailSet.add("gtomar@eteaminc.com");
        emailSet.add("ibrahim@tekishub.com");
        emailSet.add("nadia.taha@dxc.com");
        emailSet.add("satheesh@infowaygroup.com");
        emailSet.add("venkatasatyasri.golakoti@fenixcommerce.ai");
        emailSet.add("kaibalya.das@flipkart.com");
        emailSet.add("Palak.gupta@globussoft.com");
        emailSet.add("hr@shreedhanya.co.in");
        emailSet.add("vishal.sharma@whizglobal.com");
        emailSet.add("divya.ra@twsol.com");
        emailSet.add("anchal@mindaspire.in");
        emailSet.add("sridhar.valmiki@in.nestle.com");
        emailSet.add("vinay.k@quadranttechnologies.com");
        emailSet.add("shireesha.b@aspiredsolutions.com");
        emailSet.add("Shalini.jain@sunmobility.com");
        emailSet.add("aravind.botla@innovapptive.com");
        emailSet.add("praneetha.u@ncs-india.com");
        emailSet.add("Ishareddy261@gmail.com");
        emailSet.add("aftab@convextech.com");
        emailSet.add("akshay@magicforce.us");
        emailSet.add("prathamgholaphr@gmail.com");
        emailSet.add("hanshika@vyzeinc.com");
        emailSet.add("gowthami@precisiontechcorp.com");
        emailSet.add("durgasravani.nekkanti@cloudangles.com");
        emailSet.add("hemalatha@partner.hindustantimes.com");
        emailSet.add("ibrahim@tekishub.com");
        emailSet.add("aftab@convextech.com");
        emailSet.add("karthik@ritwikinfotech.com");
        emailSet.add("gokul.p@twsol.com");
        emailSet.add("vinod@talentola.com");
        emailSet.add("christy@sun-itsolutions.com");
        emailSet.add("resin@thepuretalent.com");
        emailSet.add("varun@infowaygroup.com");
        emailSet.add("vineel@smartfolksinc.com");

        for (String email : emailSet) {
            email = email.toLowerCase();
//            if(email.charAt(0) != 'n') continue;
            // Replace these with your email credentials
            String senderEmail = "aniruddhamukherjee232@gmail.com";
            String appPassword = "sszv fvjp hzsy iaby";
            String recipientEmail = email;
            String applicantName = "Aniruddha Mukherjee";
            String currentCompany = "Quality and Testing Info Solutions Pvt. Ltd.";
            String achievements = "optimizing data retrieval using MongoDB and leading a critical migration initiative. Additionally, I introduced a comprehensive Redis cache system from scratch.";
            String education = "Data Structure and Algorithm course at AccioJob";
            String degree = "Bachelor's degree in Computer Application";
            String contactInformation = "8918464772";

            String emailContent = "Dear Hiring Team,\n\n" +
                    "I trust this message finds you well. I am " + applicantName +
                    ", expressing my interest in the Java Backend Developer position within your organization.\n\n" +
                    "In my current role at " + currentCompany +
                    ", I've played a pivotal role in developing robust Java and Spring Boot applications, contributing to successful project execution. Notable achievements include " + achievements + "\n\n" +
                    "I have completed a comprehensive " + education +
                    " and hold a " + degree + ".\n\n" +
                    "My expertise also extends to database management systems such as MongoDB and MySQL, where I've effectively implemented optimized solutions.\n\n" +
                    "Kindly find my attached resume for your consideration. I am eager to discuss how my skills can benefit your team.\n\n" +
                    "Thank you for your time.\n\n" +
                    "Best regards,\n\n" +
                    applicantName + "\n" +
                    contactInformation;

            // Email configuration
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            // Authenticate sender
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmail, appPassword);
                }
            });

            try {
                // Create a message
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(senderEmail));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
                message.setSubject("Application for Java Backend Developer Position");

                // Create the message part
                BodyPart messageBodyPart = new MimeBodyPart();

                // Now set the actual message
                messageBodyPart.setText(emailContent);

                // Create a multipart message
                Multipart multipart = new MimeMultipart();

                // Set text message part
                multipart.addBodyPart(messageBodyPart);

                // Part two is attachment
                messageBodyPart = new MimeBodyPart();
                String filename = "D:/Personal Work/Aniruddha CV.pdf"; // Replace with the actual file path
                DataSource source =  new FileDataSource(filename);
                messageBodyPart.setDataHandler(new DataHandler((javax.activation.DataSource) source));
                messageBodyPart.setFileName("Aniruddha CV.pdf");
                multipart.addBodyPart(messageBodyPart);

                // Send the complete message parts
                message.setContent(multipart);

                // Send message
                Transport.send(message);
//                System.out.println("OTP sent successfully!");
                System.out.println(email);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
