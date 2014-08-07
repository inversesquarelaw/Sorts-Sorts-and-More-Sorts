package com.peterson.sorts;

import java.util.*;

/**
 * @author Peterson, Ryan
 *         Created 8/7/2014
 */
public class Test
{
    public static void randomList(List<Integer> list, int size)
    {
        Random rand = new Random();
        for (int i = 0; i < size; i++)
        {
            list.add(rand.nextInt(100));
        }
    }

    public static void isSorted(List<Integer> list)
    {
        Comparator<Integer> c = ComparatorUtils.integerComparator();
        int last = 0;
        for (int i = 1; i < list.size(); i++)
        {
            if (c.compare(list.get(last), list.get(i)) > 0)
                throw new RuntimeException("List not sorted");
            last = i;
        }
    }

    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();
        randomList(list, 1000);
        InsertionSort.sort(list, ComparatorUtils.integerComparator());

        isSorted(list);
        System.out.println(Arrays.toString(list.toArray()));

    }
}
