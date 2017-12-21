package Repository;

import java.io.FileOutputStream;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.json.JSONException;

import Model.CurrentWeatherResponse;
import Model.WeatherForecastResponse;

public class Output {

	public void writeWeatherOutputToFile(String city, CurrentWeatherResponse response) throws IOException, JSONException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		FileOutputStream file = new FileOutputStream("/Users/kellisepp/git/WeatherForecast/"+ city +".json", true);
		writer.writeValue(file, response);		
	}
	
	public void writeForecastOutputToFile(String city, WeatherForecastResponse response) throws IOException, JSONException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		FileOutputStream file = new FileOutputStream("/Users/kellisepp/git/WeatherForecast/"+ city +".json", true);
		writer.writeValue(file, response);
	}
		
}

