package Client;

import util.NetworkUtil;

public class ReadThreadClient implements Runnable {
	private Thread thr;
	private NetworkUtil nc;
	private ClientMain main;
	public ReadThreadClient(ClientMain main, NetworkUtil nc) {
		this.nc = nc;
		this.main = main;
		this.thr = new Thread(this);

		thr.start();
	}
	
	public void run() {
		try {
			while(true) {
				String flag=(String)nc.read();


				//System.out.println(s);
			}
		} catch(Exception e) {
			System.out.println (e);                        
		}
		nc.closeConnection();
	}
}



