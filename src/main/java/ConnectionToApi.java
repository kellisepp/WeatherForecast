/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import java.io.IOException;
import java.net.URL;

import okhttp3.*;

public class ConnectionToApi {
	OkHttpClient client = new OkHttpClient();

	public URL getCurrentWeatherRequestURL(CurrentWeatherRequest request) {
		URL requestURL = new HttpUrl.Builder()
				.scheme("https")
				.host("api.openweathermap.org")
				.addPathSegment("/data/2.5/weather")
				.addQueryParameter("q", request.countryCode+","+request.cityName)
				.addQueryParameter("appid", request.apiKey)
				.build().url();
		return requestURL;
	}
	
	public URL getWeatherForecastRequestURL(WeatherForecastRequest request) {
		URL requestURL = new HttpUrl.Builder()
				.scheme("https")
				.host("api.openweathermap.org")
				.addPathSegment("/data/2.5/weather")
				.addQueryParameter("q", request.countryCode+","+request.cityName)
				.addQueryParameter("cnt", String.valueOf(request.numberOfDays))
				.addQueryParameter("appid", request.apiKey)
				.build().url();
		return requestURL;
	}
	
	public String makeApiRequest(String url) throws IOException {
		Request request = new Request.Builder()
			.url(url)
			.build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}