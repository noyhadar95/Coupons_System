package bl_backend;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

	private String smtpHost;

	public EmailSender() {
		smtpHost = "smtp.gmail.com";
	}

	public boolean sendEmail(String to, String from, String subject, String text) {
		boolean successFlag = true;
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.host", smtpHost);
			Session emailSession = Session.getDefaultInstance(properties);

			Message emailMessage = new MimeMessage(emailSession);
			emailMessage.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to));
			// emailMessage.addRecipient(Message.RecipientType.CC,
			// new InternetAddress(cc));
			emailMessage.setFrom(new InternetAddress(from));
			emailMessage.setSubject(subject);
			emailMessage.setText(text);

			emailSession.setDebug(true);

			Transport.send(emailMessage);
		} catch (AddressException e) {
			successFlag = false;
		} catch (MessagingException e) {
			successFlag = false;
		}

		return successFlag;
	}

}
