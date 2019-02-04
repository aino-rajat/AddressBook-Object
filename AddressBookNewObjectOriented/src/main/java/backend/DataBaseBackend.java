package backend;

public class DataBaseBackend implements Backend {

	private String Ip_address;
	private String Database_name;
	private String url;
	private String password;
	private String username;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getIp_address() {
		return Ip_address;
	}
	public void setIp_address(String ip_address) {
		Ip_address = ip_address;
	}
	public String getDatabase_name() {
		return Database_name;
	}
	public String getPassword() {
		return password;
	}
	
	
	public void setDatabase_name(String database_name) {
		Database_name = database_name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return url+" "+username+" "+password;
	}

	
}
	


