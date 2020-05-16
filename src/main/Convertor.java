package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class Convertor {

	final static String key = "";
	
	private static HttpURLConnection connection;
	
	public static void main(String[] args) throws IOException, JSONException {
		String location = "顺义区首都机场公共站";
		System.out.println(Arrays.toString(getCoord(location)));
	}
	
	/**
	 * Function to get the coordinates of a location by HTTP GET request
	 * @param location
	 * @return string array of latitude and longitude
	 * @throws IOException
	 * @throws JSONException
	 */
	public static String[] getCoord(String location) throws IOException, JSONException {		
		String[] coord;
		String urll = "https://restapi.amap.com/v3/geocode/geo?";
		
		StringBuilder sb = new StringBuilder(urll);
		sb.append("key=")
			.append(key)
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
			
			// Get the value of "location" 
			String result_location = result.getJSONArray("geocodes").getJSONObject(0).getString("location");
			
			// Split the location result
			coord = result_location.split(",");
			
		} finally {
            connection.disconnect();
        }
		 
		return coord;
	}
	
}
