package testMonitor;

public class Device {
	
	private String ipAddress;
	private String name;
	
	public Device (String ipAddress, String name) {
		this.ipAddress= ipAddress;
		this.name= name;
		
	}
	public String getIpAddress() {
		return ipAddress;
		
	}
	public String getName() {
		return name;
		
	}

}
