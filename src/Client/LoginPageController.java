package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPageController {

    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Button register;
    private ClientMain clientMain;

    String user, pass;
    @FXML
    void loginAction(ActionEvent event) {
        user = userName.getText();
        pass = password.getText();

        if(!user.isEmpty() && !pass.isEmpty())
        {
            if(clientMain.clientConnect(user, pass))
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
    void registerAction(ActionEvent event) {

        try {
            clientMain.showRegisterPage();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public TextField getUserName() {
        return userName;
    }

    public void setUserName(TextField userName) {
        this.userName = userName;
    }

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public Button getLogin() {
        return login;
    }

    public void setLogin(Button login) {
        this.login = login;
    }

    public Button getRegister() {
        return register;
    }

    public void setRegister(Button register) {
        this.register = register;
    }

    public void setClientMain(ClientMain clientMain) {
        this.clientMain = clientMain;
    }
}
