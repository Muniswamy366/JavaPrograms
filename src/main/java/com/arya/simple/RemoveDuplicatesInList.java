package com.arya.simple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class RemoveDuplicatesInList {

    public static void main(String[] args) {
        List<String> li = new ArrayList<String>();

        li.add("one");
        li.add("two");
        li.add("three");
        li.add("one");//Duplicate
        li.add("one");//Duplicate

        // We have facility to pass a List into Set constructor and vice verse to cast

        List<String> li2 = new ArrayList<String>(new HashSet<String>(li)); //no order

        // List li2 = new ArrayList(new LinkedHashSet(li)); //If you need to preserve the order use 'LinkedHashSet'

        Iterator<String> it = li2.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
