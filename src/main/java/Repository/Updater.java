package Repository;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import static Model.Constants.API_KEY;

import org.json.JSONException;

import Model.CurrentWeatherResponse;
import Model.Request;
import Model.WeatherForecastResponse;

public class Updater {
	
	public ArrayList<String> writeFilesAndReturnListOfCities(WeatherRepository repository, Input input, Output output) throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {
		ArrayList<String> listOfCities = new ArrayList<String>();
    	//listOfCities = inputAsker.getCityFromConsole();
    	listOfCities = input.getCityFromFile();
    	for(String city: listOfCities) {
    		Request request = new Request(city, "metric", API_KEY);
	        CurrentWeatherResponse weatherResponse = repository.getCurrentWeather(request);
	        WeatherForecastResponse forecastResponse = repository.getWeatherForecast(request);
	        output.writeWeatherOutputToFile(city, weatherResponse);
	        output.writeForecastOutputToFile(city, forecastResponse);
    	}
    	return listOfCities;
	}
	

}
