package database;

import constants.Constants;
import dto.SelectedTermAndDiscipline;
import entity.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class DataService {
    private static Object monitor = new Object();
    private static List<DBConection> pool = new LinkedList<>();

    public void init() {
        for (int i = 0; i < Constants.CONNECTION_POOL_SIZE; i++) {
            this.newConnection();
        }
    }

    private void newConnection() {
        DBConection conection = new DBConection();
        synchronized (monitor) {
            pool.add(conection);
        }
    }

    public DBConection getConnection() {
        synchronized (monitor) {
            if (pool.size() == 0) {
                newConnection();
            }
            return pool.remove(0);
        }
    }

    public void putConnection(DBConection conection) {
        synchronized (monitor) {
            pool.add(conection);
        }
    }

    public List<Discipline> getAllDisciplines() {
        DBConection conection = getConnection();
        List<Discipline> disciplines = conection.getAllDisciplines();
        putConnection(conection);
        return disciplines;
    }

    public void deleteStudent(int id) {
        DBConection conection = getConnection();
        conection.deleteStudent(id);
        putConnection(conection);

    }

    public List<Student> getAllActiveStudents() {
        DBConection conection = getConnection();
        List<Student> students = conection.getAllActiveStudents();
        putConnection(conection);
        return students;
    }

    public void insertNewStudent(String surname, String name, String group, Timestamp timestamp) {
        DBConection conection = getConnection();
        conection.insertNewStudent(surname, name, group, timestamp);
        putConnection(conection);
    }

    public List<Mark> getStudentsMarks() {
        DBConection conection = getConnection();
        List<Mark> marks = conection.getStudentsMarks();
        putConnection(conection);
        return marks;
    }

    public Student getStudentById(int id) {
        DBConection conection = getConnection();
        Student student = conection.getStudentById(id);
        putConnection(conection);
        return student;
    }

    public void modifyingDisciplineById(int idDisipline, String disciplineName) {
        DBConection conection = getConnection();
        conection.modifyingDisciplineById(idDisipline, disciplineName);
        putConnection(conection);

    }

    public void updateStudent(int id, String surname, String name, String group, Timestamp timestamp) {
        DBConection conection = getConnection();
        conection.updateStudent(id, surname, name, group, timestamp);
        putConnection(conection);
    }

    public boolean insertDiscipline(String discipline) {
        DBConection conection = getConnection();
        conection.insertDiscipline(discipline);
        putConnection(conection);
        return true;
    }

    public Discipline getDisciplineById(int id) {
        DBConection conection = getConnection();
        Discipline discipline = conection.getDisciplineById(id);
        putConnection(conection);
        return discipline;
    }

    public void deleteDiscipline(int id) {
        DBConection conection = getConnection();
        conection.deleteDiscipline(id);
        putConnection(conection);
    }

    public List<Role> getAllRoles() {
        DBConection conection = getConnection();
        List<Role> roles = conection.getAllRoles();
        putConnection(conection);
        return roles;
    }

    public int isAvailableUser(String login, String password) {
        DBConection conection = getConnection();
        int result = conection.isAvailableUser(login, password);
        putConnection(conection);
        return result;
    }

    public boolean isCorrectRoleFromUser(int idAccount, int idRole) {
        DBConection conection = getConnection();
        boolean result = conection.isCorrectRoleFromUser(idAccount, idRole);
        return result;
    }

    public int createNewTerm(Term termToCreate) {
        DBConection conection = getConnection();
        int result = conection.createNewTerm(termToCreate);
        putConnection(conection);
        return result;

    }

    public void createNewTerm(String termsName, int valueOfDuration) {
        DBConection conection = getConnection();
        conection.createNewTerm(termsName, valueOfDuration);
        putConnection(conection);
    }

    public List<Term> getTermsList() {
        DBConection conection = getConnection();
        List<Term> termList = conection.getTermsList();
        putConnection(conection);
        return termList;
    }

    public void disableTerm(int idTerm) {
        DBConection conection = getConnection();
        conection.disableTerm(idTerm);
        putConnection(conection);
    }

    public void deleteDisciplineFromTerm(SelectedTermAndDiscipline selectedTermAndDiscipline) {
        DBConection conection = getConnection();
        conection.deleteDisciplineFromTerm(selectedTermAndDiscipline.getDisciplineId(), selectedTermAndDiscipline.getTermId());
        putConnection(conection);
    }


    public Term getTermById(int id) {
        DBConection conection = getConnection();
        Term termById = conection.getTermById(id);
        putConnection(conection);
        return termById;
    }

    public int termUpdating(Term termToModify) {
        DBConection conection = getConnection();
        int result = conection.termUpdating(termToModify);
        putConnection(conection);
        return result;
    }


    public List<Integer> getDisciplinesIdByTermId(int id) {
        DBConection conection = getConnection();
        List<Integer> idsList = conection.getDisciplinesIdByTermId(id);
        putConnection(conection);
        return idsList;
    }

    public Discipline getActiveDisciplineById(int discId) {
        DBConection conection=getConnection();
        Discipline activeDiscipline = conection.getActiveDisciplineById(discId);
        putConnection(conection);
        return activeDiscipline;
    }
}
