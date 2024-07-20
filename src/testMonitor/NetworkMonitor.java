package testMonitor;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class NetworkMonitor {

	private List<Device> devices = new ArrayList<>();
	
	public void addDevice(Device device) {
		devices.add(device);
	}
	
	public void monitorDevices() {
		for(Device device : devices) {
			boolean isReachable = pingDevice(device);
			if(isReachable) {
				Logger.log("Device " + device.getName() + " (" + device.getIpAddress() + ") is UP");
			}else {
				Logger.log("Device " + device.getName() + "(" + device.getIpAddress() + " ) is DOWN");
			}
		}
		
	}
	
	private boolean pingDevice(Device device) {
		try {
			InetAddress inet =Inet4Address.getByName(device.getIpAddress());
			return inet.isReachable(2000);
			
		}catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void main(String[] args) {
		
		NetworkMonitor monitor = new NetworkMonitor();
		
		monitor.addDevice(new Device("192.168.1.1", "Router"));
		monitor.addDevice(new Device("192.168.1.2", "Switch"));
		monitor.addDevice(new Device("192.168.1.3", "Server"));
		
		monitor.monitorDevices();
	}

}
