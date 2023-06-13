package main.java.de.uulm.sp.oop.exercises.e06;

import java.util.HashMap;

public class HashMapArray<T> {
	private HashMap<Integer, T> mymap;
    public int length;

    public HashMapArray(int n){
        mymap = new HashMap<Integer, T>();
        length = n;
    }

    public void set(T item , int index){
        if(index >= length || index < 0)throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bounds for length " + length);
        mymap.put(index, item);
    }

    public T get(int index){
        if(index >= length || index < 0)throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bounds for length " + length);
        return mymap.get(index);
    }
}
