package pl.szkolenie.service;
import javax.jws.WebService;


@WebService
public interface EchoService {
	String echo(String text);
}	
