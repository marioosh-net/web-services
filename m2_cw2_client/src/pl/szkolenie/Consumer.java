package pl.szkolenie;

import pl.szkolenie.ws.Weather;
import pl.szkolenie.ws.WeatherSoap;

public class Consumer {
	public static void main(String[] args) {
		Weather service = new Weather();
		WeatherSoap weatherService = service.getWeatherSoap();
		
		// 46582 - Warsaw
		System.out.println(weatherService.getCityWeatherByZIP("46582"));
	}
}
