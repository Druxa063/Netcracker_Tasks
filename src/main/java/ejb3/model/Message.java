package ejb3.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "messagebean")
@NamedQueries({
        @NamedQuery(name = Message.GET_BETWEEN, query = "SELECT m.massage FROM Message m WHERE m.dateTime BETWEEN :start AND :end")
})
public class Message {

    public static final String GET_BETWEEN = "get.between";

    @Id
    @Column(name = "datemessage")
    private Date dateTime;

    @Column(name = "message")
    private String massage;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
