package pl.szkolenie.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService
public class TimeServerImpl implements TimeServer {

	private SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
	
	@Override
	public String getTime() {
		return formatter.format(new Date());
	}

	@Override
	public long getTimeElapsed() {
		return System.currentTimeMillis();
	}

}
