package utilities.email;

import org.apache.commons.mail.*;
import org.apache.commons.net.imap.IMAPClient;
import org.apache.commons.net.imap.IMAPSClient;

import java.io.IOException;

public class EmailManager {

    public static void SendEmail(String EmailFrom, String EmailTo, String EmailSubject, String EmailMessage, String PathToAttachment, String DescriptionOfAttachment) throws EmailException {

        MultiPartEmail email = new MultiPartEmail();
        EmailAttachment attachment = new EmailAttachment();

        attachment.setPath(PathToAttachment);
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription(DescriptionOfAttachment);

        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("raul93611@gmail.com", "Qa@utomation"));
        email.setSSLOnConnect(true);
        email.setFrom(EmailFrom);
        email.setSubject(EmailSubject);
        email.setMsg(EmailMessage);
        email.addTo(EmailTo);
        //email.addCc("");
        email.attach(attachment);
        email.send();

        System.out.print("Email Sent\n");
    }

    public static int CheckEmail(String emailSubject, String username, String password) throws IOException {
        IMAPClient email = new IMAPSClient(true);

        int i = 0;

        try {
        email.connect("imap.gmail.com", 993);
        email.login(username, password);


        while (!email.getReplyString().contains(emailSubject)) {
            email.select("INBOX");
            email.fetch("1:1","body[header.fields (Subject)]");
            i++;
            if (i == 75) {
                return i;
            }
        }} catch (IOException e) {
            e.printStackTrace();
        } finally {
            email.copy("1:1","[Gmail]/Trash");
            email.logout();
            email.disconnect();
        }
        return i;
    }
}


