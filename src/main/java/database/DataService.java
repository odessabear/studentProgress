package database;

import constants.Constants;
import entity.Discipline;
import entity.Mark;
import entity.Student;

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
        conection.updateStudent(id,surname,name,group,timestamp);
        putConnection(conection);
    }
}
