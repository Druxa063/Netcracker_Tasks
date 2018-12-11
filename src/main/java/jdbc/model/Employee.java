package jdbc.model;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "EMP")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "empno")
    private Integer empno;

    @Column(name = "ename")
    private String ename;

    @Column(name = "job")
    private String job;

    @Column(name = "mgr")
    private Integer mgr;

    @Column(name = "hiredate")
    private Date hireDate;

    @Column(name = "sal")
    private Integer salary;

    @Column(name = "comm")
    private Integer comm;

    @ManyToOne()
    @JoinColumn(name = "deptno")
    private Department dept;

    public Employee() {
    }

    public Employee(Integer empno, String ename, String job, Integer mgr, Date hireDate, Integer salary, Integer comm, Department dept) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hireDate = hireDate;
        this.salary = salary;
        this.comm = comm;
        this.dept = dept;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getComm() {
        return comm;
    }

    public void setComm(Integer comm) {
        this.comm = comm;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}
