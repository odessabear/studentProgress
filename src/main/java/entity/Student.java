package entity;

import java.sql.Timestamp;

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

    public void setInDate() {
        this.inDate = inDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
        if (group != null ? !group.equals(student.group) : student.group != null) return false;
        return inDate != null ? inDate.equals(student.inDate) : student.inDate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (inDate != null ? inDate.hashCode() : 0);
        return result;
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
