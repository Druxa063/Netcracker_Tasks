package messageDriverBean;

import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Date;

@MessageDriven(mappedName="jms/topicNetCracker")
public class MessageServer implements MessageListener {

    @EJB
    MessageDao dao;

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                dao.save(textMessage.getText(), textMessage.getJMSTimestamp());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        } else {
            dao.save("Wrong message type!", new Date().getTime());
        }
    }
}
