package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterPageController {

    @FXML
    private TextField userName;

    @FXML
    private TextField email;

    @FXML
    private Button completeButton;

    @FXML
    private TextField studentID;

    @FXML
    private TextField fullName;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginPage;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton female;

    private String gndr;


    private ClientMain clientMain;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    private String name, sId, pass, mail, user;


    public TextField getUserName() {
        return userName;
    }

    public void setUserName(TextField userName) {
        this.userName = userName;
    }

    public TextField getEmail() {
        return email;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }

    public Button getCompleteButton() {
        return completeButton;
    }

    public void setCompleteButton(Button completeButton) {
        this.completeButton = completeButton;
    }

    public TextField getStudentID() {
        return studentID;
    }

    public void setStudentID(TextField studentID) {
        this.studentID = studentID;
    }

    public TextField getFullName() {
        return fullName;
    }

    public void setFullName(TextField fullName) {
        this.fullName = fullName;
    }

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public Button getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(Button loginPage) {
        this.loginPage = loginPage;
    }

    public ClientMain getClientMain() {
        return clientMain;
    }

    public String getGndr() {
        return gndr;
    }

    @FXML
    void completeButtonAction(ActionEvent event) {
        name = fullName.getText();
        sId = studentID.getText();
        pass = password.getText();
        mail = email.getText();
        user = userName.getText();
        if(male.isSelected()) gndr = "male";
        else if(female.isSelected()) gndr = "female";
        if(!name.isEmpty() && !sId.isEmpty() && !pass.isEmpty() && !mail.isEmpty() && !user.isEmpty() && !gndr.isEmpty())
        {

            if(clientMain.clientConnect())
            {
                try {
                    clientMain.showFirstPage(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }



    }

    @FXML
    void loginPageButtonAction(ActionEvent event) {

    }


    public void setClientMain(ClientMain clientMain) {
        this.clientMain = clientMain;
    }

}
