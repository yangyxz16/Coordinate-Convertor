package main;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
/**
 * Main class
 * @author Xizhen Yang
 * 
 */
public class Convertor {	
	public static void main(String[] args) throws IOException, JSONException {
		List<Station> stations = DTO.createStationList();		
		FileIO.writeJSON(stations);
	}
	
	
	
	
	
}
