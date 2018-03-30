package dto;

import java.util.Objects;

public class TermDisciplineIdAndMarksValue {

    private int termDisciplineId;
    private int marksValue;

    public TermDisciplineIdAndMarksValue(int termDisciplineId, int marksValue) {
        this.termDisciplineId = termDisciplineId;
        this.marksValue = marksValue;
    }

    public TermDisciplineIdAndMarksValue() {
    }

    public int getTermDisciplineId() {
        return termDisciplineId;
    }

    public void setTermDisciplineId(int termDisciplineId) {
        this.termDisciplineId = termDisciplineId;
    }

    public int getMarksValue() {
        return marksValue;
    }

    public void setMarksValue(int marksValue) {
        this.marksValue = marksValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TermDisciplineIdAndMarksValue that = (TermDisciplineIdAndMarksValue) o;
        return termDisciplineId == that.termDisciplineId &&
                marksValue == that.marksValue;
    }

    @Override
    public int hashCode() {

        return Objects.hash(termDisciplineId, marksValue);
    }

    @Override
    public String toString() {
        return "TermDisciplineIdAndMarksValue{" +
                "termDisciplineId=" + termDisciplineId +
                ", marksValue=" + marksValue +
                '}';
    }
}
