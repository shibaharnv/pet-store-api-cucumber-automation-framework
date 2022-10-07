package utilities;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Email {

    public static String TestCount;
    public static String Reporturl;


    private static void readTextfile() throws IOException {

        FileReader fr = new FileReader(System.getProperty("user.dir") + "/mavenlogs.txt");
        BufferedReader br = new BufferedReader(fr);
        String str;
        while ((str = br.readLine()) != null) {

            if (str.contains("https://reports.cucumber.io/reports")) {
                str = str.trim();
                str = str.replaceAll("\\s", "");
                String result = str.split("h")[1];
                result = "h" + result;
                result = result.split("\\[")[0];
                Reporturl = result;
                System.out.println("Reporturl :" + Reporturl);
            }

        }

    }

    public static void emailTrigger(String recipient) throws IOException {

        readTextfile();
        // Create object of Property file
        Properties props = new Properties();

        // this will set host of server- you can change based on your requirement
        props.put("mail.smtp.host", "smtp.gmail.com");

        // set the port of socket factory
        props.put("mail.smtp.socketFactory.port", "465");

        // set socket factory
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

        // set the authentication to true
        props.put("mail.smtp.auth", "true");

        // set the port of SMTP server
        props.put("mail.smtp.port", "465");

        // This will handle the complete authentication
        Session session = Session.getDefaultInstance(props,

                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication("shibaharautomation@gmail.com", "dayawqeeisdvwkmv");

                    }

                });

        try {

            // Create object of MimeMessage class
            Message message = new MimeMessage(session);

            // Set the from address
            message.setFrom(new InternetAddress("simpuudemy@gmail.com"));

            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(recipient));

            // Add the subject link
            message.setSubject("Restful-booker-api Automation Report");



            BodyPart messageBodyPart1 = new MimeBodyPart();

            String messagtosend = "Hi,"
                    + "<br><br><b>Please click on the below link to view the test results    </b>"
                    + "<br><br>";

            String regards = ""
                    + "<br><br>Regards,"
                    + "<br>Shibahar Nagarajan";

            messageBodyPart1.setContent(messagtosend, "text/html; charset=utf-8");


            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            MimeBodyPart messageBodyPart3 = new MimeBodyPart();

            String reportLink =Reporturl;
            messageBodyPart2.setText(reportLink);
            messageBodyPart3.setContent(regards,"text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();

            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart2);
            multipart.addBodyPart(messageBodyPart3);

            message.setContent(multipart);


            // finally send the email
            Transport.send(message);

            System.out.println("=====Email Sent=====");

        } catch (MessagingException e) {

            throw new RuntimeException(e);

        }

    }


}
