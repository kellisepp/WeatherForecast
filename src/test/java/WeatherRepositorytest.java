
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONException;
import org.junit.*;

import Model.CurrentWeatherResponse;
import Model.Days;
import Model.Request;
import Model.WeatherForecastResponse;
import Model.WeatherForecast;
import Repository.Output;
import Repository.Weather;
import Repository.WeatherForecastProcessing;
import Repository.WeatherRepository;


public class WeatherRepositorytest {
	private static Request request;
    private static CurrentWeatherResponse weatherResponse;
    private static WeatherForecastResponse forecastResponse;

    @BeforeClass
    	
    public static void setUpAllTests() throws IOException, JSONException, ParseException {
    	WeatherRepository weatherRepo = new WeatherRepository();
    	request = new Request("Tallinn", "metric", "33d24dbe4f8dc4fabc901492abb1e123");
	    	try{
		    	weatherResponse = weatherRepo.getCurrentWeather(request);
		    forecastResponse = weatherRepo.getWeatherForecast(request);

	    } catch(Exception e){
	        fail("All test will be ignored, cause: " + e.getMessage());
	    }
   }
    
    @Test
    public void testIfReqCityEqualsResCity() throws IOException, JSONException {
        try{
            assertEquals(request.cityName, weatherResponse.name);
            assertEquals(request.cityName, forecastResponse.cityName);
        }catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        }
    }
    
    
    @Test
    public void testIfCallingRequestReturnResponse() throws IOException, JSONException {
	    	WeatherRepository WeatherRepoMock = mock(WeatherRepository.class);
	    	Request request = mock(Request.class);
	    	WeatherForecast forecastDummy = new WeatherForecast("20-20-20",0.2,12.2);
	    	Days days = new Days (forecastDummy, forecastDummy, forecastDummy);
	    	CurrentWeatherResponse response = new CurrentWeatherResponse("Narva", 24, 10, 120);
	    WeatherForecastResponse forecastResponse = new WeatherForecastResponse("Narva", days, 0, 0);
	    	when(WeatherRepoMock.getCurrentWeather(request)).thenReturn(response);
	    when(WeatherRepoMock.getWeatherForecast(request)).thenReturn(forecastResponse);
	    
	    assertEquals(WeatherRepoMock.getWeatherForecast(request), forecastResponse);
	    assertEquals(WeatherRepoMock.getCurrentWeather(request), response);
    }
 
    @Test
    public void testIfWeatherForecastDatesAreValid(){
        try{

	        Calendar cal1 = Calendar.getInstance();
	    	    cal1.add(Calendar.DATE, 1);
	    	    Calendar cal2 = Calendar.getInstance();
	    	    cal2.add(Calendar.DATE, 2);
	    	    Calendar cal3 = Calendar.getInstance();
	    	    cal3.add(Calendar.DATE, 3);
	    	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    	    String formatted1 = format1.format(cal1.getTime());
	    	    String formatted2 = format1.format(cal2.getTime());
	    	    String formatted3 = format1.format(cal3.getTime());
	            // [when]
	        	Days days = forecastResponse.forecastDays;
	        	// [then]
	            assertEquals(days.dayOne.date, formatted1.toString());
	            assertEquals(days.dayTwo.date, formatted2.toString());
	            assertEquals(days.dayThree.date, formatted3.toString());
	     }catch (Exception e){
            fail("Test failed, cause: " + e.getMessage());
        }
    }
   
    
    @Test
    public void testIfMinAndMaxTemperaturesAreValid() {
        try{
	        	Days days = forecastResponse.forecastDays;
	            // [then]
	        	assertTrue(days.dayThree.maxTemperature < 50);
	        assertTrue(days.dayThree.minTemperature > -50);
	        assertTrue(days.dayThree.minTemperature < days.dayThree.maxTemperature);
        }catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        
        }
    }
    
    @Test
    public void testIfGetsMinTemperature() throws JSONException {
	    	ArrayList<Double> listOfTemps = new ArrayList<>();
	    	listOfTemps.add(0.5);
	    listOfTemps.add(10.0);
	    listOfTemps.add(100.1);
	    	
	    WeatherForecastProcessing data = new WeatherForecastProcessing();
	    assertTrue(data.getMinTemperature(listOfTemps) == 0.5);
    }
    
    @Test
    public void testIfGetsMaxTemperature() throws JSONException {
	    	ArrayList<Double> listOfTemps = new ArrayList<>();
	    	listOfTemps.add(0.5);
	    listOfTemps.add(10.0);
	    listOfTemps.add(100.1);
	    	
	    try {
		    WeatherForecastProcessing data = new WeatherForecastProcessing();
		    assertTrue(data.getMaxTemperature(listOfTemps) == 100.1);
		}catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        }
    }
    
    @Test
    public void testIfCurrentWeatherResponseCoordinatesAreValid() {
        try{
            assertTrue(weatherResponse.latitude < 90 && weatherResponse.latitude > -90 );
            assertTrue(weatherResponse.longitude < 180 && weatherResponse.longitude > -180);
        }catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        }
    }
    
    public void testIfWeatherForecastResponseCoordinatesAreValid() {
        try{
            assertTrue(forecastResponse.latitude < 90 && forecastResponse.latitude > -90 );
            assertTrue(forecastResponse.longitude < 180 && forecastResponse.longitude > -180);
        }catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        }
    }
    
    @Test
    public void testIfTemperaturesAreValid() {
        try{
        		assertTrue(weatherResponse.temperature < 50 && weatherResponse.temperature > -50);
        }catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        }
    }
    
   

}
