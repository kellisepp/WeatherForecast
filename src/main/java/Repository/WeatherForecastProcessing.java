package Repository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherForecastProcessing {
    ArrayList<JSONObject> dayOne = new ArrayList<JSONObject>();
    ArrayList<JSONObject> dayTwo = new ArrayList<JSONObject>();
    ArrayList<JSONObject> dayThree = new ArrayList<JSONObject>();
    ArrayList<Double> dayOneTemperatures = new ArrayList<Double>();
    ArrayList<Double> dayTwoTemperatures = new ArrayList<Double>();
    ArrayList<Double> dayThreeTemperatures = new ArrayList<Double>();
    String formattedDayOne;
    String formattedDayTwo;
    String formattedDayThree;
 
	public void seperateDaysAndTemperatures(JSONArray listOfForecasts) throws JSONException {
	    SimpleDateFormat YearMonthDayFormat = new SimpleDateFormat("yyyy-MM-dd");
	   
		Calendar calDayOne = Calendar.getInstance();
		calDayOne.add(Calendar.DATE, 1);
		Calendar calDayTwo = Calendar.getInstance();
		calDayTwo.add(Calendar.DATE, 2);
		Calendar calDayThree = Calendar.getInstance();
		calDayThree.add(Calendar.DATE, 3);
		
		this.formattedDayOne = YearMonthDayFormat.format(calDayOne.getTime());
		this.formattedDayTwo = YearMonthDayFormat.format(calDayTwo.getTime());
		this.formattedDayThree = YearMonthDayFormat.format(calDayThree.getTime());
	    
		for (int i = 0; i < listOfForecasts.length(); i++) {
			
			JSONObject obj = listOfForecasts.getJSONObject(i);	
			if (obj.get("dt_txt").toString().contains(formattedDayOne)) {
				dayOne.add(obj);
				double temperature = obj.getJSONObject("main").getDouble("temp");
				this.dayOneTemperatures.add(temperature);
				
			} else if (obj.get("dt_txt").toString().contains(formattedDayTwo)) {
				dayTwo.add(obj);
				double temperature = obj.getJSONObject("main").getDouble("temp");
				this.dayTwoTemperatures.add(temperature);
				
			} else if (obj.get("dt_txt").toString().contains(formattedDayThree)) {
				dayThree.add(obj);
				double temperature = obj.getJSONObject("main").getDouble("temp");
				this.dayThreeTemperatures.add(temperature);
			}
		}
		System.out.println("teised" + this.dayTwoTemperatures);
		
	}
	
	public double getMinTemperature(ArrayList<Double> temperatures) {
		System.out.println("yay" + temperatures);
		return Collections.min(temperatures);
	}

	public double getMaxTemperature(ArrayList<Double> temperatures) {
		return Collections.max(temperatures);
	}
}
