package com.peterson.sorts;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Selection Sort Utility Class.
 * Sorts the list using selection sort,
 * which runs in O(n^2) on a list that
 * is not close to being sorted, but can
 * run in linear time with a list that is almost sorted.
 * Do not use with a large data set if the list isn't near sorted!
 *
 * @author Peterson, Ryan
 *         Created 8/7/2014
 */
public class SelectionSort
{
    /**
     * Runs the Sort.
     * Takes in a List and sorts it via selection sort,
     * using the Comparator for ordering.
     * This will guarantee that the code will run in the
     * expected O(n^2) average case, but will add 2*O(n)
     * if a LinkedList is used
     *
     * @param list the list to sort
     * @param comp the way to compare the elements
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
            int min;

            for (int i = 0; i < list.size() - 1; i++)
            {
                min = i;

                for (int j = i; j < list.size(); j++)
                {
                    if (comp.compare(list.get(j), list.get(min)) < 0)
                    {
                        min = j;
                    }
                }

                if (min != i)
                {
                    Collections.swap(list, i, min);
                }
            }
        }
    }
}
