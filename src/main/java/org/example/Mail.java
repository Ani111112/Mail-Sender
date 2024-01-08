package org.example;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Mail {
    public void mailSender() {
        List<String> emailList = Arrays.asList(
                "hrmukta.hiring1@gmail.com",
                "apply@mhtechin.com",
                "Rucha.Desai@ril.com",
                "divyani.ghadi@ril.com",
                "divya.tagaya@codiant.com",
                "bhavnavashistha@bdo.in",
                "srivastavarajat1997@gmail.com",
                "ritika.singh1@genpact.com",
                "mayank.verma@indoautotech.com",
                "hr.ctinfotech@gmail.com",
                "megha.g@anikatechnologies.com",
                "hr@techmologics.com",
                "cacenquiry@voltas.com",
                "anjali.shashi@polycab.com",
                "hr@jaypee.in",
                "hrd@tantiagroup.com",
                "jobs@tantiagroup.com",
                "narayanan@vizhinjamport.in",
                "sathypal@vizhinjamport.in",
                "mkcilhrm@gmail.com",
                "hraudit@mkcinfrastructureltd.com",
                "sampanna@afcons.com",
                "hr@afcons.com",
                "career@apcoinfra.com",
                "hr@apcoinfra.com",
                "ashwini.pareek@hginfra.com",
                "hrd@pncinfratech.com",
                "hr@pncinfratech.com",
                "hr@barbrikindia.com",
                "Varsha@barbrikindia.com",
                "bipin.c@grinfra.com",
                "career@grinfra.com",
                "hr@grinfra.com",
                "Riyaz.ahmed@siemens.com",
                "careers@gayatri.co.in",
                "preeti.sharma@aecom.com",
                "shreejiinfrajbp@gmail.com",
                "binkal.patel@mclindia.com",
                "kcc.del@gmail.com",
                "hrd@kccbuildcon.co.in",
                "moosa.sayed@hccindia.com",
                "sunil.sarna@ashokabuildcon.com",
                "careers@gammonindia.com",
                "jobs@rkc.co.in",
                "dharmendra.kori@jkumar.com",
                "hr@tataprojects.in",
                "hr@lninfra.com",
                "insoniya254@gmail.com",
                "careers@pdcegroup.com",
                "hr@liongroup.in",
                "vganesh@sheladia.co.in",
                "jobs@sheladia.com",
                "career@pcsindia.com",
                "poojakatyal@sainfra.com",
                "careers@satragroup.in",
                "happyn@satragroup.in",
                "vasanthi.nair@ictonline.com",
                "hr@regnanttechnologies.com",
                "hr@arysontechnologies.com",
                "jobs@Zettabolt.com",
                "EEO.Compliance@spglobal.com"
        );

        for (String email : emailList) {
            // Replace these with your email credentials
            String senderEmail = "aniruddhamukherjee232@gmail.com";
            String appPassword = "sszv fvjp hzsy iaby";
            String recipientEmail = email;
            String applicantName = "Aniruddha Mukherjee";
            String currentCompany = "Quality and Testing Info Solutions Pvt. Ltd.";
            String achievements = "optimizing data retrieval using MongoDB and leading a critical migration initiative.";
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
                String filename = "D:/Personal Work/Aniruddha_Mukherjee_CV.pdf"; // Replace with the actual file path
                DataSource source =  new FileDataSource(filename);
                messageBodyPart.setDataHandler(new DataHandler((javax.activation.DataSource) source));
                messageBodyPart.setFileName("Aniruddha_Mukherjee_CV.pdf");
                multipart.addBodyPart(messageBodyPart);

                // Send the complete message parts
                message.setContent(multipart);

                // Send message
                Transport.send(message);
                System.out.println("OTP sent successfully!");
                System.out.println(email);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
