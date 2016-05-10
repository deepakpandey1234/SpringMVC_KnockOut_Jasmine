package com.deepak.lookup.com.lookupSpringMVC.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.deepak.lookup.com.lookupSpringMVC.model.Places;


public class CSVUtil {

  public static void main(String[] args) {
	CSVUtil csvutil=new CSVUtil();
	csvutil.parseCsv();

  }

  public HashMap<String, Places> parseCsv() {
	InputStream csvFile = this.getClass().getResourceAsStream("/places.csv");
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	String[] data={};
	HashMap<String, Places> hashmap=new HashMap<String, Places>();

	try {

		br = new BufferedReader(new InputStreamReader(csvFile));
		while ((line = br.readLine()) != null) {

		    // use comma as separator
			data = line.split(cvsSplitBy);
			Places userData=new Places();
			userData.setId(data[0].replace("\"", ""));
			userData.setName(data[1].replace("\"", ""));
			userData.setCategory(data[2].replace("\"", ""));
			userData.setRating(data[3].replace("\"", ""));
			userData.setLatitude(data[4].replace("\"", ""));
			userData.setLongitude(data[5].replace("\"", ""));
			
			hashmap.put(data[0].replace("\"", ""), userData);

			System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[3]+" "+data[4]+" "+data[5]);
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	  return hashmap;
  }

}