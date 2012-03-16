package pl.szkolenie;

import com.cdyne.ws.weatherws.Weather;
import com.cdyne.ws.weatherws.WeatherSoap;

public class Consumer {

	public static void main(String[] args) {
		// http://wsf.cdyne.com/WeatherWS/Weather.asmx?wsdl
		Weather service = new Weather();
		WeatherSoap weatherService = service.getWeatherSoap();
		
		System.out.println(weatherService.getCityWeatherByZIP("79251"));
	}

}
