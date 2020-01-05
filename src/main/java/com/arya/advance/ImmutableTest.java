package com.arya.advance;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

/*
Immutable objects are automatically thread-safe.
https://java2blog.com/immutable-class-interview-questions/
 */
public final class ImmutableTest {

	private final int id;
	private final String name;
	private final HashMap<String, String> testMap;
	private final Calendar calendar;

	public ImmutableTest(int i, String n, HashMap<String, String> hm, Calendar calendar) {
		System.out.println("Performing Deep Copy for Object initialization");
		this.id = i;
		this.name = n;
		HashMap<String, String> tempMap = new HashMap<String, String>();
		String key;
		Iterator<String> it = hm.keySet().iterator();
		while (it.hasNext()) {
			key = it.next();
			tempMap.put(key, hm.get(key));
		}
		this.testMap = tempMap;
		this.calendar = (Calendar) calendar.clone();
	}

	public static void main(String[] args) {

		int i = 10;
		String s = "original";
		HashMap<String, String> h1 = new HashMap<String, String>();
		h1.put("1", "first");
		h1.put("2", "second");
		Calendar calendar = new GregorianCalendar(2014, Calendar.FEBRUARY, 11);

		ImmutableTest immutable = new ImmutableTest(i, s, h1, calendar);

		// Lets see whether its copy by field or reference
		System.out.println(s == immutable.getName());
		System.out.println(h1 == immutable.getTestMap());
		System.out.println(calendar == immutable.getCalendar());
		// print the ce values
		System.out.println("############ Original Values ############");
		System.out.println("Id: " + immutable.getId());
		System.out.println("Name: " + immutable.getName());
		System.out.println("Map: " + immutable.getTestMap());
		System.out.println("Date: " + immutable.getCalendar().getTime());
		// change the local variable values
		i = 20;
		s = "modified";
		h1.put("3", "third");
		calendar.setTime(new GregorianCalendar(2016, Calendar.FEBRUARY, 11).getTime());

		System.out.println("############ After First Modify ############");
		System.out.println("Id: " + immutable.getId());
		System.out.println("Name: " + immutable.getName());
		System.out.println("Map: " + immutable.getTestMap());
		System.out.println("Date: " + immutable.getCalendar().getTime());

		System.out.println("############ After Second Modify ############");

		HashMap<String, String> hmTest = immutable.getTestMap();
		hmTest.put("4", "new");
		immutable.getCalendar().setTime(new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime());

		System.out.println("Map: " + immutable.getTestMap());
		System.out.println("Date: " + immutable.getCalendar().getTime());

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public HashMap<String, String> getTestMap() {
		//return testMap;
		return (HashMap<String, String>) testMap.clone();
	}
	
	/*public ImmutableTest(int i, String n, HashMap<String, String> hm, Calendar calendar) {
		System.out.println("Performing Shallow Copy for Object initialization");
		this.id = i;
		this.name = n;
		this.testMap = hm;
		this.calendar = calendar;
	}*/

	public Calendar getCalendar() {
		//return calendar;
		return (Calendar) calendar.clone();
	}

}
