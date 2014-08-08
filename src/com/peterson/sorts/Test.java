package com.peterson.sorts;

import java.time.Clock;
import java.util.*;

/**
 * Just a main method to
 * test the sorts.
 *
 * @author Peterson, Ryan
 *         Created 8/7/2014
 */
public class Test
{
    public static final int NUM_ELEMENTS = 10000;

    public static void randomList(List<Integer> list, int size)
    {
        Random rand = new Random();
        for (int i = 0; i < size; i++)
        {
            list.add(rand.nextInt(100));
        }
    }

    public static void isSorted(List<Integer> list)
    {
        Comparator<Integer> c = ComparatorUtils.integerComparator();
        int last = 0;
        for (int i = 1; i < list.size(); i++)
        {
            if (c.compare(list.get(last), list.get(i)) > 0)
                throw new RuntimeException("List not sorted");
            last = i;
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        for (int j = 0; j < 10; j++)
        {
            SortThread[] sThreads = new SortThread[4];
            sThreads[0] = new QuickSortThread();
            sThreads[1] = new CombSortThread();
            sThreads[2] = new SelectionSortThread();
            sThreads[3] = new InsertionSortThread();

            Thread[] threads = new Thread[sThreads.length];
            for (int i = 0; i < sThreads.length; i++)
                threads[i] = new Thread(sThreads[i]);
            for (Thread t : threads)
                t.start();
            for (Thread t : threads)
                t.join();

            System.out.println();
            System.out.println();
        }
    }

    private static abstract class SortThread implements Runnable
    {
        protected List<Integer> list;
        protected Clock timer;

        public SortThread()
        {
            list = new ArrayList<>(NUM_ELEMENTS);
            randomList(list, NUM_ELEMENTS);
            timer = Clock.systemDefaultZone();
        }
    }

    private static class QuickSortThread extends SortThread
    {
        public QuickSortThread()
        {
            super();
        }

        public void run()
        {
            long start = timer.millis();
            QuickSort.sort(list, ComparatorUtils.integerComparator());
            long stop = timer.millis();
            System.out.println("Quick sort done!");
            double deltaTime = ((double) (stop - start)) / 1000.0;
            System.out.println("Quick Sort time: " + deltaTime);
        }
    }

    private static class CombSortThread extends SortThread
    {

        public CombSortThread()
        {
            super();
        }

        @Override
        public void run()
        {
            long start = timer.millis();
            CombSort.sort(list, ComparatorUtils.integerComparator());
            long stop = timer.millis();
            System.out.println("Comb sort done!");
            double deltaTime = ((double) (stop - start)) / 1000.0;
            System.out.println("Comb Sort time: " + deltaTime);
        }
    }

    private static class InsertionSortThread extends SortThread
    {

        public InsertionSortThread()
        {
            super();
        }

        @Override
        public void run()
        {
            long start = timer.millis();
            InsertionSort.sort(list, ComparatorUtils.integerComparator());
            long stop = timer.millis();
            System.out.println("InsertionSort sort done!");
            double deltaTime = ((double) (stop - start)) / 1000.0;
            System.out.println("InsertionSort time: " + deltaTime);
        }
    }

    private static class SelectionSortThread extends SortThread
    {
        public SelectionSortThread()
        {
            super();
        }

        @Override
        public void run()
        {
            long start = timer.millis();
            SelectionSort.sort(list, ComparatorUtils.integerComparator());
            long stop = timer.millis();
            System.out.println("Selection sort done!");
            double deltaTime = ((double) (stop - start)) / 1000.0;
            System.out.println("Selection Sort time: " + deltaTime);
        }
    }
}
