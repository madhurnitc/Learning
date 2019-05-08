package org.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {


    List<Integer> flattendList = new ArrayList<>();

    int position;
    public NestedIterator(List<NestedInteger> nestedList) {

        position = 0;
        addToFlattenedList(nestedList);
    }

    @Override
    public Integer next() {

        if(hasNext()) {
            Integer i= flattendList.get(position);
            position++;
            return i;
        }

        return null;
    }

    @Override
    public boolean hasNext() {
        if(position >= flattendList.size()) {
            return false;
        }

        return true;

    }

    public void addToFlattenedList(List<NestedInteger> nestedList) {

        for(NestedInteger ni : nestedList) {

            if(ni.isInteger()) {
                flattendList.add(ni.getInteger());
            }else {
                addToFlattenedList(ni.getList());
            }
        }
    }
}