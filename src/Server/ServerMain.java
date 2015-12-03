package Server;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import util.NetworkUtil;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

/**
 * Created by MdRafid on 11/19/2015.
 */
public class ServerMain {


    private ServerSocket ServSock;
    public int i = 0;
    public Hashtable<String, NetworkUtil> table;
    private DatabaseConnector database;
    private NetworkUtil nc;
    private ObservableList<String> clientList = FXCollections.observableArrayList();


    ServerMain(){
        database = new DatabaseConnector();
        table = new Hashtable<>();
        try {
            ServSock = new ServerSocket(33333);
            new WriteThreadServer(table, "Server");
            while (true) {
                Socket clientSock = ServSock.accept();

                nc=new NetworkUtil(clientSock);
                String flag =(String) nc.read();
                if(flag.equals("1"))
                {
                    String userName =(String) nc.read();
                    String password =(String) nc.read();

                    if(loginChecker(userName,password))
                    {
                        String studentId = database.getStudentId(userName);
                        table.put(studentId, nc);

                        System.out.println(studentId + " found you!!");
                        new ReadThreadServer(nc, table);
                    }
                    else
                    {
                        nc.closeConnection();
                    }

                }
                else if (flag.equals("2")) {

                    String name = (String)nc.read();
                    String sId = (String)nc.read();
                    String mail = (String)nc.read();
                    String pass = (String)nc.read();
                    String user = (String)nc.read();
                    String gender = (String)nc.read();
                    Student student = new Student(name,sId,pass,mail,user,gender);
                    System.out.println("Got student");
                    if (register(student)) {

                        //String studentId = database.getStudentId(student.getUserName());
                        nc.write("proceed");
                        table.put(sId, nc);
                        System.out.println(sId + " found you!!");

                        new ReadThreadServer(nc, table);

                    } else{
                        nc.write("not permitted");
                        nc.closeConnection();
                    }

                }




            }
        }catch(Exception e) {
            System.out.println("Server starts:"+e);
        }
    }

    public boolean register(Student student)
    {
        if(database.already_member(student))
        {
            nc.write("member");
            return false;
        }
        if(database.insert(student)) return true;

        return false;
    }

    public boolean loginChecker(String userName, String password)
    {

        if(database.login(userName,password))
        {
            nc.write(database.getGender(userName));
            nc.write("proceed");
            return true;
        }

        return false;
    }

    public static void main(String args[]) {
        ServerMain objServer = new ServerMain();
    }
}

