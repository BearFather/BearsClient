package net.bearfather.BearsClient;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.SocketException;

import org.apache.commons.net.telnet.TelnetClient;
public class TelnetService {
	private final String server;
	private final int port;
	public TelnetClient telnet = new TelnetClient();
	private InputStream dataIn;
	private PrintStream dataOut;
	public int loggedin=0;
	public static int runner=1;
	public int ghost =0;
	String hangup=BearsClient.props.getCleanup();
	String nonstop="(N)onstop, (Q)uit, or (C)ontinue?";
    String ghosts="Enter your password to end the other connection and log on.";
   	
	public TelnetService(String server, int port) {
		this.server = server.replace("http://", "");
		this.port = port;
	}
	public void killme() throws IOException{
		BearsClient.dw.append("13:¥:Connection disconnected");
		telnet.disconnect();
	}
	private void startTelnetSession() throws SocketException, IOException {
		telnet.connect(server, port);
		dataIn = telnet.getInputStream();
		dataOut = new PrintStream(telnet.getOutputStream());
	}
	public String getTelnetSessionAsString(String server) throws SocketException, IOException, InterruptedException {
        startTelnetSession();
        BearsClient.dw.append("Logging into server "+server+".");

        // This is auto login shit
        //String rtn="blah";
        //rtn=loginUser(BearsClient.props.getUser(),"",BearsClient.props.getPassword());
        //if (rtn.equals("reload")){return rtn;}
        loggedin=1;
        return "Logged in";
}
	@SuppressWarnings("unused")
	private String loginUser(String name, String cmd,String pass) throws InterruptedException, IOException {
		readUntil(BearsClient.props.getPuser());
		write(name);
		readUntil(BearsClient.props.getPpass());
		write(pass+"\r\n");
		readUntil(BearsClient.props.getPmenu());
		if (ghost == 1){
			write("=x\n");
			ghost=0;
			return "reload";
		}
		else {write(cmd);}
		readUntil(BearsClient.props.getPmud());
		write("e");
		write("\n");
		return "blah";
}
	public void write(String value) {
		try {
			dataOut.println(value);
			dataOut.flush();
			if (loggedin==1){
				if (value.equals("\n")){}
				else if(value.equals("")){}
			}
		} catch (Exception e) {
			e.printStackTrace();
			loggedin=0;
		}
	}
	public String readUntil(String pattern) throws InterruptedException, IOException {
		char lastChar = pattern.charAt(pattern.length() - 1);
        StringBuffer buffer = new StringBuffer();
        char ch = (char) dataIn.read();
        while (runner==1) {
            buffer.append(ch);
        	if (ch == lastChar) {
            	//if (BearsClient.dw.dbm){BearsClient.dw.append(msg.trim());}
            	if (buffer.toString().endsWith(pattern)) {
                    return buffer.toString().trim();
                }
            }
            ch = (char) dataIn.read();
        }
       	return null;
        }

}