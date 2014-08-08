package com.peterson.sorts;

import java.util.Comparator;

/**
 * Utility methods that
 * return comparators.
 * @author Peterson, Ryan
 *         Created 8/7/2014
 */
public class ComparatorUtils
{
    public static Comparator<Integer> integerComparator()
    {
        return new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o1.compareTo(o2);
            }
        };
    }

    public static Comparator<Long> longComparator()
    {
        return new Comparator<Long>()
        {
            @Override
            public int compare(Long o1, Long o2)
            {
                return o1.compareTo(o2);
            }
        };
    }

    public static Comparator<Double> doubleComparator()
    {
        return new Comparator<Double>()
        {
            @Override
            public int compare(Double o1, Double o2)
            {
                return o1.compareTo(o2);
            }
        };
    }

    public static Comparator<Float> floatComparator()
    {
        return new Comparator<Float>()
        {
            @Override
            public int compare(Float o1, Float o2)
            {
                return o1.compareTo(o2);
            }
        };
    }

    public static Comparator<String> lexoStringComparator()
    {
        return new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }
        };
    }

}
