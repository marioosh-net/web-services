package pl.szkolenie.service;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;

import com.cdyne.ws.weatherws.Weather;
import com.cdyne.ws.weatherws.WeatherSoap;

@WebService
@Stateless
public class WeatherProvider {
	
	@WebServiceRef(Weather.class)
	private WeatherSoap soap;

	public String getCityWeatherByZIP(String zip) {
		return soap.getCityWeatherByZIP(zip).toString();
	}
	
}
