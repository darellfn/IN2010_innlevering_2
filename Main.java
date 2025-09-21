import java.util.*;

public class Main {
    public static void main(String[] args) { 
        int[] liste = {3, 1, 2, 7, 9, 6};

        InsertionSort is = new InsertionSort();
        QuickSort qs = new QuickSort();
        BubbleSort bs = new BubbleSort();
        HeapSort hs = new HeapSort();

        int[] sortedListIs = is.insertionSort(liste);
        int[] sortedListQs = qs.quickSort(liste, 0, liste.length - 1);
        int[] sortedListBs = bs.bubbleSort(liste);
        int[] sortedListHs = hs.heapSort(liste);

        System.out.println("Insertion sort: " + Arrays.toString(sortedListIs));
        System.out.println("Quick sort: " + Arrays.toString(sortedListQs));
        System.out.println("Bubble sort: " + Arrays.toString(sortedListBs));
        System.out.println("Heap sort: " + Arrays.toString(sortedListHs));
    }
}