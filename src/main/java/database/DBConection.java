package database;


import dto.*;
import entity.*;

import java.sql.*;
import java.util.*;

public class DBConection {

    private Connection conn = null;

    private static final String LAPTOP_PC_NAME = "X501A";

    private static final String SIGMA_LAPTOP_PC_NAME = "amikhailov";

    private String getPasswordForLaptop(String lapTopName) {
        String lowerCase = lapTopName.toLowerCase();
        if (lowerCase.equals(SIGMA_LAPTOP_PC_NAME.toLowerCase()) || lowerCase.equals(LAPTOP_PC_NAME)) {
            return "Faster1218";
        } else {
            return "root";
        }
    }

    private DBConection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String computerName = System.getProperty("user.name");
            String password = getPasswordForLaptop(computerName);

            String connectionUrl = "jdbc:mysql://localhost:3306/student_progress?user=root&password="
                + password + "&characterEncoding=utf-8";

            conn = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static DBConection createConnection() {
        return new DBConection();
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
        List<Role> roles = new ArrayList<>();
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
        List<Term> termsList = new LinkedList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT  t.id_term as id , t.terms_name as name ,t.duration ,d.id_discipline ,d.discipline\n" +
                "                    FROM term_disciplin as td\n" +
                "                    left join term as t on td.id_term=t.id_term\n" +
                "                    left join discipline as d on td.id_discipline=d.id_discipline where (t.status = 1 and d.status=1) order by id");
            ResultSet result = statement.executeQuery();
            int lastIdTerm = -1;
            while (result.next()) {
                if (lastIdTerm == -1) {
                    Term term = new Term();
                    term.setId(result.getInt("id"));
                    term.setName(result.getString("name"));
                    term.setDuration(result.getInt("duration"));
                    lastIdTerm = term.getId();
                    Discipline discipline = new Discipline();
                    discipline.setId(result.getInt("id_discipline"));
                    discipline.setName(result.getString("discipline"));
                    term.addDiscipline(discipline);
                    termsList.add(term);
                } else {
                    if (lastIdTerm == result.getInt("id")) {

                        Discipline discipline = new Discipline();
                        discipline.setId(result.getInt("id_discipline"));
                        discipline.setName(result.getString("discipline"));
                        Term term = termsList.remove(termsList.size() - 1);
                        term.addDiscipline(discipline);
                        termsList.add(term);
                    } else {
                        Term term = new Term();
                        term.setId(result.getInt("id"));
                        term.setName(result.getString("name"));
                        term.setDuration(result.getInt("duration"));
                        lastIdTerm = term.getId();
                        Discipline discipline = new Discipline();
                        discipline.setId(result.getInt("id_discipline"));
                        discipline.setName(result.getString("discipline"));
                        term.addDiscipline(discipline);
                        termsList.add(term);
                    }
                }
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

    public Discipline getActiveDisciplineById(int id) {
        Discipline activeDiscipline = new Discipline();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM `discipline` WHERE id_discipline=? and status=1;");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                activeDiscipline.setId(id);
                activeDiscipline.setName(result.getString("discipline"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activeDiscipline;
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
            statement.setTimestamp(4, timestamp);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Student getStudentById(int id) {
        Student student = new Student();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM `student` WHERE id_student=?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                student.setId(id);
                student.setSurname(result.getString("surname"));
                student.setName(result.getString("name"));
                student.setGroup(result.getString("groupe"));
                student.setInDate(result.getTimestamp("entry_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;

    }

    public void updateStudent(int id, String surname, String name, String group, Timestamp timestamp) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE `student` SET `surname`=?, `name`=?, `groupe`=?, `entry_date`=? WHERE `id_student`=?");
            statement.setString(1, surname);
            statement.setString(2, name);
            statement.setString(3, group);
            statement.setTimestamp(4, timestamp);
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE `student` SET `status`='0' WHERE `id_student`=?;");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Mark> getStudentsMarks() {
        List<Mark> marks = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM mark");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Mark mark = new Mark();
                mark.setId(resultSet.getInt("id_mark"));
                mark.setId(resultSet.getInt("id_student"));
                mark.setId(resultSet.getInt("id_term_discipline"));
                mark.setId(resultSet.getInt("mark"));
                marks.add(mark);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marks;
    }

    public void disableTerm(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE `term` SET `status`='0' WHERE `id_term`= ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createNewTerm(String termsName, int duration) {

        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO `term` (`terms_name`, `duration`) VALUES (?, ?);");
            statement.setString(1, termsName);
            statement.setInt(2, duration);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int createNewTerm(Term term) {
        try {

            PreparedStatement createTermStatement = conn.prepareStatement("INSERT INTO `term` (`terms_name`, `duration`) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            PreparedStatement addDisciplineToTerm = conn.prepareStatement("INSERT INTO `term_disciplin` (`id_term`, `id_discipline`) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

            createTermStatement.setString(1, term.getName());
            createTermStatement.setString(2, String.valueOf(term.getDuration()));
            createTermStatement.executeUpdate();

            int result = 0;
            ResultSet rs = createTermStatement.getGeneratedKeys();
            while (rs.next()) {
                result = rs.getInt(1);
            }

            System.out.println("result of operation is " + result);

            for (Discipline discipline : term.getDisciplines()) {
                addDisciplineToTerm.setInt(1, result);
                addDisciplineToTerm.setLong(2, discipline.getId());

                System.out.println("going to add discipl to term like this request" + addDisciplineToTerm);

                addDisciplineToTerm.executeUpdate();
            }


            return result;

            // TODO: add commit here

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("bad things", e);
        }
    }

    public void deleteDisciplineFromTerm(int disciplineId, int termId) {
        PreparedStatement deleteDiscFromTerm;
        PreparedStatement deleteDiscFromTerm2;
        PreparedStatement deleteDiscFromTerm3;
        try {
            deleteDiscFromTerm = conn.prepareStatement("SEt FOREIGN_KEY_CHECKS = 0;");
            deleteDiscFromTerm2 = conn.prepareStatement("Delete from term_disciplin WHERE id_discipline=?  and id_term = ?;");
            deleteDiscFromTerm3 = conn.prepareStatement("set FOREIGN_KEY_CHECKS = 1;");

            deleteDiscFromTerm2.setInt(1, disciplineId);
            deleteDiscFromTerm2.setInt(2, termId);

            deleteDiscFromTerm.executeUpdate();
            deleteDiscFromTerm2.executeUpdate();
            deleteDiscFromTerm3.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Term getTermById(int id) {
        Term termById = new Term();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM `term` where `id_term` = ?;");

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                termById.setId(id);
                termById.setName(result.getString("terms_name"));
                termById.setDuration(result.getInt("duration"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return termById;
    }

    public List<Integer> getDisciplinesIdByTermId(int id) {
        List<Integer> disciplinesIdsFromTerm = new ArrayList<>();
        try {
            PreparedStatement getDisciplineFromTermStatement = conn.prepareStatement("SELECT `id_discipline` FROM `term_disciplin` WHERE `id_term` = ? ;");
            getDisciplineFromTermStatement.setInt(1, id);
            ResultSet resultSet = getDisciplineFromTermStatement.executeQuery();

            while (resultSet.next()) {

                int discId = resultSet.getInt(1);
                disciplinesIdsFromTerm.add(discId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplinesIdsFromTerm;
    }

    public int termUpdating(Term termToModify) {
        try {
            PreparedStatement termModifyingStatement = conn.prepareStatement("UPDATE `term` SET `terms_name`=?, `duration`=? WHERE `id_term`=?", Statement.RETURN_GENERATED_KEYS);
            PreparedStatement insertDisciplineStatement = conn.prepareStatement("INSERT INTO `term_disciplin` (`id_term`, `id_discipline`) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

            termModifyingStatement.setString(1, termToModify.getName());
            termModifyingStatement.setInt(2, termToModify.getDuration());
            termModifyingStatement.setInt(3, termToModify.getId());
            termModifyingStatement.executeUpdate();

            int termid = termToModify.getId();

            ResultSet resultSet = termModifyingStatement.getGeneratedKeys();
            while (resultSet.next()) {
                termid = resultSet.getInt(1);
            }

            for (Discipline discipline : termToModify.getDisciplines()) {
                insertDisciplineStatement.setInt(1, termid);
                insertDisciplineStatement.setLong(2, discipline.getId());


                System.out.println("going to add discipl to term like this request" + insertDisciplineStatement);

                insertDisciplineStatement.executeUpdate();
            }
            return termid;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("bad things", e);
        }
    }

    private void closeConnection() {
        try {
            System.out.println("closing db connection");

            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TermAndMark> getStudentProgressByStudentAndTermIds(int studentId, int termId) {

        List<TermAndMark> termAndMarkList = new ArrayList<>();

        try {
            PreparedStatement statement = conn.prepareStatement("select discipline,mark,id_mark\n" +
                "from student left join mark on student.id_student = mark.id_student\n" +
                "left join term_disciplin on mark.id_term_discipline = term_disciplin.id_term_discipline\n" +
                "left join term on term_disciplin.id_term=term.id_term\n" +
                "left join discipline on term_disciplin.id_discipline=discipline.id_discipline\n" +
                "where student.id_student = ? and term.id_term = ? and term.status=1 and discipline.status=1;");

            statement.setInt(1, studentId);
            statement.setInt(2, termId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                TermAndMark termAndMark = new TermAndMark();

                String discipline = resultSet.getString("discipline");
                int mark = resultSet.getInt("mark");
                int idMark = resultSet.getInt("id_mark");

                termAndMark.setDiscipline(discipline);
                termAndMark.setMark(mark);
                termAndMark.setIdMark(idMark);

                termAndMarkList.add(termAndMark);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return termAndMarkList;
    }

    public List<StudentTerm> getTermByStudentId(int id) {
        List<StudentTerm> studentTerms = new ArrayList<>();
        try {
            PreparedStatement termStatement = conn.prepareStatement("SELECT term.id_term as id_term,terms_name from student\n" +
                "left join mark on student.id_student = mark.id_student\n" +
                "left join term_disciplin on mark.id_term_discipline = term_disciplin.id_term_discipline\n" +
                "left join term on term_disciplin.id_term = term.id_term\n" +
                "where student.id_student = ? and term.status=1 group by id_term,terms_name;");

            termStatement.setInt(1, id);


            ResultSet resultSet = termStatement.executeQuery();

            while (resultSet.next()) {
                StudentTerm term = new StudentTerm();
                int termId = resultSet.getInt("id_term");
                String termsName = resultSet.getString("terms_name");

                term.setTermId(termId);
                term.setTermsName(termsName);

                studentTerms.add(term);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentTerms;
    }

    public void changeMarkById(int marksValue, int idOfMark) {
        try {
            PreparedStatement changeMarkStatement = conn.prepareStatement("UPDATE `mark` SET `mark`=? WHERE `id_mark`=?;");

            changeMarkStatement.setInt(1, marksValue);
            changeMarkStatement.setInt(2, idOfMark);

            changeMarkStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<StudentTerm> getAllTermsNamesAndIds() {
        List<StudentTerm> allActiveTermsNamesAndIds = new ArrayList<>();
        try {
            PreparedStatement getTermsStatement = conn.prepareStatement("SELECT id_term,terms_name FROM student_progress.term where status = 1;");

            ResultSet resultSet = getTermsStatement.executeQuery();

            while (resultSet.next()) {
                StudentTerm term = new StudentTerm();

                int termsId = resultSet.getInt("id_term");
                String termsName = resultSet.getString("terms_name");

                term.setTermId(termsId);
                term.setTermsName(termsName);

                allActiveTermsNamesAndIds.add(term);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allActiveTermsNamesAndIds;
    }

    public List<TermAndDiscipline> getTermDisciplineIdsAndDisciplineIdsByTermId(int termId) {
        List<TermAndDiscipline> valuesOfIds = new ArrayList<>();

        try {
            PreparedStatement getIdsStatement = conn.prepareStatement("SELECT id_term_discipline,id_discipline FROM term_disciplin WHERE id_term = ?;");

            getIdsStatement.setInt(1, termId);

            ResultSet resultSet = getIdsStatement.executeQuery();

            while (resultSet.next()) {

                TermAndDiscipline values = new TermAndDiscipline();

                int termAndDisciplineId = resultSet.getInt("id_term_discipline");
                int idDiscipline = resultSet.getInt("id_discipline");

                values.setIdTermAndDiscipline(termAndDisciplineId);
                values.setIdDiscipline(idDiscipline);

                valuesOfIds.add(values);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valuesOfIds;
    }

    public List<IdTermDisciplineAndDiscipline> getIdTermDisciplineAndDisciplineByTermId(int termId) {
        List<IdTermDisciplineAndDiscipline> idsAndDisciplineNames = new ArrayList<>();

        try {
            PreparedStatement statement = conn.prepareStatement("SELECT id_term_discipline,discipline FROM term_disciplin left join discipline on term_disciplin.id_discipline = discipline.id_discipline where id_term = ? and discipline.status = 1;", Statement.RETURN_GENERATED_KEYS);
            PreparedStatement markStatement = conn.prepareStatement("SELECT mark FROM mark WHERE id_term_discipline = ?", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, termId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                IdTermDisciplineAndDiscipline values = new IdTermDisciplineAndDiscipline();

                int idTermDiscipline = resultSet.getInt("id_term_discipline");
                String disciplineName = resultSet.getString("discipline");
                int marksValue = 0;
                markStatement.setInt(1, idTermDiscipline);
                ResultSet resultSet1 = markStatement.executeQuery();
                while (resultSet1.next()) {
                    marksValue = resultSet1.getInt("mark");

                    values.setValueOfMark(marksValue);

                }

                values.setTermDisciplineId(idTermDiscipline);
                values.setDisciplineName(disciplineName);

                idsAndDisciplineNames.add(values);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idsAndDisciplineNames;
    }

    public void insertMark(int studentId, int termDisciplineId, int marksValue) {

        try {
            PreparedStatement insertMarkStatement = conn.prepareStatement("insert into student_progress.mark values (DEFAULT,?, ?, ?);");
            insertMarkStatement.setInt(1, studentId);
            insertMarkStatement.setInt(2, termDisciplineId);
            insertMarkStatement.setInt(3, marksValue);
            insertMarkStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



