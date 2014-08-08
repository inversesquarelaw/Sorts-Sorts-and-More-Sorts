package com.peterson.sorts;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Sorts a list using Comb Sort.
 * Comb sort is an improvement of Bubble Sort.
 * It is unclear that this is a O(n^2) sort,
 * so it can be assumed that it is.
 *
 * @author Peterson, Ryan
 *         Created 8/7/2014
 */
public class CombSort
{
    /**
     * Sorts the List using Comb Sort.
     * Just like other sorts in this package, an extra
     * 2*O(n) is used to switch between LinkedList and Array list
     * to maintain efficiency.
     *
     * @param list the list to be sorted
     * @param comp comparison rule to sort the list by
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
            int gap = list.size();
            final double shrink = 1.3;

            boolean swapped = true;

            while (true)
            {
                if (gap == 1 && !swapped)
                    break;

                double nGap = (double) gap / shrink;

                gap = (int) nGap;

                if (gap < 1)
                    gap = 1;

                int i = 0;
                swapped = false;
                while (i + gap < list.size())
                {
                    if (comp.compare(list.get(i), list.get(i + gap)) > 0)
                    {
                        Collections.swap(list, i, i + gap);
                        swapped = true;
                    }

                    i++;
                }
            }
        }
    }
}
