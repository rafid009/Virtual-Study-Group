package Client;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.util.ArrayList;

public class ClientMain extends Application {

    private Stage stage;
    private LoginPageController loginController;
    private RegisterPageController registerController;
    private NetworkUtil nc;
    private FirstPageController corridorController;
    private String clientName;
    private ArrayList<Image>imagesList = new ArrayList<>();
    private String clientGender;
    private int genderController = 0;







    @Override
    public void stop() throws Exception {
        System.exit(0);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        // XML Loading using FXMLLoader
        stage = primaryStage;
        showLoginPage();
        //showRegisterPage();
    }

    public void buttonHoverEffect(Button btn)
    {


        btn.setOnMouseEntered(e->{
                    btn.setStyle("-fx-background-color: #ffffff; " +
                            "-fx-text-fill: #000000;" +
                            "-fx-background-radius:30;" +
                            "-fx-pref-width:150px;" +
                            "-fx-border-color:white;" +
                            "-fx-border-radius:30;" +
                            "-fx-border-width:2px;");
                }

        );

        btn.setOnMouseExited(e -> {
                    btn.setStyle("-fx-background-color: #636363;" +
                            "-fx-text-fill: #ffffff;" +
                            "-fx-background-radius:30;" +
                            "-fx-pref-width:150px;" +
                            "-fx-border-color:white;" +
                            "-fx-border-radius:30;" +
                            "-fx-border-width:2px;");
                }
        );

    }

    public void logOut()
    {
        nc.closeConnection();
    }

    public void FirstPageButtonHoverEffect(Button btn)
    {


        btn.setOnMouseEntered(e -> {
                    btn.setStyle("-fx-background-color: #FFC800; " +

                                    "-fx-text-fill: #ffffff;"+

                            "-fx-background-radius:30;"
                            );
                }

        );

        btn.setOnMouseExited(e->{
                    btn.setStyle("-fx-background-color:  #F9C923;" +
                            "-fx-text-fill: #b84040;"+
                            "-fx-background-radius:30;");
                }
        );

    }

    public boolean clientConnect(String user, String pass)
    {
        try {

            String serverAddress="127.0.0.1";
            int serverPort=33333;
            nc = new NetworkUtil(serverAddress,serverPort);
            String flag = "1";
            nc.write(flag);
            nc.write(user);
            nc.write(pass);
            clientGender = (String) nc.read();
            String permit =(String) nc.read();
            if(permit.equals("proceed"))
            {

                return true;
            }
            else
            {
                nc.closeConnection();
                return false;
            }

        } catch(Exception e) {
            System.out.println (e);
        }
        return false;
    }

    public boolean clientConnect()
    {
        try {

            String serverAddress="127.0.0.1";
            int serverPort=33333;
            nc = new NetworkUtil(serverAddress,serverPort);
            String flag = "2";
            System.out.println("networked");
            nc.write(flag);
            nc.write(registerController.getName());
            nc.write(registerController.getsId());
            nc.write(registerController.getMail());
            nc.write(registerController.getPass());
            nc.write(registerController.getUser());
            nc.write(registerController.getGndr());
            System.out.println("student got");
            String permit =(String) nc.read();
            if(permit.equals("proceed")) return true;
            else
            {
                nc.closeConnection();
                return false;
            }

        } catch(Exception e) {
            System.out.println (e);
        }
        return false;
    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("loginPage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        loginController= loader.getController();
        loginController.setClientMain(this);

        Button btnLogin = loginController.getLogin();
        Button btnReg = loginController.getRegister();

        buttonHoverEffect(btnLogin);
        buttonHoverEffect(btnReg);

        // Set the primary stage
        stage.setTitle("Virtual Study Group");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    public void showFirstPage(String client) throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("firstPage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        corridorController= loader.getController();
        corridorController.setClientMain(this);
        this.clientName = client;


        FirstPageButtonHoverEffect(corridorController.getBtnSettings());
        FirstPageButtonHoverEffect(corridorController.getBtnAbout());
        FirstPageButtonHoverEffect(corridorController.getBtnLogOut());
        FirstPageButtonHoverEffect(corridorController.getBtnExit());


        // Set the primary stage
        stage.setTitle(clientName);
        stage.setScene(new Scene(root, 800, 550));
        stage.show();
    }

    public void showRegisterPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("registerPage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        registerController= loader.getController();
        registerController.setClientMain(this);

        Button btnRegComplete = registerController.getCompleteButton();
        Button btnLoginPage = registerController.getLoginPage();

        buttonHoverEffect(btnRegComplete);
        buttonHoverEffect(btnLoginPage);

        // Set the primary stage
        stage.setTitle("Virtual Study Group");
        stage.setScene(new Scene(root, 700, 650));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
