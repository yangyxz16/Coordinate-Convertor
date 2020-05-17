package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Read from a xlsx file and write to a JSON file
 * @author Xizhen Yang
 *
 */
public class FileIO {
	
	/**
	 * Reads excel file, convert information to Station ArrayList
	 * Reference: https://www.java67.com/2014/09/how-to-read-write-xlsx-file-in-java-apache-poi-example.html#ixzz6MZ8qGHlK
	 */
	public static List<Station> readExcel() {
		List<Station> stationList = new ArrayList<>();
		
		try {
			File excelFile = new File(Keys.excelFileLocation);
			FileInputStream fis = new FileInputStream(excelFile);
			
			// Finds the workbook instance for XLSX file 
			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
				
			// Get first sheet
			XSSFSheet sheet = myWorkBook.getSheetAt(0);
			
			// Iterate on rows
			Iterator<Row> rowIt = sheet.iterator();
			
			// Create Row object, skip the first row (header)
			Row row = rowIt.next();
			
			while(rowIt.hasNext()) {
				row = rowIt.next();
				
				String c1 = row.getCell(0).toString();
				int c2 = (int) Double.parseDouble(row.getCell(1).toString());
				
				stationList.add(DTO.createStationObject(c1,c2));
			}
			myWorkBook.close();
			fis.close();
		} catch (FileNotFoundException e) {
	        System.out.println(e);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		return stationList;
	}

	public static void writeJSON(List<Station> stationList) {
		JSONArray JS = new JSONArray(); 
		
		for (Station station : stationList) {
			JSONObject stationOBJ = new JSONObject();
			try {
				stationOBJ.put("type", 1);
				stationOBJ.put("name", station.getName());
				stationOBJ.put("lng", station.getLng());
				stationOBJ.put("lat", station.getLat());
				stationOBJ.put("value", station.getValue());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			JS.put(stationOBJ);
		}
		
		try (FileWriter file = new FileWriter(Keys.JSONFileLocation)){
			file.write(JS.toString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}
