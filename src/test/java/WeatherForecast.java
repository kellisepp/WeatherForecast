import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.json.JSONObject;
import org.junit.Test;

public class WeatherForecast {
	String mockCountryCode = "EE";
	String mockCityName = "Tallinn";
	int mockNumberOfDays = 3;
	String apiKey = "33d24dbe4f8dc4fabc901492abb1e123";
	
	@Test
	public void getsCurrentTemperatureReturnTemperature() {
		try {
			CurrentWeatherRequest request = new CurrentWeatherRequest(mockCityName, mockCountryCode, apiKey);
			WeatherReport report = new WeatherReport();
			JSONObject response = report.getCurrentTemperature(request);
			assertEquals(true, response.has("temp"));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void returnsForecastOfMultipleDays() {
		try {
			WeatherForecastRequest request = new WeatherForecastRequest(mockCityName, mockCountryCode, apiKey, mockNumberOfDays);
			WeatherReport report = new WeatherReport();
			JSONObject response = report.getWeatherForecast(request);
			assertEquals(true, response.has("cnt"));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}
	@Test
	public void getsCityCoordinates() {
		try {
			WeatherForecastRequest request = new WeatherForecastRequest(mockCityName, mockCountryCode, apiKey, mockNumberOfDays);
			WeatherReport report = new WeatherReport();
			JSONObject response = report.getWeatherForecast(request);
			assertEquals(true, response.has("coord"));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}
	@Test
	public void ResCityEqualsReqCity() {
		try {
			WeatherForecastRequest request = new WeatherForecastRequest(mockCityName, mockCountryCode, apiKey, mockNumberOfDays);
			WeatherReport report = new WeatherReport();
			JSONObject response = report.getWeatherForecast(request);
			assertEquals(true, response.has("name"));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}
}
