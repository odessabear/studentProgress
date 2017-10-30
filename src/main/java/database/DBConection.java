package database;


import entity.Discipline;
import entity.Role;
import entity.Student;
import entity.Term;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConection {
    private Connection conn = null;

    public DBConection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost/student_progress?user=root&password=Faster1218&characterEncoding=utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int isAvailableUser(String login, String password) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM student_progress.account where login = ? and password=?;");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("id_account");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<Role>();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM role");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Role role = new Role();
                role.setId(result.getInt("id_role"));
                role.setRole(result.getString("role"));
                roles.add(role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }


    public boolean isCorrectRoleFromUser(int idAccount, int idRole) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM student_progress.account_role WHERE id_account = ? and id_role = ?");
            statement.setInt(1, idAccount);
            statement.setInt(2, idRole);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> getAllActiveStudents() {
        List<Student> studentList = new ArrayList<Student>();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM student where status=1");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Student student = new Student();
                student.setId(result.getInt("id_student"));
                student.setName(result.getString("name"));
                student.setSurname(result.getString("surname"));
                student.setGroup(result.getString("groupe"));
                student.setInDate(result.getTimestamp("entry_date"));
                studentList.add(student);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    public List<Discipline> getAllDisciplines() {
        List<Discipline> disciplineList = new ArrayList<Discipline>();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM discipline WHERE status=1");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(result.getInt("id_discipline"));
                discipline.setName(result.getString("discipline"));
                disciplineList.add(discipline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplineList;
    }

    public List<Term> getTermsList() {
        List<Term> termsList = new ArrayList<Term>();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT \n" +
                    "t.id_term as id,\n" +
                    "t.terms_name as name,\n" +
                    "t.duration,\n" +
                    "d.id_discipline,\n" +
                    "d.discipline\n" +
                    "FROM term_disciplin as td\n" +
                    "left join term as t on td.id_term=t.id_term\n" +
                    "left join discipline as d on td.id_discipline=d.id_discipline where status = 1");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Term term = new Term();
                term.setId(result.getInt("id_term"));
                term.setName(result.getString("terms_name"));
                term.setDuration(result.getInt("duration"));
                termsList.add(term);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return termsList;
    }

    public boolean insertDiscipline(String discipline) {
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO `discipline` (`discipline`) VALUES (?);");
            statement.setString(1, discipline);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public void deleteDiscipline(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE `discipline` SET `status`='0' WHERE `id_discipline`=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Discipline getDisciplineById(int id) {
        Discipline discipline = new Discipline();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM `discipline` WHERE id_discipline=?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                discipline.setId(id);
                discipline.setName(result.getString("discipline"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discipline;

    }

    public void modifyingDisciplineById(int idDisipline, String disciplineName) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE `student_progress`.`discipline` SET `discipline`=? WHERE `id_discipline`= ?");
            statement.setString(1, disciplineName);
            statement.setInt(2, idDisipline);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertNewStudent(String surname, String name, String group, Timestamp timestamp) {

        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO `student` (`surname`, `name`, `groupe`, `entry_date`) VALUES (?,?,?,?)");

            statement.setString(1, surname);
            statement.setString(2, name);
            statement.setString(3, group);
            statement.setTimestamp(4,timestamp);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}



