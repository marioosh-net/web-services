package pl.szkolenie;

import javax.xml.ws.Endpoint;

import pl.szkolenie.service.UsersRepositoryImpl;

public class Publisher {

	public static void main(String[] args) {
		System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");
		Endpoint.publish("http://localhost:9999/UsersRepository", new UsersRepositoryImpl());
		System.out.println("UsersRepository is up  and running...");
	}

}
