package ejb3.dao;


import ejb3.model.Message;

import javax.ejb.Remote;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Remote
public interface MessageDao {

    void saveMessage(Message message);

    List<String> getBetween(Date start, Date end);
}
