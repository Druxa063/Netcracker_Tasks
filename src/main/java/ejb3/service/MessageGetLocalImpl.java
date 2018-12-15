package ejb3.service;

import ejb3.dao.MessageDao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Stateless
public class MessageGetLocalImpl implements MessageGetLocal {

    @EJB
    private MessageDao dao;

    @Override
    public List<String> getBetween(Date start, Date end) {
        return dao.getBetween(start, end);
    }
}
