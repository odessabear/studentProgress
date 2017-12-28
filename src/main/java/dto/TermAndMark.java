package dto;

public class TermAndMark {

    private String discipline;
    private int mark;

    public TermAndMark() {
    }

    public TermAndMark(String discipline, int mark) {
        this.discipline = discipline;
        this.mark = mark;
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
