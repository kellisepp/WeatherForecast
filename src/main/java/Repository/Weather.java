package Repository;
import static Model.Constants.API_KEY;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import Model.CurrentWeatherResponse;
import Model.Request;
import Model.WeatherForecastResponse;

import static Model.Constants.API_KEY;

public class Weather {

	public static void main (String[] args) throws IOException, JSONException, ParseException {
		Input location = new Input();
		Output output = new Output();
		WeatherRepository weather = new WeatherRepository();
		
		//ArrayList<String> listOfCities = location.getCityFromConsole();
		ArrayList<String> listOfCities = location.getCityFromFile();
 
		for(String city: listOfCities) {
    		Request request = new Request(city, "metric", API_KEY);
	        CurrentWeatherResponse weatherResponse = weather.getCurrentWeather(request);
	        WeatherForecastResponse forecastResponse = weather.getWeatherForecast(request);
	        output.writeWeatherOutputToFile(city, weatherResponse);
	        output.writeForecastOutputToFile(city, forecastResponse);
		}
	}

}
