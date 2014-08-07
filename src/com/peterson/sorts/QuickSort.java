package com.peterson.sorts;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Peterson, Ryan
 *         Created 8/7/2014
 */
public class QuickSort
{
    public static <T> void sort(List<T> list, Comparator<T> comp)
    {
        Collections.shuffle(list);
        _sort(list, comp, 0, list.size() - 1);

    }

    private static <T> void _sort(List<T> list, Comparator<T> comp, int lo, int hi)
    {
        if (lo < hi)
        {
            int partition = partition(list, comp, lo, hi);
            _sort(list, comp, lo, partition - 1);
            _sort(list, comp, partition + 1, hi);
        }
    }

    private static <T> int partition(List<T> list, Comparator<T> comp, int lo, int hi)
    {
        int i = lo;
        int j = hi + 1;
        T temp = list.get(i);

        //loop will end
        while (true)
        {
            while (comp.compare(list.get(++i), temp) < 0)
            {
                if (i == hi)
                    break;
            }
            while (comp.compare(temp, list.get(--j)) < 0)
            {
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;
            Collections.swap(list, i, j);
        }

        Collections.swap(list, lo, j);

        return j;
    }

}
