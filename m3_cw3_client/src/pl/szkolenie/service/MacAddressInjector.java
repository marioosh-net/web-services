package pl.szkolenie.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class MacAddressInjector implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean isRequest = (Boolean) context
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		try {
			if (isRequest) {
				SOAPMessage message = context.getMessage();
				SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				if (header == null) {
					header = envelope.addHeader();
				}

				QName qName = new QName("http://szkolenie.pl/", "MacAddress");
				SOAPHeaderElement element = header.addHeaderElement(qName);
				element.addTextNode(getMacAddress());

				message.saveChanges();
				message.writeTo(System.out);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getMacAddress() throws UnknownHostException, SocketException {
		InetAddress ip = InetAddress.getLocalHost();
		NetworkInterface networkInterface = NetworkInterface
				.getByInetAddress(ip);
		byte[] mac = networkInterface.getHardwareAddress();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			result.append(String.format("%02X%s", mac[i],
					(i < mac.length - 1 ? "-" : "")));
		}
		System.out.println(result.toString());
		return result.toString();
	}
}
