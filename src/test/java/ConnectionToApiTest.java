
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.mockito.Mockito;

import Repository.ConnectionToApi;

public class ConnectionToApiTest {
	private String url = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn&APPID=33d24dbe4f8dc4fabc901492abb1e123&units=metric";
	
	@Test
	public void testIfConnectionToWeatherApiExists() {
		try {
			ConnectionToApi connection = new ConnectionToApi();
			assertNotNull(connection.connectHttpURL(url));
		} catch (Exception e) {
			System.out.println("Exception occurred" + e.getMessage() );
		}
	}
	
    @Test
    public void  testIfConnectionToWeatherApiMockExists() throws IOException, JSONException {
	    	ConnectionToApi connectionMock = mock(ConnectionToApi.class);
	    	String jsonString = "{\"city\":{\"country\":\"EE\"}}";
	    	JSONObject jsonMock = new JSONObject(jsonString);

	    when(connectionMock.connectHttpURL(url)).thenReturn(jsonMock);
	    assertEquals(connectionMock.connectHttpURL(url), jsonMock);
    }
}
