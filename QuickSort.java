public class QuickSort {

    public int[] quickSort(int[] A, int low, int high) {
        if (low >= high) {
            return A;
        }

        int p = partition(A, low, high);
        quickSort(A, low, p - 1);
        quickSort(A, p + 1, high);
        return A;
    }

    public int partition(int[] A, int low, int high) {
        int p = choosePivot(A, low, high);
        int temp = A[p];
        A[p] = A[high];
        A[high] = temp;

        int pivot = A[high];
        int left = low;
        int right = high - 1;

        while (left <= right) {
            while (left <= right && A[left] <= pivot) {
                left = left + 1;
            }
            while (right >= left && A[right] >= pivot) {
                right = right - 1;
            }
            if (left < right) {
                int tempLeft1 = A[left];
                A[left] = A[right];
                A[right] = tempLeft1;
            }
        }
        int tempLeft2 = A[left];
        A[left] = A[high];
        A[high] = tempLeft2;
        return left;
    }

    public int choosePivot(int[] A, int low, int high) {
        return high;
    }
}