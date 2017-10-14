
import static org.junit.Assert.*;

import java.net.URL;
import org.junit.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class ConnectionToApiTest {
	String mockCountryCode = "EE";
	String mockCityName = "Tallinn";
	int mockNumberOfDays = 3;
	String apiKey = "33d24dbe4f8dc4fabc901492abb1e123";

			@Test
			public void testCurrentWeatherRequestReturnsURL() {
				try {
					CurrentWeatherRequest request = new CurrentWeatherRequest(mockCityName, mockCountryCode, apiKey);
					ConnectionToApi httprequest = new ConnectionToApi();
					URL response = httprequest.getCurrentWeatherRequestURL(request);
					System.out.println(response);
					assertThat(response, instanceOf(URL.class));
				} catch (Exception e){
					fail("Failure was caused by: "+ e.getMessage());
				}
			}

			@Test
			public void testWeatherForecastRequestReturnURL() {
				try {
					WeatherForecastRequest request = new WeatherForecastRequest(mockCityName, mockCountryCode, apiKey, mockNumberOfDays);
					ConnectionToApi httprequest = new ConnectionToApi();
					URL response = httprequest.getWeatherForecastRequestURL(request);
					assertThat(response, instanceOf(URL.class));
					// assertEquals( response, 200, response.getStatus());
				} catch (Exception e) {
					fail("Failure was caused by: " + e.getMessage());
				}
			}
}
