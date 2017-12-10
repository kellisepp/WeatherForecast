package Model;

public class WeatherForecast {
	public String date;
	public double minTemperature;
	public double maxTemperature;
	
	public WeatherForecast(String date, double minTemperature, double maxTemperature) {
		this.date = date;
		this.minTemperature = minTemperature;
		this.maxTemperature = maxTemperature;
	}	
}
