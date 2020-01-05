package com.arya.ds;

public class MyHashSet<E> {

    // Dummy value to associate with an Object in the backing Map
    private static final Object PRESENT = new Object();
    private transient java.util.HashMap<E, Object> map;

    public MyHashSet() {
        map = new java.util.HashMap<>();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
        //hashMap.put("1", "one");//null
        //hashMap.put("1", "two");//one
        //hashMap.put("3", "three");//null
        //hashMap.get("1");//two
    }

    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    public void clear() {
        map.clear();
    }

}
