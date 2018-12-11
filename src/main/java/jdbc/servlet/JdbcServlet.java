package jdbc.servlet;

import jdbc.model.Department;
import jdbc.model.Employee;
import jdbc.repository.JdbcDao;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class JdbcServlet extends HttpServlet {

    @EJB(beanName = "JPADaoImpl")
    private JdbcDao jdbcDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if (action != null) {
                if(action.equalsIgnoreCase("delete")) {
                    jdbcDao.delete(getId(req));
                    req.setAttribute("emps", jdbcDao.getAll());
                } else if (action.equalsIgnoreCase("update")) {
                    req.setAttribute("emp", jdbcDao.getById(getId(req)));
                } else if (action.equalsIgnoreCase("find")) {
                    req.setAttribute("emps", Arrays.asList(jdbcDao.getById(getId(req))));
                }
            } else {
                req.setAttribute("emps", jdbcDao.getAll());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher view = req.getRequestDispatcher("/list.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();
        String empno = req.getParameter("empno");
        employee.setEname(req.getParameter("ename"));
        employee.setJob(req.getParameter("job"));
        employee.setMgr(Integer.parseInt(req.getParameter("mgr")));
        try {
            Date hiredate = new SimpleDateFormat("dd-MM-YYYY").parse(req.getParameter("hiredate"));
            employee.setHireDate(hiredate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setSalary(Integer.parseInt(req.getParameter("salary")));
        employee.setComm(Integer.parseInt(req.getParameter("comm")));
        employee.setDept(new Department(Integer.parseInt(req.getParameter("deptno"))));
        try {
            if(empno == null || empno.isEmpty()) {
                jdbcDao.create(employee);
            } else {
                employee.setEmpno(Integer.parseInt(empno));
                jdbcDao.update(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("jdbcServlet");
    }

    private int getId(HttpServletRequest req) {
        return Integer.parseInt(req.getParameter("id"));
    }
}
