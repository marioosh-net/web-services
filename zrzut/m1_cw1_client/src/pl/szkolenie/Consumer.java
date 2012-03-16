package pl.szkolenie;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import pl.szkolenie.service.TimeServer;

public class Consumer {

	public static void main(String[] args) {
		try {
			URL wsdlLocation = new URL("http://localhost:9999/TimeService?wsdl");
			QName serviceName = new QName("http://service.szkolenie.pl/", "TimeServerImplService");
			QName portName = new QName("http://service.szkolenie.pl/", "TimeServerImplPort");
			Service service = Service.create(wsdlLocation, serviceName);
			TimeServer timeServer = service.getPort(portName, TimeServer.class);
			
			System.out.println("Current time: " + timeServer.getTime());
			System.out.println("Elapsed time: " + timeServer.getTimeElapsed());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
