package Server;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class DatabaseConnector {

    private MysqlDataSource dataSource;
    private Connection connection;

    public DatabaseConnector() {
        dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setDatabaseName("vsgdatabase");

    }

    public boolean already_member(Student student)
    {

        try {
            connection = (Connection) dataSource.getConnection();
            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select student_id from client");
            while(resultSet.next())
            {
                String studentId = resultSet.getString("student_id");
                if(studentId.equals(student.getStudentID())) return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getStudentId(String userName)
    {

        try {
            connection = (Connection) dataSource.getConnection();
            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select student_id from client where user_name = '"+userName+"'");
            if(resultSet.next())
            {
                String studentId = resultSet.getString("student_id");
                return studentId;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getGender(String userName)
    {

        try {
            connection = (Connection) dataSource.getConnection();
            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select gender from client where user_name = '"+userName+"'");
            if(resultSet.next())
            {
                String gender = resultSet.getString("gender");
                return gender;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean login(String userName, String password)
    {
        String user , pass;

        try {
            connection = (Connection) dataSource.getConnection();
            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from client");
            while(resultSet.next())
            {
                user = resultSet.getString("user_name");
                pass = resultSet.getString("password");
                if(userName.equals(user) && password.equals(pass)) {
                    return true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void update_pass(String name)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter current password: ");
        String s = in.nextLine();

        try {
            connection = (Connection) dataSource.getConnection();
            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select password from client where user_name = '"+name+"'");
            if(resultSet.next()) {
                String pass = resultSet.getString("password");

                if (s.equals(pass)) {
                    pass = in.nextLine();
                    statement.executeUpdate("update client set password = '" + pass + "' where user_name = '" + name + "'");
                    System.out.println("Your password has been channged.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean insert(Student student)
    {
        try {
            Connection connection = (Connection) dataSource.getConnection();
            Statement statement = (Statement) connection.createStatement();
            String sqlQuery = "insert into client "+"(name, student_id, email, password, user_name, gender) "+"values ('"+student.getName()+"', '"+student.getStudentID()+"', '"+student.getEmail()+"', '"+student.getPassword()+"', '"+student.getUserName()+"', '"+student.getGender()+"')";
            statement.executeUpdate(sqlQuery);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  false;
    }

}
