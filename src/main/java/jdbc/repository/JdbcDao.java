package jdbc.repository;

import jdbc.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface JdbcDao {

    void create(Employee employee) throws SQLException;

    void delete(int id) throws SQLException;

    void update(Employee employee) throws SQLException;

    Employee getById(int id) throws SQLException;

    List<Employee> getAll() throws SQLException;
}
