package com.cmpe282.rest.dao;

import java.util.ArrayList;
import java.util.HashMap;
public class Config {
	/*public static HashMap<String, Integer> hm = null;
    //add key-value pair to hashmap

	public HashMap<String, Integer> getHm() {
		return hm;
	}*/

	public static HashMap<String, Integer> getHm() {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("Alameda", 1);
		hm.put("Alpine", 3);
		hm.put("Amador", 5);
		hm.put("Butte", 7);
		hm.put("Calaveras", 9);
		hm.put("Colusa", 11);
		hm.put("Contra Costa", 13);
		hm.put("Del Norte", 15);
		hm.put("El Dorado", 17);
		hm.put("Fresno", 19);
		hm.put("Glenn", 21);
		hm.put("Humboldt", 23);
		hm.put("Imperial", 25);
		hm.put("Inyo", 27);
		hm.put("Kern", 29);
		hm.put("Kings", 31);
		hm.put("Lake", 33);
		hm.put("Lassen", 35);
		hm.put("Los Angeles", 37);
		hm.put("Madera", 39);
		hm.put("Marin", 41);
		hm.put("Mariposa", 43);
		hm.put("Mendocino", 45);
		hm.put("Merced", 47);
		hm.put("Modoc", 49);
		hm.put("Mono", 51);
		hm.put("Monterey", 53);
		hm.put("Napa", 55);
		hm.put("Nevada", 57);
		hm.put("Orange", 59);
		hm.put("Placer", 61);
		hm.put("Plumas", 63);
		hm.put("Riverside", 65);
		hm.put("Sacramento", 67);
		hm.put("San Benito", 69);
		hm.put("San Bernardino", 71);
		hm.put("San Diego", 73);
		hm.put("San Francisco", 75);
		hm.put("San Joaquin", 77);
		hm.put("San Luis Obispo", 79);
		hm.put("San Mateo", 81);
		hm.put("Santa Barbara", 83);
		hm.put("Santa Clara", 85);
		hm.put("Santa Cruz", 87);
		hm.put("Shasta", 89);
		hm.put("Sierra", 91);
		hm.put("Siskiyou", 93);
		hm.put("Solano", 95);
		hm.put("Sonoma", 97);
		hm.put("Stanislaus", 99);
		hm.put("Sutter", 101);
		hm.put("Tehama", 103);
		hm.put("Trinity", 105);
		hm.put("Tulare", 107);
		hm.put("Tuolumne", 109);
		hm.put("Ventura", 111);
		hm.put("Yolo", 113);
		hm.put("Yuba", 115);
	
		return hm;
	}
	
	public static ArrayList<String> getListOfQuotes() {
		ArrayList<String> al = new ArrayList<String>();
		al.add(0, "Lessen the risk of osteoporosis (weak bones that are more likely to break)");
		al.add(1, "Get regular, light-to-moderate intensity exercise.");
		al.add(3, "Use relaxation and visualization techniques to reduce stress.");
		al.add(4, "Lower the risk of being anxious and depressed");
		al.add(5, "Improve blood flow to your legs and lower the risk of blood clots");
		al.add(6, "Keep muscles from wasting due to inactivity");
		al.add(7, "Help you control your weight");
		al.add(8, "Set up a daily routine that lets you be active when you feel your best.");
		al.add(9, "Balance activity with rest that does not interfere with nighttime sleep.");
		al.add(10, "Keep muscles from wasting due to inactivity.");
		al.add(11, "Make you less dependent on others for help with normal activities of daily living.");
		al.add(12, "Improve your self-esteem.");
		al.add(13, "Lessen nausea.");
		al.add(14, "Get fresh air.");
		al.add(15, "Improve your quality of life.");
		
		
		return al;
		
	}
    
}


