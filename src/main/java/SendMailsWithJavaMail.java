import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Zhao Qing on 2018/1/7.
 * 使用java mail发送邮件
 */
public class SendMailsWithJavaMail {
    public static void main(String[] args){
        String to = "790127914@qq.com";//收件人
        String from = "walkingzq@163.com";//发件人
        String password = "bupt2016";//发件人邮箱密码
        String host = "smtp.163.com";//邮件发送主机

        Properties properties = System.getProperties();//获取系统属性
        properties.setProperty("mail.smtp.host", host);//设置邮件服务器
        properties.setProperty("mail.transport.protocol", "smtp");//协议设置

        //ssl开启
//        properties.setProperty("mail.smtp.port", "465");
//        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
//        properties.setProperty("mail.smtp.socketFactory.port", "465");

        Session session = Session.getDefaultInstance(properties);//获取默认session对象
        session.setDebug(true);

        try{
            MimeMessage message = new MimeMessage(session);//创建默认的MimeMessage对象
            message.setFrom(new InternetAddress(from));
            message.setSubject("邮件测试");//邮件主题
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setText("hello world");

            Transport transport = session.getTransport();//获取Transport对象
            transport.connect(from, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("邮件发送成功！");

        }catch (MessagingException exc){
            System.out.println("邮件发送失败！");
            exc.printStackTrace();
        }
    }
}
