package Correo;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Clase para enviar los correos necesarios
 *
 * @author Javier y Christian
 */
public class Correo {

    /**
     * Correo eléctronico emisor
     */
    public static String username = "***";
    /**
     * Contraseña del correo electrónico emisor
     */
    public static String password = "***";
    /**
     * DNI de la persona que envía el correo
     */
    private final String DNI;
    /**
     * Mensaje de renovación de contrato
     */
    String mensajeRenov = "Renovación de contrato solicitada por: ";
    /**
     * Mensaje de renuncia de contrato
     */
    String mensajeRenuncia = "Renuncia de contrato solicitada por: ";
    /**
     * Correo electrónico receptor
     */
    String to = "***";
    /**
     * Asunto del correo de renovación de contrato
     */
    String subjectRenov = "Renovación de contrato";
    /**
     * Asunto del correo de renuncia de contrato
     */
    String subjectRenun = "Renuncia de contrato";

    /**
     * Constructor de la clase Correo
     *
     * @param DNI
     */
    public Correo(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Método para enviar el mensaje de renuncia de contrato
     */
    public void renuncia() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subjectRenun);
            message.setText(mensajeRenuncia + DNI);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para enviar el mensaje de solicitud de renovación de contrato
     */
    public void renovacion() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subjectRenov);
            message.setText(mensajeRenov + DNI);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
