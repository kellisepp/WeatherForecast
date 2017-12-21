package Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionToApi {

  private static String readAll(Reader reader) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    int cp;
    while ((cp = reader.read()) != -1) {
    	stringBuilder.append((char) cp);
    }
    return stringBuilder.toString();
  }

  public JSONObject connectHttpURL(String requestUrl) throws IOException, JSONException {
    InputStream inputStream = new URL(requestUrl).openStream();
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
      String jsonText = readAll(reader);
      JSONObject json = new JSONObject(jsonText);
      System.out.println(json);
      return json;
    } finally {
    	inputStream.close();
    }
  
  }
 }

