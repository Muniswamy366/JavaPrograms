package com.arya.advance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Emp1 {

	private int id;

	private String name;

	public Emp1(int id, String name) {
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
		return "Emp1 [id=" + id + ", name=" + name + "]";
	}

}

class EmpIdComparator implements Comparator<Emp1> {
	int flag;


	public EmpIdComparator(int flag) {
		super();
		this.flag = flag;
	}

	@Override
	public int compare(Emp1 o1, Emp1 o2) {

		if (o1.getId() > o2.getId())
			return 1 * flag;
		else if (o1.getId() < o2.getId())
			return -1 * flag;
		else
			return 0;
	}
}

class EmpNameComparator implements Comparator<Emp1> {
	int flag;


	public EmpNameComparator(int flag) {
		super();
		this.flag = flag;
	}

	@Override
	public int compare(Emp1 o1, Emp1 o2) {

		return flag * o1.getName().compareTo(o2.getName());
	}
}

public class EmpSortingByNameId {

	public static void main(String[] args) {

		List<Emp1> list = new ArrayList<Emp1>();

		list.add(new Emp1(2, "muni"));
		list.add(new Emp1(3, "arya"));
		list.add(new Emp1(1, "swamy"));

		//Collections.sort(list,new EmpIdComparator(1));//assending
		//Collections.sort(list,new EmpIdComparator(-1));//dessending

		//Collections.sort(list,new EmpNameComparator(1));//assending
		//Collections.sort(list,new EmpNameComparator(-1));//dessending

		System.out.println(list);

	}
}
