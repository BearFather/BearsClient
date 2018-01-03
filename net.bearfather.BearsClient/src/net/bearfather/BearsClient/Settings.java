package net.bearfather.BearsClient;

public class Settings {
	private static boolean timestamp=true;
	private static String cleanup="Sorry to interrupt, but the system will be shutting";
	private static String user;
	private static String password;
	private static String puser="Otherwise type \"\\u001B[36mnew\\u001B[32m\"\\:";
	private static String ppass="Enter your password\\:";
	private static String pmenu="Fantasy awaits:";
	private static String pmud="[MAJORMUD]";
	
	public boolean isTimestamp() {
		return timestamp;
	}

	public void setTimestamp(boolean timestamp) {
		Settings.timestamp = timestamp;
	}

	public String getCleanup() {
		return cleanup;
	}

	public void setCleanup(String cleanup) {
		Settings.cleanup = cleanup;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		Settings.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Settings.password = password;
	}

	public String getPuser() {
		return puser;
	}

	public void setPuser(String puser) {
		Settings.puser = puser;
	}

	public String getPpass() {
		return ppass;
	}

	public void setPpass(String ppass) {
		Settings.ppass = ppass;
	}

	public String getPmenu() {
		return pmenu;
	}

	public void setPmenu(String pmenu) {
		Settings.pmenu = pmenu;
	}

	public String getPmud() {
		return pmud;
	}

	public void setPmud(String pmud) {
		Settings.pmud = pmud;
	}
}
