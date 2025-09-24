import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InsertionSort {
    int swaps = 0;
    int comparisons = -1;

    public int[] insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int j = i;
            
            comparisons += 1;
            while (j > 0 && A[j - 1] > A[j]) {
                comparisons += 1;
                int temp = A[j-1];
                A[j-1] = A[j];
                A[j] = temp;
                swaps += 1;
                j = j - 1;
            }
        }
        return A;
    }

    public void insertionWriteToFile(String fileName, int[] sortedList) {
        try {
            FileWriter outFile = new FileWriter(fileName + "_insertion.out");

            for (int n : sortedList) {
                outFile.write(n + "\n");
            }
            
            outFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}