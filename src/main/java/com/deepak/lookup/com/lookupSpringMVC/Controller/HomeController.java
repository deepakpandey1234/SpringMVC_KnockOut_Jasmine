package com.deepak.lookup.com.lookupSpringMVC.Controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deepak.lookup.com.lookupSpringMVC.model.Places;
import com.deepak.lookup.com.lookupSpringMVC.util.CSVUtil;


/**
 * @author dpandey
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String getContextC() {
		ArrayList<Places> list=new ArrayList<Places>();
		HashMap<String,Places> hm=new HashMap<String,Places>(new CSVUtil().parseCsv());
		for(Places places:hm.values()){
			list.add(places);
		}
		System.out.println("coming");
		return "SimpleApp";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody List<Places> getAll() {
		ArrayList<Places> list=new ArrayList<Places>();
		HashMap<String,Places> hm=new HashMap<String,Places>(new CSVUtil().parseCsv());
		for(Places places:hm.values()){
			list.add(places);
		}
		return list;
	}
	
	@RequestMapping(value="/count",method=RequestMethod.GET)
	public @ResponseBody int countData() {
		return new HashMap<String,Places>(new CSVUtil().parseCsv()).size();
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	ArrayList<Places> search(@RequestParam(value = "id", required = false) String ID,@RequestParam(value = "name", required = true) String name) {
		HashMap<String, Places> hm = new HashMap<String, Places>(new CSVUtil().parseCsv());
		ArrayList<Places> list = new ArrayList<Places>();
		for (Places places : hm.values()) {
			if (places.getId().compareTo(ID) == 0) {
				list.add(places);
			}
			if (places.getName().compareTo(name) == 0) {
				list.add(places);
			}
		}
		return list;
	}

}
