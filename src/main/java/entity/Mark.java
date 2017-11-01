package entity;

import java.util.Objects;

public class Mark {
    private int id;
    private int idStudent;
    private int idTermDiscipline;
    private int mark;

    public Mark() {
    }

    public Mark(int id, int idStudent, int idTermDiscipline, int mark) {
        this.id = id;
        this.idStudent = idStudent;
        this.idTermDiscipline = idTermDiscipline;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdTermDiscipline() {
        return idTermDiscipline;
    }

    public void setIdTermDiscipline(int idTermDiscipline) {
        this.idTermDiscipline = idTermDiscipline;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark1 = (Mark) o;
        return id == mark1.id &&
                idStudent == mark1.idStudent &&
                idTermDiscipline == mark1.idTermDiscipline &&
                mark == mark1.mark;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idStudent, idTermDiscipline, mark);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", idStudent=" + idStudent +
                ", idTermDiscipline=" + idTermDiscipline +
                ", mark=" + mark +
                '}';
    }
}

