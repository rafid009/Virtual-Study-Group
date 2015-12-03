package Client;

import util.NetworkUtil;

import java.util.Scanner;

public class WriteThreadClient implements Runnable {

	private Thread thr;
	private NetworkUtil nc;
	String name;

	public WriteThreadClient(NetworkUtil nc, String name) {
		this.nc = nc;
		this.name=name;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			nc.write(name);
			Scanner input=new Scanner(System.in);

			while(true) {
				//String s=input.nextLine();
				//System.out.println();
				//nc.write(s);
			}
		} catch(Exception e) {
			System.out.println (e);
		}			
		nc.closeConnection();
	}
}



