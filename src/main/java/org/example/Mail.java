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
        emailSet.add("gratitude@sharegratitude.com");
        emailSet.add("pratiksha.kumari@bluethinkinc.com");
        emailSet.add("ashmita@hiringgo.com");
        emailSet.add("navyam@systechcorp.in");
        emailSet.add("jagriti.kumari@codersbrain.com");
        emailSet.add("Priyanka.agrawal@codersbrain.com");
        emailSet.add("hanu@gctechnologiess.com");
        emailSet.add("ahmed.abdelmoniem@refilex.com");

        for (String email : emailSet) {
            email = email.toLowerCase();
//            if(email.charAt(0) != 'n') continue;
            // Replace these with your email credentials
            String senderEmail = "aniruddhamukherjee232@gmail.com";
            String appPassword = "qyeu hoqj hvqn suop";
            String recipientEmail = email;
            String applicantName = "Aniruddha Mukherjee";
            String currentCompany = "Data Core Systems Inc.";
            String previousCompany = "Quality and Testing Info Solutions Pvt. Ltd.";
            String contactInformation = "8918464772";
            String education = "Data Structures and Algorithms course at AccioJob";
            String degree = "Bachelor's degree in Computer Applications";

            String emailContent = "Dear Hiring Team,\n\n" +
                    "I hope this message finds you well. My name is " + applicantName +
                    ", and I am writing to express my interest in the Java Backend Developer position at your esteemed organization.\n\n" +
                    "Currently, I work at " + currentCompany +
                    ", where I lead a team of developers and QA testers to build enterprise-level software solutions. My work has significantly improved system scalability and performance, boosting customer satisfaction by 30%. Notably, I designed a scalable backend architecture using Java and Spring Boot, and integrated dynamic reporting using Jaspersoft. Additionally, I optimized backend operations by leveraging Oracle SQL and automated GST portal integrations.\n\n" +
                    "Previously, at " + previousCompany +
                    ", I developed and deployed 15+ RESTful APIs using Spring Boot and integrated MongoDB, improving data exchange and system performance. My leadership in requirement analysis helped reduce turnaround time by 30%.\n\n" +
                    "I have completed a comprehensive " + education +
                    " and hold a " + degree + ". My technical stack includes Java, Spring Boot, MongoDB, Redis, MySQL/Oracle SQL, JUnit, Mockito, Jasper Reports, and AWS.\n\n" +
                    "Please find my resume attached for your consideration. I would be excited to bring my experience and passion for backend development to your team. Looking forward to the opportunity to discuss how I can contribute to your projects.\n\n" +
                    "Thank you for your time and consideration.\n\n" +
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
                String filename = System.getProperty("user.home") + "/Documents/Aniruddha_Mukherjee.pdf"; // Replace with the actual file path
                DataSource source =  new FileDataSource(filename);
                messageBodyPart.setDataHandler(new DataHandler((javax.activation.DataSource) source));
                messageBodyPart.setFileName("Aniruddha_Mukherjee.pdf");
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
