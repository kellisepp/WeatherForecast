
public class WeatherForecastRequest extends CurrentWeatherRequest {
	public int numberOfDays;
	
	public WeatherForecastRequest(String cityname, String countryCode, String apiKey, int numberOfdays) {
		super(cityname, countryCode, apiKey);
		this.numberOfDays = numberOfDays;
	}
}
