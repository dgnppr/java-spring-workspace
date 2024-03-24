package me.dgpr.chapter_5.item_31;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {

    private List<E> list = new ArrayList<>();

    public void pushAll(Iterable<E> src) {
        for (E e : src) {
            push(e);
        }
    }

    public void push(E e) {
        list.add(e);
    }
}
