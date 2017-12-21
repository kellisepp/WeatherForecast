
import static org.junit.Assert.*;


import org.json.JSONObject;
import org.junit.Test;

import Repository.ConnectionToApi;

public class ConnectionToApiTest {
	@Test
	public void testIfConnectionToWeatherApiExists() {
		String url = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn&APPID=33d24dbe4f8dc4fabc901492abb1e123&units=metric";
		try {
			JSONObject connection = ConnectionToApi.connectHttpURL(url);
			assertNotNull(connection);
		} catch (Exception e) {
			System.out.println("Exception occurred");
		}
	}
	
	@Test
	public void testIfConnectionToForecastApiExists() {
		String url = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn&APPID=33d24dbe4f8dc4fabc901492abb1e123&units=metric";
		try {
			JSONObject connection = ConnectionToApi.connectHttpURL(url);
			assertNotNull(connection);
		} catch (Exception e) {
			System.out.println("Exception occurred");
		}
	}
}
