
public class CurrentWeatherRequest {
	public String cityName;
	public String countryCode;
	public String apiKey;
	
	public CurrentWeatherRequest(String cityname, String countryCode, String apiKey) {
		this.cityName = cityName;
		this.countryCode = countryCode;
		this.apiKey = apiKey;
	}
}
