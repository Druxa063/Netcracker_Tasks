package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 28.09.2018.
 */
@XmlType(name = "group")
@XmlRootElement
public class Group {

    private List<Student> students;

    public Group() {
        students = new ArrayList<>();
    }

    public Group(Student... students) {
        this.students = Arrays.asList(students);
    }

    @XmlElements(@XmlElement(name = "student", type = Student.class))
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void checkAverage() {
        for (Student student : students) {
            System.out.println("\nbefore " + student);
            student.checkAverage();
            System.out.println("after " + student);
        }
    }
}
