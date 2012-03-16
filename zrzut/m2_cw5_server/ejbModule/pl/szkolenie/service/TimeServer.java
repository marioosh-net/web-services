package pl.szkolenie.service;

import javax.ejb.Remote;
import javax.jws.WebService;

@Remote
@WebService
public interface TimeServer {

	String getTime();
	
	long getTimeElapsed();
	
}
