package dto;

import java.util.Objects;

public class MarkAndID {
    private Integer mark;
    private Integer idMark;

    public Integer getMarksValue() {
        return mark;
    }

    public void setMarksValue(Integer mark) {
        this.mark = mark;
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
        return Objects.equals(mark, markAndID.mark) &&
                Objects.equals(idMark, markAndID.idMark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mark, idMark);
    }

    @Override
    public String toString() {
        return "MarkAndID{" +
                "mark=" + mark +
                ", idMark=" + idMark +
                '}';
    }
}
