package Repository;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONException;

import Model.CurrentWeatherResponse;
import Model.Request;
import Model.WeatherForecastResponse;

import static Model.Constants.API_KEY;

public class Weather {

    
    Output output = new Output();
	public static void main (String[] args) throws IOException, JSONException {
		Input location = new Input();
		
		location.getUserInput();
        location.saveUserInputToFile();
        
        File file = new File ("/Users/kellisepp/git/WeatherForecast/input.txt");
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
            String cityName = scanner.nextLine();

            Request request = new Request(cityName, "metric", API_KEY);
            WeatherRepository weather = new WeatherRepository();
            Output output = new Output();
            
            CurrentWeatherResponse currentWeatherResponse = weather.getCurrentWeather(request);           
            WeatherForecastResponse weatherForecastResponse = weather.getWeatherForecast(request);
            
            output.writeOutputToFile(currentWeatherResponse);
            output.writeOutputToFile(weatherForecastResponse);
            System.out.println("Done");
		}
		scanner.close ();
	}

}
