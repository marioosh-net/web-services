package pl.szkolenie.service;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class EchoServiceImpl implements EchoService {

	@Resource
	WebServiceContext context;
	
	@Override
	public String echo(String text) {
		return text;
	}
	
	private boolean authenticate() {
		MessageContext msgContext = context.getMessageContext();
		Map headers = (Map) msgContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userHeader = (List) headers.get("Username");
		List passwordHeader = (List) headers.get("Password"); 
		
		String user = "";
		String password = "";
		
		if(userHeader != null) {
			user = userHeader.get(0).toString();
		}
		
		if(passwordHeader != null) {
			password = passwordHeader.get(0).toString();
		}
		
		return user.equals("mario") && password.equals("password");
		
	}

}
