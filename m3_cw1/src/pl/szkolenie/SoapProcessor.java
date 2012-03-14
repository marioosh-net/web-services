package pl.szkolenie;

import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class SoapProcessor {
	private static final String NAMESPACE = "http://pl.szkolenie/";
	private static final String PREFIX = "ns2";
	private static final String OPERATION_NAME = "getTimeElapsed";
	private static final String OPERATION_RESPONSE_NAME = "getTimeElapsedResponse";
	
	public static void main(String[] args) throws SOAPException, IOException {
		SoapProcessor processor = new SoapProcessor();
		processor.makeRequest();
	}
	
	private void makeRequest() throws SOAPException, IOException {
		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage request = factory.createMessage();
		SOAPEnvelope envelope = request.getSOAPPart().getEnvelope();
		SOAPBody body = request.getSOAPBody();
		
		Name name = envelope.createName(OPERATION_NAME, PREFIX, NAMESPACE);
		body.addBodyElement(name);
		request.writeTo(System.out);
	}
}
