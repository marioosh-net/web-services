package pl.szkolenie;
import javax.xml.ws.Endpoint;

import pl.szkolenie.service.TimeServerImpl;


public class Publisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/TimeService", new TimeServerImpl());
		System.out.println("TimerServer is up and running...");
	}

}
