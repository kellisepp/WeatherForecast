package Repository;

import java.io.FileOutputStream;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import Model.CurrentWeatherResponse;
import Model.WeatherForecastResponse;

public class Output {

	public void writeOutputToFile(CurrentWeatherResponse response) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		FileOutputStream file = new FileOutputStream("/Users/kellisepp/git/WeatherForecast/output"+".txt");
		writer.writeValue(file, response);
	}
	
	public void writeOutputToFile(WeatherForecastResponse response) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		FileOutputStream file = new FileOutputStream("/Users/kellisepp/git/WeatherForecast/output_forecast"+".txt", true);
		writer.writeValue(file, response);
	}
		
}

