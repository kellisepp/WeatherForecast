import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.Test;

import Model.CurrentWeatherResponse;
import Model.WeatherForecastResponse;
import Repository.Input;
import Repository.Output;
import Repository.Updater;
import Repository.WeatherRepository;

public class FileControllersTest {
	
	 @Test
		public void testIfFileWritingWorks() throws IOException, JSONException, ParseException, org.json.simple.parser.ParseException {
			Output outputMock = mock(Output.class);
			Updater updater = new Updater();
			WeatherRepository weatherRepo = new WeatherRepository();
			Input input = new Input();
			
			updater.writeFilesAndReturnListOfCities(weatherRepo, input, outputMock);
			
			verify(outputMock, times(input.getCityFromFile().size())).writeWeatherOutputToFile(anyString(), any(CurrentWeatherResponse.class));
			verify(outputMock, times(input.getCityFromFile().size())).writeForecastOutputToFile(anyString(), any(WeatherForecastResponse.class));
		}
	 
	 @Test
		public void testInputAskerFromConsole() {
			Input input = new Input();
			assertEquals(input.getCityFromConsole().size(), 1);
		}
		
		@Test
		public void testInputAskerFromFile() throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {
			Input inputAsker = new Input();
			assertTrue(inputAsker.getCityFromFile().size()>0);
		}
		
		@Test
		public void testIfUpdaterWorksWithFile() throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {
			Updater updater = new Updater();
			Input input = new Input();
			WeatherRepository weatherRepo = new WeatherRepository();
			Output output = new Output();
			assertEquals(updater.writeFilesAndReturnListOfCities(weatherRepo, input, output).size(), input.getCityFromFile().size());
		}
		
		@Test
		public void testUpdaterWithInputReaderMock() throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {
			Input inputMock = mock(Input.class);
			WeatherRepository weatherRepoMock = mock(WeatherRepository.class);
			Updater updater = new Updater();
			Output output = new Output();
			ArrayList<String> listOfCities = new ArrayList<String>();
			listOfCities.add("Tallinn");
			listOfCities.add("Dummy");
			when(inputMock.getCityFromFile()).thenReturn(listOfCities);
			
			assertEquals(updater.writeFilesAndReturnListOfCities(weatherRepoMock, inputMock, output), listOfCities);
		}
		
}
