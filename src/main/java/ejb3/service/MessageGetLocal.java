package ejb3.service;

import javax.ejb.Local;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Local
public interface MessageGetLocal {

    List<String> getBetween(Date start, Date end);
}
