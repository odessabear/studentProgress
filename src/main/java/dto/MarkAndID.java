package dto;

import java.util.Objects;

public class MarkAndID {
    private Integer marksValue;
    private Integer idMark;

    public Integer getMarksValue() {
        return marksValue;
    }

    public void setMarksValue(Integer marksValue) {
        this.marksValue = marksValue;
    }

    public Integer getIdMark() {
        return idMark;
    }

    public void setIdMark(Integer idMark) {
        this.idMark = idMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarkAndID markAndID = (MarkAndID) o;
        return Objects.equals(marksValue, markAndID.marksValue) &&
                Objects.equals(idMark, markAndID.idMark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(marksValue, idMark);
    }

    @Override
    public String toString() {
        return "MarkAndID{" +
                "mark=" + marksValue +
                ", idMark=" + idMark +
                '}';
    }
}
