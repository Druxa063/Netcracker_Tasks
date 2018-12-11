package jdbc.repository;

import jdbc.model.Department;
import jdbc.model.Employee;
import jdbc.util.DBUtil;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "JdbcDaoImpl")
public class JdbcDaoImpl implements JdbcDao {

    public JdbcDaoImpl() {
    }

    public void create(Employee employee) throws SQLException {
        try ( Connection connection = DBUtil.getConnection();
              PreparedStatement statement = connection.prepareStatement("INSERT INTO emp (ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, employee.getEname());
            statement.setString(2, employee.getJob());
            statement.setInt(3, employee.getMgr());
            statement.setDate(4, new Date(employee.getHireDate().getTime()));
            statement.setInt(5, employee.getSalary());
            statement.setInt(6, employee.getComm());
            statement.setInt(7, employee.getDept().getDeptno());
            statement.execute();
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection connection = DBUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM emp WHERE empno = ?")) {
            statement.setInt(1, id);
            statement.execute();
        }
    }

    public void update(Employee employee) throws SQLException {
        try (Connection connection = DBUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE emp SET  " +
                    "ENAME=?, JOB=?, MGR=?, SAL=?, COMM=?, DEPTNO=? WHERE EMPNO=?")) {
            statement.setString(1, employee.getEname());
            statement.setString(2, employee.getJob());
            statement.setInt(3, employee.getMgr());
            statement.setInt(4, employee.getSalary());
            statement.setInt(5, employee.getComm());
            statement.setInt(6, employee.getDept().getDeptno());
            statement.setInt(7, employee.getEmpno());
            statement.execute();
        }
    }

    public Employee getById(int id) throws SQLException {
        Employee employee = null;
        try (Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM emp LEFT JOIN dept ON emp.deptno=dept.deptno WHERE empno=?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee = createEmployeeFromResultSet(resultSet);
            }
        }
        return employee;
    }

    public List<Employee> getAll() throws SQLException {
        List<Employee> list = new ArrayList<Employee>();
        try (Connection connection = DBUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM emp LEFT JOIN dept ON emp.deptno=dept.deptno")) {
            while (resultSet.next()) {
                list.add(createEmployeeFromResultSet(resultSet));
            }
        }
        return list;
    }

    private Employee createEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        Department department = new Department();
        employee.setEmpno(resultSet.getInt(1));
        employee.setEname(resultSet.getString(2));
        employee.setJob(resultSet.getString(3));
        employee.setMgr(resultSet.getInt(4));
        employee.setHireDate(resultSet.getDate(5));
        employee.setSalary(resultSet.getInt(6));
        employee.setComm(resultSet.getInt(7));
        department.setDeptno(resultSet.getInt(8));
        department.setDname(resultSet.getString(10));
        department.setLoc(resultSet.getString(11));
        employee.setDept(department);
        return employee;
    }
}
