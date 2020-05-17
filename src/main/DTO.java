package main;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
/**
 * DTO class to create Station object and object ArrayList
 * @author Xizhen Yang
 *
 */
public class DTO {
	/**
	 * Function to create an ArrayList of stations 
	 * Call readExcel() of FileIO class to create an ArrayList of Station objects with name and count
	 * Call getCoord() of Coordinate class to get longitude, latitude info for Station objects
	 * @throws IOException
	 * @throws JSONException
	 */
	public static List<Station> createStationList() throws IOException, JSONException {
		List<Station> stationList = FileIO.readExcel();
		
		for (Station s : stationList) {
			String coord = Coordinate.getCoord(s.getName());
			if (!coord.isEmpty()) { // Check for empty result
				s.setLng(coord.split(",")[0]);
				s.setLat(coord.split(",")[1]);
			}
			
			System.out.println(stationList.indexOf(s) + 1);
			System.out.println(s.toString());
		}
		
		return stationList;
	}
	
	public static Station createStationObject(String name, int count) {
		return new Station(name, count);
	}
	
}
