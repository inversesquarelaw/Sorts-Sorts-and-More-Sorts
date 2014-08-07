package com.peterson.sorts;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Peterson, Ryan
 *         Created 8/7/2014
 */
public class CombSort
{
    public static <T> void sort(List<T> list, Comparator<T> comp)
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
