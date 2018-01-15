package dto;

import java.util.Objects;

public class MarkAndID {
    private int idMark;
    private int Mark;

    public MarkAndID(int idMark, int mark) {
        this.idMark = idMark;
        Mark = mark;
    }

    public MarkAndID() {
    }

    public int getIdMark() {
        return idMark;
    }

    public void setIdMark(int idMark) {
        this.idMark = idMark;
    }

    public int getMark() {
        return Mark;
    }

    public void setMark(int mark) {
        Mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarkAndID markAndID = (MarkAndID) o;
        return idMark == markAndID.idMark &&
                Mark == markAndID.Mark;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idMark, Mark);
    }

    @Override
    public String toString() {
        return "MarkAndID{" +
                "idMark=" + idMark +
                ", Mark=" + Mark +
                '}';
    }
}
