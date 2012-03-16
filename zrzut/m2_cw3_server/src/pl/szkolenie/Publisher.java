package pl.szkolenie;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.xml.ws.Endpoint;

import pl.szkolenie.service.TimeServerImpl;

public class Publisher {

	public static void main(String[] args) {
		Endpoint endpoint = Endpoint.create(new TimeServerImpl());
		endpoint.setExecutor(new ThreadPoolExecutor(10, 20, 100,
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20)));
		endpoint.publish("http://localhost:9999/TimeService");
		System.out.println("TimerServer is up and running...");
	}

}
