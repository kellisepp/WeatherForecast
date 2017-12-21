import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;

import org.json.JSONException;
import org.junit.Test;
import Repository.Input;

public class FileControllersTest {
	 
	 @Test
		public void testInputAskerFromConsole() {
			Input input = new Input();
			assertEquals(input.getCityFromConsole().size(), 1);
		}
		
		@Test
		public void testInputAskerFromFile() throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {
			Input input = new Input();
			assertTrue(input.getCityFromFile().size()>0);
		}
		
}
