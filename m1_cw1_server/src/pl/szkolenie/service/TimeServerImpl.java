package pl.szkolenie.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;

@WebService
public class TimeServerImpl implements TimeServer {

	private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	
	@Override
	public String getTime() {
		return formatter.format(new Date());
	}

	@Override
	public long getTimeElapsed() {
		return System.currentTimeMillis();
	}

}
