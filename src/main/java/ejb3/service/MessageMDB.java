package ejb3.service;

import ejb3.dao.MessageDao;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.time.LocalDateTime;
import java.util.Date;

@MessageDriven(mappedName="jms/topicNetCracker")
public class MessageMDB implements MessageListener {

    @EJB
    MessageDao dao;

    @Override
    public void onMessage(Message message) {
        ejb3.model.Message m = new ejb3.model.Message();
        try {
            m.setDateTime(new Date(message.getJMSTimestamp()));
        } catch (JMSException e) {
            e.printStackTrace();
        }
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                m.setMassage(textMessage.getText());
                dao.saveMessage(m);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        } else {
            m.setMassage("Wrong message type!");
            dao.saveMessage(m);
        }
    }
}
