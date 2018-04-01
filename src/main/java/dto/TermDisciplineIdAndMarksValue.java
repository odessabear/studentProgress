package dto;

import java.util.Objects;

public class TermDisciplineIdAndMarksValue {

    private int termDisciplineId;
    private int studentId;
    private int marksValue;

    public TermDisciplineIdAndMarksValue(int termDisciplineId, int studentId, int marksValue) {
        this.termDisciplineId = termDisciplineId;
        this.studentId = studentId;
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
                studentId == that.studentId &&
                marksValue == that.marksValue;
    }

    @Override
    public int hashCode() {

        return Objects.hash(termDisciplineId, studentId, marksValue);
    }

    @Override
    public String toString() {
        return "TermDisciplineIdAndMarksValue{" +
                "termDisciplineId=" + termDisciplineId +
                ", studentId=" + studentId +
                ", marksValue=" + marksValue +
                '}';
    }
}
