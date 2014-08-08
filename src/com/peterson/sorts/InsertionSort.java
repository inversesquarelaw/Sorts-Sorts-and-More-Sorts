package com.peterson.sorts;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Performs Insertion Sort on a List.
 * This is a O(n^2) sort, and should only
 * be used on small lists.
 *
 * @author Peterson, Ryan
 *         Created 8/7/2014
 */
public class InsertionSort
{
    /**
     * Sorts the List using Insertion Sort.
     * If the list is a LinkedList, an extra 2*O(n) is
     * used to maintain random access.
     *
     * @param list the list to sort
     * @param comp the comparator to compare elements with
     * @param <T>
     */
    public static <T> void sort(List<T> list, Comparator<T> comp)
    {
        if (list instanceof LinkedList)
        {
            list = SortUtil.toArrayList(list);
            sort(list, comp);
            list = SortUtil.toLinkedList(list);
        }
        else
        {
            for (int i = 0; i < list.size(); i++)
            {
                T temp = list.get(i);
                int j = i;

                while (j > 0 && (comp.compare(temp, list.get(j - 1))) < 1)
                {
                    list.set(j, list.get(j - 1));
                    j--;
                }

                list.set(j, temp);
            }
        }
    }
}
