package dto;

public class TermAndMark {

    private String discipline;
    private int mark;
    private int idMark;

    public TermAndMark() {
    }

    public TermAndMark(String discipline, int mark) {
        this.discipline = discipline;
        this.mark = mark;
    }

    public int getIdMark() {
        return idMark;
    }

    public void setIdMark(int idMark) {
        this.idMark = idMark;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
