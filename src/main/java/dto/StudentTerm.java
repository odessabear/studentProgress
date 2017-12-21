package dto;

public class StudentTerm {
    private int termId;
    private String termsName;

    public StudentTerm() {
    }

    public StudentTerm(int termId, String termsName) {
        this.termId = termId;
        this.termsName = termsName;

    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public String getTermsName() {
        return termsName;
    }

    public void setTermsName(String termsName) {
        this.termsName = termsName;
    }
}
