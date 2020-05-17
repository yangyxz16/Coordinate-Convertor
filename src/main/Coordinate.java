package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class to convert address into geographic coordinates by HTTP GET request through amap API service  
 * @author Xizhen Yang
 *
 */
public class Coordinate {
	private static HttpURLConnection connection;
		
	/**
	 * Function to get the coordinates of a location by HTTP GET request
	 * @param location
	 * @return string array of latitude and longitude
	 * @throws IOException
	 * @throws JSONException
	 */
	public static String getCoord(String location) throws IOException, JSONException {		
		String result_location = "";
		String urll = "https://restapi.amap.com/v3/geocode/geo?";
		
		StringBuilder sb = new StringBuilder(urll);
		sb.append("key=")
			.append(Keys.key)
			.append("&address=")
			.append(location);
		
		try {
			URL url = new URL(sb.toString());
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			StringBuilder content;
			
			try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

	            String line;
	            content = new StringBuilder();

	            while ((line = in.readLine()) != null) {
	                content.append(line);
	                content.append(System.lineSeparator());
	            }
	        }
			
			// Convert to JSON object
			JSONObject result = new JSONObject(content.toString());
			
			if (!result.getJSONArray("geocodes").isNull(0)) { // Check for empty result
				// Get the value of "location" 
				result_location = result.getJSONArray("geocodes").getJSONObject(0).getString("location");
			} 
		} finally {
            connection.disconnect();
        }
		 
		return result_location;
	}
	
}
