package uiAuto;

import java.util.*;

public class QuickRun {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * implements List Interface
		 * Java ArrayList class can contain duplicate elements.
		 * Java ArrayList class maintains insertion order.
		 * Java ArrayList class is non synchronized.
		 * Java ArrayList class is non synchronized. - Array list can be modfied by another thread at the same time resulting in dirty read/writes
		 * Slow
		 */
		List<String> lstName=new ArrayList<String>();
		lstName.add("001_TC");
		lstName.add("002_TC");
		lstName.add("003_TC");
		lstName.add("004_TC");
		lstName.add("005_TC");
		lstName.add("006_TC");
		lstName.add("007_TC");
		lstName.add("008_TC");
		lstName.add("009_TC");
		lstName.add("010_TC");
		lstName.add("011_TC");
		lstName.add("012_TC");
		lstName.add("01001_TC");
		
		for(String str: lstName)
		{
			System.out.println(str.toString());
		}
		
		/*
		 * Same as LIST, only difference is : In Java LinkedList class, manipulation is fast because no shifting needs to be occurred.
		 */
		List<String> lstLinked=new LinkedList<String>();
		lstName.add("001_TC");
		lstName.add("002_TC");
		lstName.add("003_TC");
		lstName.add("004_TC");
		lstName.add("005_TC");
		lstName.add("006_TC");
		lstName.add("007_TC");
		lstName.add("008_TC");
		lstName.add("009_TC");
		lstName.add("010_TC");
		lstName.add("011_TC");
		lstName.add("012_TC");
		lstName.add("01001_TC");
		for(String str: lstLinked)
		{
			System.out.println(str.toString());
		}
		
		//https://www.javatpoint.com/java-priorityqueue - Implements Que Intervace - FIFO
		
		
		/*https://www.javatpoint.com/java-hashset - Implements SET interface
		 * HashSet contains unique elements only.
		 * Difference between List and Set
		 * List can contain duplicate elements whereas Set contains unique elements only.
		 */
		
		
		/*
		 *  Map Interface
		 * 		Hashmap class  -- Key value Pair
		 *  		It contains only unique elements.
		 *			It may have one null key and multiple null values.
		 *			It maintains no order.	
		 * 		If you want insertion order use LinkedHashMap 
		 */
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		for (String key : map.keySet()) {
		    System.out.println("Key = " + key);
		    System.out.println("value = " + map.get(key));
		}
		
//		for (String value : map.values()) {
//		    System.out.println("Values = " + value);
//		}
//		  
		  
		
		
	}
}
