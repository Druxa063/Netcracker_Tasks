package xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 28.09.2018.
 */
@XmlType(propOrder = {"subjects", "average"},name = "student")
public class Student {

    private String firstName;
    private String lastName;
    private String groupNumber;
    private double average;
    private List<Subject> subjects;

    public Student() {
        subjects = new ArrayList<>();
    }

    public Student(Subject... subjects) {
        this.subjects = Arrays.asList(subjects);
    }

    @XmlElements(@XmlElement(name = "subject", type = Subject.class))
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @XmlAttribute(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlAttribute(name = "lastname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlAttribute(name = "groupnumber")
    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void checkAverage() {
        int sum = 0;
        for (Subject subject : subjects) {
            sum += Integer.parseInt(subject.getMark());
            System.out.println(subject);
        }
        double localAverage = (double) sum/subjects.size();
        System.out.println("actual average " + localAverage);
        if (localAverage != average) {
            setAverage(localAverage);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", groupNumber='" + groupNumber + '\'' +
                ", average=" + average +
                '}';
    }
}