package Server;

import util.NetworkUtil;

import java.util.Hashtable;

/**
 * Created by MdRafid on 11/18/2015.
 */

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil nc;
    private String cName;
    private Hashtable<String,NetworkUtil>table;
    public ReadThreadServer(NetworkUtil nc, Hashtable<String,NetworkUtil>table) {
        this.nc = nc;
        this.table = table;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                String s = (String) nc.read();
                if(s == null) break;

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        nc.closeConnection();
    }
}