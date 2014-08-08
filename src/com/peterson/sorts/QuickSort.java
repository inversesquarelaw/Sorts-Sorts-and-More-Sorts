package com.peterson.sorts;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * A Standard Quick Sort.
 * This is an in place sort, which is ideal
 * for large lists, and runs in O(n log n) and uses
 * about O(log n) extra space for recursion. Two sort
 * methods are given. The first guarantees that ANY list
 * will be sorted in O(n log n) time by ensuring the list is randomly
 * shuffled, which tacks on an O(n). The second method assumes the list is
 * no sorted and wont take the extra O(n) to shuffle.
 * Like other sort methods in this package, an extra 2*O(n) is used
 * for LinkedLists to maintain efficiency of the sort.
 * @author Peterson, Ryan
 *         Created 8/7/2014
 */
public class QuickSort
{
    /**
     * Sorts the list using Quick Sort.
     * This method ensures that the worst case of
     * quick sort, O(n^2), never happens because the list is shuffled before
     * sorted.
     *
     * @param list the list to sort
     * @param comp the comparison rule
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
            Collections.shuffle(list);
            _sort(list, comp, 0, list.size() - 1);
        }
    }

    /**
     * Sorts the list using Quick Sort.
     * The assumption by using this method is that the
     * list isn't already partially sorted.
     *
     * @param list the list to sort
     * @param comp the comparison rule
     * @param <T>
     */
    public static <T> void randomizedListSort(List<T> list, Comparator<T> comp)
    {
        if (list instanceof LinkedList)
        {
            list = SortUtil.toArrayList(list);
            sort(list, comp);
            list = SortUtil.toLinkedList(list);
        }
        else
        {
            _sort(list, comp, 0, list.size() - 1);
        }
    }

    /*
        Recursive caller of sort.
        the list is partitioned into pieces, which then are sorted
     */
    private static <T> void _sort(List<T> list, Comparator<T> comp, int lo, int hi)
    {
        if (lo < hi)
        {
            int partition = partition(list, comp, lo, hi);
            _sort(list, comp, lo, partition - 1);
            _sort(list, comp, partition + 1, hi);
        }
    }

    /*
        Partitions the list.
        Movies pointers i and j to the proper position
        so that everything to the left of i is less than what is at i
        and that everything to the right of j is greater than j.
        Positions i and j are swapped, then the lowest index and j are swapped,
        and j is returned, which is the new partition.
     */
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
