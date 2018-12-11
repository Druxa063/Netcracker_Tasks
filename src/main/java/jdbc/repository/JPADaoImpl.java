package jdbc.repository;

import jdbc.model.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Stateless(name = "JPADaoImpl")
public class JPADaoImpl implements JdbcDao {

    EntityManager entityManager = Persistence.createEntityManagerFactory("NetCracker").createEntityManager();

    @Override
    public void create(Employee employee) throws SQLException {
        entityManager.persist(employee);
    }

    @Override
    public void delete(int id) throws SQLException {
        entityManager.remove(getById(id));
    }

    @Override
    public void update(Employee employee) throws SQLException {
        entityManager.merge(employee);
    }

    @Override
    public Employee getById(int id) throws SQLException {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }
}
