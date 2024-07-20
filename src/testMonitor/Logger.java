package testMonitor;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

	private static final String LOG_FILE = "network_monitor .log";
	public static void log(String message) {
		try(FileWriter writer = new FileWriter(LOG_FILE, true)) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			
			writer.write(dtf.format(now) + " _ " + message + "\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
