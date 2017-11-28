package dto;

import java.util.Objects;

public class SelectedTermAndDiscipline {
    private Integer termId;
    private Integer disciplineId;

    public SelectedTermAndDiscipline(Integer termId, Integer disciplineId) {
        this.termId = termId;
        this.disciplineId = disciplineId;
    }

    public Integer getTermId() {
        return termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
    }

    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectedTermAndDiscipline that = (SelectedTermAndDiscipline) o;
        return Objects.equals(termId, that.termId) &&
                Objects.equals(disciplineId, that.disciplineId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(termId, disciplineId);
    }

    @Override
    public String toString() {
        return "SelectedTermAndDiscipline{" +
                "termId=" + termId +
                ", disciplineId=" + disciplineId +
                '}';
    }
}
