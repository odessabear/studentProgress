package entity;

import java.sql.Timestamp;
import java.util.Objects;

public class Student {
    private long id;
    private String name;
    private String surname;
    private String group;
    private Timestamp inDate;

    public Student() {
    }

    public Student(long id, String name, String surname, String group, Timestamp inDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.inDate = inDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Timestamp getInDate() {
        return inDate;
    }

    public void setInDate(Timestamp inDate) {
        this.inDate = inDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(group, student.group) &&
                Objects.equals(inDate, student.inDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, group, inDate);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group='" + group + '\'' +
                ", inDate=" + inDate +
                '}';
    }
}
