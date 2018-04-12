package dto;

public class IdTermDisciplineAndDiscipline {

    private int termDisciplineId;
    private String disciplineName;
    private int marksValue;

    public IdTermDisciplineAndDiscipline(int termDisciplineId, String disciplineName,int marksValue) {
        this.termDisciplineId = termDisciplineId;
        this.disciplineName = disciplineName;
        this.marksValue = marksValue;
    }

    public IdTermDisciplineAndDiscipline() {
    }

    public int getTermDisciplineId() {
        return termDisciplineId;
    }

    public void setTermDisciplineId(int termDisciplineId) {
        this.termDisciplineId = termDisciplineId;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public int getValueOfMark() {
        return marksValue;
    }

    public void setValueOfMark(int valueOfMark) {
        this.marksValue = valueOfMark;
    }
}
