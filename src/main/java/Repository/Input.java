package Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Input {
	String[] cityName;

	public void getUserInput() {
		
			Scanner scanner = new Scanner(System.in);
		    System.out.println("Please insert city name: ");
		    String userInput = scanner.nextLine();
		    this.cityName = userInput.split(",");
	}
	
	public void saveUserInputToFile() throws FileNotFoundException, UnsupportedEncodingException {
		System.out.println("yoyoyoy" + cityName);
		PrintWriter writer = new PrintWriter("input.txt", "UTF-8");
		
		for (int i = 0; i < cityName.length; i++) {
			writer.println(cityName[i].trim());
		}
		writer.close();
	}
	
}
