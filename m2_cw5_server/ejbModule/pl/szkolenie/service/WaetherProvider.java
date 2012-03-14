package pl.szkolenie.service;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;

import pl.szkolenie.ws.Weather;
import pl.szkolenie.ws.WeatherSoap;

@WebService
@Stateless
public class WaetherProvider {
	
	@WebServiceRef(Weather.class)
	private WeatherSoap soap;

	public String getCityWeatherByZIP(String zip) {
		return soap.getCityWeatherByZIP(zip).toString();
	}

}
