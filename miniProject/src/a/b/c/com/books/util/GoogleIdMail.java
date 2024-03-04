package a.b.c.com.books.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.jasper.tagplugins.jstl.core.Set;

import a.b.c.com.books.mem.vo.BooksMemVO;

import java.util.List;
public class GoogleIdMail {

public void idMail(String resiveMail, String tempId, String sendMsg) {
		
		String mailSubject = "아이디 찾기 메일 입니다.";
		System.out.println("googleMailSender resiveMail >>> "	 	+ resiveMail);
		System.out.println("googleMailSender sendMsg >>> : " 		+ sendMsg);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("kiwook4483@gmail.com", "fxlbhiyggykdwago");
			}
		});
		
		
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(resiveMail, "관리자", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(resiveMail));
			message.setSubject(mailSubject);
			message.setContent(sendMsg , "text/html; charset=utf-8");
			
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void main(String args[]) {
		
		BooksMemVO bmvo = new BooksMemVO();
		
		String resiveMail = "rhdqndyd121@gmail.com";
		String tempId = bmvo.getMbid(); 
		String sendMsg = "<h2 style='color:blue'>"+ bmvo.getMbid() +"</h2>";
		
		GoogleIdMail gms = new GoogleIdMail();
		gms.idMail(resiveMail, tempId, sendMsg);
	}
}