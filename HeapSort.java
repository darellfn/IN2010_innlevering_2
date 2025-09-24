import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HeapSort {
    int swaps = 0;
    int comparisons = -1;

    public int[] heapSort(int[] A) {
        buildMaxHeap(A, A.length);
        for (int i = A.length - 1; i > 0; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            bubbleDown(A, 0, i);
        }
        return A;
    }

    private int[] bubbleDown(int[] A, int i, int n) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && A[largest] < A[left]) {
            largest = left;
        }
        if (right < n && A[largest] < A[right]) {
            largest = right;
        }
        if (i != largest) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            bubbleDown(A, largest, n);
        }
        return A;
    }

    private int[] buildMaxHeap(int[] A, int n) {
        for (int i = A.length / 2 - 1; i >= 0; i--) {
            A = bubbleDown(A, i, A.length);
        }
        return A;
    }

    public void heapWriteToFile(String fileName, int[] sortedList) {
        try {
            FileWriter outFile = new FileWriter(fileName + "_heap.out");

            for (int n : sortedList) {
                outFile.write(n + "\n");
            }
            
            outFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}