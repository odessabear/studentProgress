package dto;

public class IdTermDisciplineAndDiscipline {

    private int idTermDiscipline;
    private String disciplineName;

    public IdTermDisciplineAndDiscipline(int idTermDiscipline, String disciplineName) {
        this.idTermDiscipline = idTermDiscipline;
        this.disciplineName = disciplineName;
    }

    public IdTermDisciplineAndDiscipline() {
    }

    public int getIdTermDiscipline() {
        return idTermDiscipline;
    }

    public void setIdTermDiscipline(int idTermDiscipline) {
        this.idTermDiscipline = idTermDiscipline;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }


}
