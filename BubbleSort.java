import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {
    int swaps = 0;
    int comparisons = -1;
    
    public int[] bubbleSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        return A;
    } 

    public void bubbleWriteToFile(String fileName, int[] sortedList) {
        try {
            FileWriter outFile = new FileWriter(fileName + "_bubble.out");

            for (int n : sortedList) {
                outFile.write(n + "\n");
            }
            
            outFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}