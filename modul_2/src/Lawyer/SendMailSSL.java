package Lawyer;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Klasa odpowiadajaca za wysylanie e-maili zawierajacych czesci sekretu do spadkobiercow.
 *
 */
public class SendMailSSL {

	/**
	 * Metoda odpowiadajaca za wysylanie wiadomosci e-mail zawierajacych czesci sekretu do spadkobiercow.
	 * @param recipient
	 * Lancuch znakowy stanowiacy adres e-mail odbiorcy wiadomosci e-mail.
	 * @param subject
	 * Lancuch znakowy stanowiacy temat wiadomosci e-mail.
	 * @param content
	 * Lancuch znakowy stanowiacy tresc wiadomosci e-mail.
	 * @param attachmentName
	 * Lancuch znakowy stanowiacy nazwe pliku bedacego zalacznikiem do wiadomosci e-mail.
	 * @param attachmentPath
	 * Lancuch znakowy stanowiacy sciezke do pliku bedacego zalacznikiem do wiadomosci e-mail.
	 */
	public void sendEmail(String recipient, String subject, String content, String attachmentName, String attachmentPath) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("alicjakryptograficzna","Staracyganka");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("eclipse"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recipient));
			message.setSubject(subject);
			
			
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	        MimeBodyPart messageBodyPart1 = new MimeBodyPart();

	        Multipart multipart = new MimeMultipart();
	        
	        DataSource source = new FileDataSource(attachmentPath);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(attachmentName);
	        
	        messageBodyPart1.setText(content);
	        
	        
	        multipart.addBodyPart(messageBodyPart);
	        multipart.addBodyPart(messageBodyPart1);
	        
	        message.setContent(multipart);


	        System.out.println("Sending");
	        
			Transport.send(message);
			// LawyerConfig.success = true;
			System.out.println("Done");

		} catch (MessagingException e) {
			LawyerConfig.success = false;
		}
	}
}
	