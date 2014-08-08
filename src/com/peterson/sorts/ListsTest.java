package com.peterson.sorts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Peterson, Ryan
 *         Created 8/8/2014
 */
public class ListsTest
{
    public static void main(String[] args) throws InterruptedException
    {
        for (int it = 0; it < 10; it++)
        {
            final List<Integer> listOne = new ArrayList<>();
            final List<Integer> listTwo = new LinkedList<>();
            Test.randomList(listOne, 1000000);
            for (Integer i : listOne)
                listTwo.add(i);

            Runnable one = new Runnable()
            {
                @Override
                public void run()
                {
                    QuickSort.sort(listOne, ComparatorUtils.integerComparator());
                    System.out.println("One is done");
                }
            };

            Runnable two = new Runnable()
            {
                @Override
                public void run()
                {
                    QuickSort.sort(listTwo, ComparatorUtils.integerComparator());
                    System.out.println("Two done");
                    if (listTwo instanceof ArrayList)
                        throw new RuntimeException("Shit");
                }
            };

            Thread t1 = new Thread(one);
            Thread t2 = new Thread(two);

            t2.start();
            t1.start();
            t2.join();
            t1.join();
        }
    }
}
