package ejb3.dao;

import ejb3.model.Message;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Stateless
public class MessageDaoImpl implements MessageDao{

    private EntityManager entityManager = Persistence.createEntityManagerFactory("NetCracker").createEntityManager();

    public void saveMessage(Message message) {
        entityManager.persist(message);
    }

    public List<String> getBetween(Date start, Date end) {
        return entityManager.createNamedQuery(Message.GET_BETWEEN)
                .setParameter("start", start)
                .setParameter("end", end)
                .getResultList();
    }
}
