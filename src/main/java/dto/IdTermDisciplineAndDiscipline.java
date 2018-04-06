package dto;

public class IdTermDisciplineAndDiscipline {

    private int termDisciplineId;
    private String disciplineName;

    public IdTermDisciplineAndDiscipline(int termDisciplineId, String disciplineName) {
        this.termDisciplineId = termDisciplineId;
        this.disciplineName = disciplineName;
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
}
