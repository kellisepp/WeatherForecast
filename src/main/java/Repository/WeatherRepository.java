package Repository;


import static Model.Constants.API_KEY;

import java.io.IOException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Model.CurrentWeatherResponse;
import Model.Days;
import Model.Request;
import Model.WeatherForecast;
import Repository.WeatherForecastProcessing;
import Model.WeatherForecastResponse;
import okhttp3.HttpUrl;

public class WeatherRepository {

	public CurrentWeatherResponse getCurrentWeather(Request request, ConnectionToApi connection) throws IOException, JSONException {
		 URL requestURL = new HttpUrl.Builder()
				.scheme("https")
				.host("api.openweathermap.org")
				.addPathSegment("/data/2.5/weather")
				.addQueryParameter("q", request.cityName)
				.addQueryParameter("appid", API_KEY)
				.addQueryParameter("units", request.unit)
				.build().url();
		String requestUrl = requestURL.toString();
		JSONObject json = connection.connectHttpURL(requestUrl);
		String name = json.getString("name");
		double temperature = json.getJSONObject("main").getDouble("temp");
		double latitude = json.getJSONObject("coord").getDouble("lat");
		double longitude = json.getJSONObject("coord").getDouble("lon");

		CurrentWeatherResponse response = new CurrentWeatherResponse(name, temperature, latitude, longitude);
		System.out.println(temperature + response.toString());
		return response;
	}
	
	public WeatherForecastResponse getWeatherForecast(Request request, ConnectionToApi connection) throws IOException, JSONException {
		 URL requestURL = new HttpUrl.Builder()
				.scheme("https")
				.host("api.openweathermap.org")
				.addPathSegment("/data/2.5/forecast")
				.addQueryParameter("q", request.cityName)
				.addQueryParameter("appid", request.apiKey)
				.addQueryParameter("units", request.unit)
				.build().url();
		String requestUrl = requestURL.toString();
		JSONObject json = connection.connectHttpURL(requestUrl);
		double latitude = json.getJSONObject("city").getJSONObject("coord").getDouble("lat");
		double longitude = json.getJSONObject("city").getJSONObject("coord").getDouble("lon");
		String cityName = json.getJSONObject("city").getString("name");
		JSONArray listOfForecasts = json.getJSONArray("list");
		
		WeatherForecastProcessing weatherForecast = new WeatherForecastProcessing();
		weatherForecast.seperateDaysAndTemperatures(listOfForecasts);
		
		WeatherForecast dayOne = new WeatherForecast(weatherForecast.formattedDayOne,
				weatherForecast.getMinTemperature(weatherForecast.dayOneTemperatures),
				weatherForecast.getMaxTemperature(weatherForecast.dayOneTemperatures));
		
		WeatherForecast dayTwo = new WeatherForecast(weatherForecast.formattedDayTwo,
				weatherForecast.getMinTemperature(weatherForecast.dayTwoTemperatures),
				weatherForecast.getMaxTemperature(weatherForecast.dayTwoTemperatures));
		
		WeatherForecast dayThree = new WeatherForecast(weatherForecast.formattedDayThree,
				weatherForecast.getMinTemperature(weatherForecast.dayThreeTemperatures),
				weatherForecast.getMaxTemperature(weatherForecast.dayThreeTemperatures));
		
		Days days = new Days(dayOne, dayTwo, dayThree);
		
		WeatherForecastResponse response = new WeatherForecastResponse(cityName, days, latitude, longitude);
		return response;
	}
}
