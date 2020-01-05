package com.arya.simple;

import java.util.TreeSet;

class Emp implements Comparable<Emp> {
	private Integer id;
	private String name;

	public Emp(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Emp e) {
		return name.compareTo(e.name);
	}
}

public class EmpComparable {

	public static void main(String[] args) {

		TreeSet<Emp> ts = new TreeSet<Emp>();
		ts.add(new Emp(1, "muni"));
		ts.add(new Emp(4, "swamy"));
		ts.add(new Emp(2, "arya"));

		System.out.println("Emp sort by name:");

		for (Emp e1 : ts) {
			System.out.println(e1.getId() + "  " + e1.getName());
		}
		System.out.println("Emp sort by name:");

		ts.forEach(e1 -> System.out.println(e1.getId() + "  " + e1.getName()));

	}

}
