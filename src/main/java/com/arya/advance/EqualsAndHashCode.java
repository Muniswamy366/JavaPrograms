package com.arya.advance;

import java.util.HashSet;
import java.util.Set;

class Emp {

	private int id;

	private String name;


	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
	

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
*/

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (this == obj)// if == is true equals also true.
			return true;
		if (obj == null || this.getClass() != obj.getClass())// obj is null it
			// should not
			// throw NPE.
			result = false;// should not use instanceof bez we can pass subclass
			// so use getclass().
		else {
			Emp e = (Emp) obj;

			if (this.id == e.id && this.name.equals(e.name))//in database entity use this.getter methods bez lazy loading
				result = true;
		}

		return result;

	}

	@Override
	public int hashCode() {
		final int prime = 31;

		int result = 1;

		result = prime * result + this.id + name.hashCode();
		return result;
	}


}

public class EqualsAndHashCode {

	public static void main(String[] args) {

		Emp e1 = new Emp(1, "muni");
		Emp e2 = new Emp(1, "muni");
		Emp e3 = new Emp(1, "muni");

		Set<Emp> emps = new HashSet<Emp>();

		emps.add(e1);
		emps.add(e2);
		emps.add(e3);

		System.out.println(emps);

	}
}
