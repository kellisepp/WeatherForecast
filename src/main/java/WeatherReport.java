import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherReport {

	ConnectionToApi httpRequest = new ConnectionToApi();

	public JSONObject getCurrentTemperature(CurrentWeatherRequest request) {
		String requestUrl = httpRequest.getCurrentWeatherRequestURL(request).toString();
		try {
			String response = httpRequest.makeApiRequest(requestUrl);
			JSONObject JSONresponse = new JSONObject(response);
			return JSONresponse;
		} catch(IOException error) {
			System.out.println("IOException: " + error);
		} catch (JSONException error) {
			System.out.println("IOException: " + error);
		}
	}
	public JSONObject getWeatherForecast(WeatherForecastRequest request) {
		String requestUrl = httpRequest.getWeatherForecastRequestURL(request).toString();
		try {
			String response = httpRequest.makeApiRequest(requestUrl);
			JSONObject JSONresponse = new JSONObject(response);
			return JSONresponse;
		} catch(IOException error) {
			System.out.println("IOException: " + error);
		} catch (JSONException error) {
			System.out.println("IOException: " + error);
		}
	}
	public JSONObject getCityCoordinates(CurrentWeatherRequest request) {
		String requestUrl = httpRequest.getCurrentWeatherRequestURL(request).toString();
		try {
			String response = httpRequest.makeApiRequest(requestUrl);
			JSONObject JSONresponse = new JSONObject(response);
			return JSONresponse;
		} catch(IOException error) {
			System.out.println("IOException: " + error);
		} catch (JSONException error) {
			System.out.println("IOException: " + error);
		}
	}
}
