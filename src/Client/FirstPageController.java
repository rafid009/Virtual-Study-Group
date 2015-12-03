package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class FirstPageController {

    @FXML
    private AnchorPane whiteMenuAnchor;

    @FXML
    private AnchorPane transparentMenuAnchor;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnAbout;

    @FXML
    private Button btnExit;

    @FXML
    private Rectangle CSE201;

    @FXML
    private Rectangle CSE203;

    @FXML
    private Rectangle CSE205;

    @FXML
    private Rectangle EEE263;

    @FXML
    private Rectangle MATH241;

    public AnchorPane getWhiteMenuAnchor() {
        return whiteMenuAnchor;
    }

    public void setWhiteMenuAnchor(AnchorPane whiteMenuAnchor) {
        this.whiteMenuAnchor = whiteMenuAnchor;
    }

    public AnchorPane getTransparentMenuAnchor() {
        return transparentMenuAnchor;
    }

    public void setTransparentMenuAnchor(AnchorPane transparentMenuAnchor) {
        this.transparentMenuAnchor = transparentMenuAnchor;
    }

    public Button getBtnLogOut() {
        return btnLogOut;
    }

    public void setBtnLogOut(Button btnLogOut) {
        this.btnLogOut = btnLogOut;
    }

    public Button getBtnSettings() {
        return btnSettings;
    }

    public void setBtnSettings(Button btnSettings) {
        this.btnSettings = btnSettings;
    }

    public Button getBtnAbout() {
        return btnAbout;
    }

    public void setBtnAbout(Button btnAbout) {
        this.btnAbout = btnAbout;
    }

    public Button getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(Button btnExit) {
        this.btnExit = btnExit;
    }

    public Rectangle getCSE201() {
        return CSE201;
    }

    public void setCSE201(Rectangle CSE201) {
        this.CSE201 = CSE201;
    }

    public Rectangle getCSE203() {
        return CSE203;
    }

    public void setCSE203(Rectangle CSE203) {
        this.CSE203 = CSE203;
    }

    public Rectangle getCSE205() {
        return CSE205;
    }

    public void setCSE205(Rectangle CSE205) {
        this.CSE205 = CSE205;
    }

    public Rectangle getEEE263() {
        return EEE263;
    }

    public void setEEE263(Rectangle EEE263) {
        this.EEE263 = EEE263;
    }

    public Rectangle getMATH241() {
        return MATH241;
    }

    public void setMATH241(Rectangle MATH241) {
        this.MATH241 = MATH241;
    }

    private ClientMain clientMain;

    @FXML
    void onAboutAction(ActionEvent event) {

    }

    @FXML
    void onExitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onLogOutAction(ActionEvent event) {
        clientMain.logOut();
        try {
            clientMain.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onSettingsAction(ActionEvent event) {

    }

    public void setClientMain(ClientMain clientMain) {
        this.clientMain = clientMain;
    }
}
