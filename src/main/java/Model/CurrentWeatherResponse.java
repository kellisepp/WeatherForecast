package Model;

public class CurrentWeatherResponse {
	public double temperature;
	public double latitude;
	public double longitude;
	
	public CurrentWeatherResponse(double temperature,  double latitude, double longitude) {
		this.temperature = temperature;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}
