package com.peterson.sorts;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Peterson, Ryan
 *         Created 8/7/2014
 */
public class SelectionSort
{
    public static <T> void sort(List<T> list, Comparator<T> comp)
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
