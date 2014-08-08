package com.peterson.sorts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Utility class that converts lists
 * to either LinkedList or ArrayList; the latter being
 * used to maintain performance of the sorts because
 * they are based on random access and not iterating to a position.
 *
 * @author Peterson, Ryan
 *         Created 8/8/2014
 */
public class SortUtil
{
    /**
     * Converts a List to an ArrayList.
     *
     * @param list the list to change to an ArrayList
     * @param <T>
     * @return an ArrayList
     */
    public static <T> ArrayList<T> toArrayList(List<T> list)
    {
        ArrayList<T> temp = new ArrayList<>(list.size());
        for (T t : list)
            temp.add(t);
        return temp;
    }

    /**
     * Converts a List to a LinkedList.
     *
     * @param list the list to convert
     * @param <T>
     * @return a LinkedList
     */
    public static <T> LinkedList<T> toLinkedList(List<T> list)
    {
        LinkedList<T> temp = new LinkedList<>();
        for (T t : list)
            temp.add(t);

        return temp;
    }
}
