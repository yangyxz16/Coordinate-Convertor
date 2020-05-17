package main;
/**
 * Class for Station object which has station name, longitude, latitude, count info
 * @author Xizhen Yang
 *
 */
public class Station {
	private String name;
	private String lng;
	private String lat;
	private int value;
	public Station(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Station [name=" + name + ", lng=" + lng + ", lat=" + lat + ", value=" + value + "]";
	}
}
