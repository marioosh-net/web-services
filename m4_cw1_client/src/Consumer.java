import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import pl.szkolenie.service.EchoService;


public class Consumer {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:9999/EchoServer?wsdl");
		QName serviceName = new QName("http://service.szkolenie.pl/", "EchoServiceImplService");		
		QName portName = new QName("http://service.szkolenie.pl/", "EchoServiceImplPort");
		Service service = Service.create(url, serviceName);
		EchoService echoServer = service.getPort(portName, EchoService.class);
		
		Map<String, Object> ctx = ((BindingProvider)echoServer).getRequestContext();
		Map<String, List<String>> headers = new HashMap();
		headers.put("Username", Collections.singletonList("mario"));
		headers.put("Password", Collections.singletonList("password"));
		
		ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		
		System.out.println(echoServer.echo("abcd"));
	}

}
