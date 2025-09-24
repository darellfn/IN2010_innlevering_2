import java.io.FileWriter;
import java.io.IOException;

public class QuickSort {
    long swaps = 0;
    long comparisons = -1;
    
    public int[] quickSort(int[] A, int low, int high) {
        if (low >= high) {
            return A;
        }
        int p = partition(A, low, high);
        quickSort(A, low, p - 1);
        quickSort(A, p + 1, high);
        return A;
    }

    private int partition(int[] A, int low, int high) {
        int p = choosePivot(A, low, high);
        int temp = A[p];
        A[p] = A[high];
        A[high] = temp;

        int pivot = A[high];
        int left = low;
        int right = high - 1;

        while (left <= right) {
            comparisons += 1;
            while (left <= right && A[left] <= pivot) {
                left = left + 1;
                comparisons += 1;
            }
            comparisons += 1;
            while (right >= left && A[right] >= pivot) {
                right = right - 1;
                comparisons += 1;
            }
            if (left < right) {
                int innerTempLeft = A[left];
                A[left] = A[right];
                A[right] = innerTempLeft;
                swaps += 1;
            }
        }
        int tempLeft = A[left];
        A[left] = A[high];
        A[high] = tempLeft;
        swaps += 1;
        return left;
    }

    private int choosePivot(int[] A, int low, int high) {
        int mid = (low + high) / 2;
        if (A[low] <= A[mid] && A[mid] <= A[high] || A[low] >= A[mid] && A[mid] >= A[high] ) {
            return mid;
        } else if (A[low] >= A[mid] && A[low] <= A[high] || A[low] <= A[mid] && A[low] >= A[high]) {
            return low;
        } else {
            return high;
        }
    }

    public void quickWriteToFile(String fileName, int[] sortedList) {
        try {
            FileWriter outFile = new FileWriter(fileName + "_quick.out");

            for (int n : sortedList) {
                outFile.write(n + "\n");
            }
            
            outFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getSwaps() {
        return swaps;
    }

    public long getComparisons() {
        if (comparisons == -1) {
            return 0;
        }
        return comparisons;
    }
}