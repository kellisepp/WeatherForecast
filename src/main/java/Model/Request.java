package Model;

public class Request {
	public String cityName;
	public String unit;
	public String apiKey;

	public Request(String cityName, String unit, String apiKey) {
		this.cityName = cityName;
		this.unit = unit;
		this.apiKey = apiKey;
	}	
}
