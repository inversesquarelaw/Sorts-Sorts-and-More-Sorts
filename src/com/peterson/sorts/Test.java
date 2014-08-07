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

    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();
        randomList(list, 10);
        InsertionSort.sort(list, ComparatorUtils.integerComparator());


        System.out.println(Arrays.toString(list.toArray()));

    }
}
