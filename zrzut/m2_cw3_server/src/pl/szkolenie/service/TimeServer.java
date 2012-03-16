package pl.szkolenie.service;

import javax.jws.WebService;

@WebService
public interface TimeServer {

	String getTime();
	
	long getTimeElapsed();
	
}
