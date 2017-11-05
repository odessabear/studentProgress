package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Term {
    private int id;
    private String name;
    private int duration;
    private List<Discipline> disciplines = new ArrayList<>();

    public Term() {
    }

    public Term(int id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term = (Term) o;
        return id == term.id &&
                duration == term.duration &&
                Objects.equals(name, term.name) &&
                Objects.equals(disciplines, term.disciplines);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, duration, disciplines);
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", disciplines=" + disciplines +
                '}';
    }

    public void addDiscipline(Discipline discipline){
        disciplines.add(discipline);
    }
}
