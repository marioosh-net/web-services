package pl.szkolenie;

import javax.xml.ws.Endpoint;

import pl.szkolenie.service.UserRepositoryImpl;

public class Publisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/UsersRepository", new UserRepositoryImpl());
		System.out.println("UserRepository is up and running...");
	}
}
