package database;


import java.sql.*;

public class DBConection {
    private Connection conn = null;

    public DBConection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost/student_progress?user=root&password=Faster1218&characterEncoding=utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  boolean isAvailableUser(String login,String password){
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM student_progress.account where login = ? and password=?;");
            statement.setString(1,login);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
