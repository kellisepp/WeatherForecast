package Model;

public class CurrentWeatherResponse {
	public String name;
	public double temperature;
	public double latitude;
	public double longitude;
	
	public CurrentWeatherResponse(String name, double temperature,  double latitude, double longitude) {
		this.name = name;
		this.temperature = temperature;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}
