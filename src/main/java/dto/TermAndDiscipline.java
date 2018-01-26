package dto;

import java.util.Objects;

public class TermAndDiscipline {

    private int idTermAndDiscipline;
    private int idDiscipline;

    public TermAndDiscipline(int idTermAndDiscipline, int idDiscipline) {
        this.idTermAndDiscipline = idTermAndDiscipline;
        this.idDiscipline = idDiscipline;
    }

    public TermAndDiscipline() {
    }

    public int getIdTermAndDiscipline() {
        return idTermAndDiscipline;
    }

    public void setIdTermAndDiscipline(int idTermAndDiscipline) {
        this.idTermAndDiscipline = idTermAndDiscipline;
    }

    public int getIdDiscipline() {
        return idDiscipline;
    }

    public void setIdDiscipline(int idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TermAndDiscipline that = (TermAndDiscipline) o;
        return idTermAndDiscipline == that.idTermAndDiscipline &&
                idDiscipline == that.idDiscipline;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTermAndDiscipline, idDiscipline);
    }

    @Override
    public String toString() {
        return "TermAndDiscipline{" +
                "idTermAndDiscipline=" + idTermAndDiscipline +
                ", idDiscipline=" + idDiscipline +
                '}';
    }
}
