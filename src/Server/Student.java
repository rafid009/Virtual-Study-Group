package Server;

import java.io.Serializable;

/**
 * Created by MdRafid on 11/23/2015.
 */
public class Student implements Serializable{
    private String name;
    private String studentID;
    private String password;
    private String email;
    private int id;
    private String userName;
    private String gender;


    public Student(String name, String studentID, String password, String email, int id) {
        this.name = name;
        this.studentID = studentID;
        this.password = password;
        this.email = email;
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public Student(String name, String studentID, String password, String email, String userName, String gender) {
        this.name = name;
        this.studentID = studentID;
        this.password = password;
        this.email = email;
        this.gender = gender;

        this.userName = userName;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
