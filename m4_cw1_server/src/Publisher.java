import javax.xml.ws.Endpoint;

import pl.szkolenie.service.EchoServiceImpl;


public class Publisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/EchoServer", new EchoServiceImpl());
	}
}
