package messageDriverBean;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;
import javax.servlet.http.HttpServletRequest;

@Stateless
public class MessageClient {

    @Resource(name="jms/NetCracker")
    private ConnectionFactory connectionFactory;

    @Resource(name= "jms/topicNetCracker")
    private Destination destination;

    public void sendMessage(String text) {
//        нету AutoCloseable
//        Connection connection = null;
//        try {
//            connection = connectionFactory.createConnection();
//            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            MessageProducer producer = session.createProducer(destination);
//            producer.send(session.createTextMessage(text));
//        } catch (JMSException e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
