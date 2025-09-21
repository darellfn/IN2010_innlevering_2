public class HeapSort {

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

    public int[] bubbleDown(int[] A, int i, int n) {
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

    public int[] buildMaxHeap(int[] A, int n) {
        for (int i = A.length / 2 - 1; i >= 0; i--) {
            A = bubbleDown(A, i, A.length);
        }
        return A;
    }
}