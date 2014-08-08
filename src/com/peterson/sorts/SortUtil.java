package com.peterson.sorts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Peterson, Ryan
 *         Created 8/8/2014
 */
public class SortUtil
{
    public static <T> ArrayList<T> toArrayList(List<T> list)
    {
        ArrayList<T> temp = new ArrayList<>(list.size());
        for (T t : list)
            temp.add(t);
        return temp;
    }

    public static <T> LinkedList<T> toLinkedList(List<T> list)
    {
        LinkedList<T> temp = new LinkedList<>();
        for (T t : list)
            temp.add(t);

        return temp;
    }
}
