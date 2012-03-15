package pl.szkolenie.service;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

public class MacAddressValidator implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(!isRequest) {
			try {			
				SOAPMessage message = context.getMessage();
				SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				if(header == null) {
					header = envelope.addHeader();
					sendError(message, "No SOAP Header");
				}
				Iterator headers = header.examineAllHeaderElements();
				if(headers == null || !headers.hasNext()) {
					sendError(message, "No header blocks");
				}
				String mac = null;
				while(headers.hasNext()) {
					Node node = (Node)headers.next();
					if(node.getLocalName().equals("MacAddress")) {
						mac = node.getValue();
					}
				}
				if(mac == null || !mac.equals("00-16-17-9A-55-74-")) {
					sendError(message, "Invalid mac address");
				}
			} catch (SOAPException e) {
				e.printStackTrace();
			}

		}
		return false;
	}

	private void sendError(SOAPMessage message, String string) {
		try {
			SOAPBody body = message.getSOAPBody();
			SOAPFault fault = body.addFault();
			fault.setFaultString(string);
			throw new SOAPFaultException(fault);
		} catch (SOAPException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return false;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
