package Repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject;


public class Input {
	
	public ArrayList<String> getCityFromConsole() {
		ArrayList<String> listOfCities = new ArrayList<String>();
		System.out.println("Enter a city: ");
    	Scanner reader = new Scanner(System.in);
		String city = reader.nextLine();
		listOfCities.add(city);
		reader.close();
		return listOfCities;
    }
	
	public ArrayList<String> getCityFromFile() throws IOException, ParseException, JSONException {
		ArrayList<String> listOfCities = new ArrayList<String>();
		JSONParser parser = new JSONParser();
        
        JSONObject object = (JSONObject) parser.parse(new FileReader("/Users/kellisepp/git/WeatherForecast/input.json"));
        JSONArray request = (JSONArray) object.get("request");
        for (Object o : request) {
        	JSONObject city = (JSONObject) o;
        	String cityName = (String) city.get("city");
        	listOfCities.add(cityName);
        }
  
        return listOfCities;
	}
}