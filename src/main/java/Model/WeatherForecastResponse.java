package Model;
public class WeatherForecastResponse {
	public String cityName;
	public Days forecastDays;
	public double latitude;
	public double longitude;
	public WeatherForecastResponse(String cityName, Days forecastDays, double latitude, double longitude) {
		super();
		this.cityName = cityName;
		this.forecastDays = forecastDays;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
}
