package com.peterson.sorts;

import java.util.Comparator;
import java.util.List;

/**
 * @author Peterson, Ryan
 *         Created 8/7/2014
 */
public class InsertionSort
{
    public static <T> void sort(List<T> list, Comparator<T> comp)
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
