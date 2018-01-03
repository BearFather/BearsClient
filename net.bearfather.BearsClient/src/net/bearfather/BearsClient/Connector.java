package net.bearfather.BearsClient;

import java.io.IOException;

public class Connector implements Runnable{
	private String server;
	private int port;
	TelnetService ts;
	
	public Connector(String server, int port){
		this.server=server;
		this.port=port;
	}
	public void run(){
		try {
			ts=new TelnetService(server, port);
			ts.getTelnetSessionAsString("test");
			while (ts.loggedin==1){
				String rtn=ts.readUntil("\n");
				BearsClient.dw.append(rtn);
			}
		} catch (IOException | InterruptedException e) {e.printStackTrace();}
	}
	public void write(String line){
		ts.write(line);
	}

}
