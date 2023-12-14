package com.boostmedia;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ArrayList<String> arrayList = new ArrayList<>();
        Consumer<String> cout = t-> System.out.println(t);
        arrayList.add("a");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("b");
        arrayList.add("c");
        Iterable<String> i = arrayList;
        i.forEach(cout);

        Collection<String> c = arrayList;
        c.stream().map(a-> a.toLowerCase()).forEach(cout);


        List<String> list = arrayList;
        int a = list.lastIndexOf("A");
        AbstractList<String> al = arrayList;

    }
}
