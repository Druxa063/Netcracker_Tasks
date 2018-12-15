package ejb3;

import ejb3.service.MessageGetLocal;
import ejb3.service.MessageSendTextRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class MessageServlet extends HttpServlet {

    @EJB
    private MessageSendTextRemote messageSendTextRemote;

    @EJB
    private MessageGetLocal messageGetLocal;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime localStart = LocalDateTime.parse(req.getParameter("start"));
        LocalDateTime localEnd = LocalDateTime.parse(req.getParameter("end"));
        Date start = Date.from(localStart.toInstant(ZoneOffset.UTC));
        Date end = Date.from(localEnd.toInstant(ZoneOffset.UTC));
        req.setAttribute("list", messageGetLocal.getBetween(start, end));
        req.getRequestDispatcher("/ejb3list.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        messageSendTextRemote.send(text);
        resp.sendRedirect("/ejb3send.jsp");
    }
}
