package com.template.schema;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyIterable<T> implements Iterable {

    private List list;

    public MyIterable(T... t) {

        list = Arrays.asList(t);
        //Collections.reverse(list);
    }

    @Override
    public Iterator iterator() {

        return list.iterator();
    }
}