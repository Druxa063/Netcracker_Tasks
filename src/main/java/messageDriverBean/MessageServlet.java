package messageDriverBean;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageServlet extends HttpServlet {

    @EJB
    MessageDao dao;

    @Resource(name="jms/NetCracker")
    private ConnectionFactory connectionFactory;

    @Resource(name= "jms/topicNetCracker")
    private Destination destination;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("messages", dao.getAllMessage());
        req.getRequestDispatcher("messageBean.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        sendMessage(text);
        resp.sendRedirect(req.getContextPath() + "/messageBean");
    }

    private void sendMessage(String text) {
//        нету AutoCloseable
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage(text);
            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
