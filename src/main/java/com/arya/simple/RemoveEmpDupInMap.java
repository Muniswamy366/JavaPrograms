package com.arya.simple;

import java.util.HashMap;
import java.util.Map;

public class RemoveEmpDupInMap {

    public static void main(String[] a) {

        Map<Empl, String> tm = new HashMap<>();
        tm.put(new Empl(134, "Ram", 3000), "RAM");
        tm.put(new Empl(235, "John", 6000), "JOHN");
        tm.put(new Empl(134, "Ram", 3000), "RAM");

        System.out.println(tm);
       
        /*Set<Empl> keys = tm.keySet();
        for(Empl key:keys){
            System.out.println(key+" ==> "+tm.get(key));
        }
     //   System.out.println("Duplicate got eliminated!!!");
*/
    }
}

class Empl {

    private String name;
    private int salary;
    private int id;

    public Empl(int id, String n, int s) {
        this.id = id;
        this.name = n;
        this.salary = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Id: " + this.id + " Name: " + this.name + " Salary: " + this.salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        // System.out.println("In hashcode");
        return this.getId() * this.getName().hashCode() * this.getSalary();
    }

    @Override
    public boolean equals(Object obj) {
        Empl e = null;
        if (obj instanceof Empl) {
            e = (Empl) obj;
        }
        // System.out.println("In equals");
        return this.getId() == e.getId() && this.getName().equals(e.getName()) && this.getSalary() == e.getSalary();

    }

}