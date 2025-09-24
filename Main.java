import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        QuickSort quickSort = new QuickSort();
        BubbleSort bubbleSort = new BubbleSort();
        HeapSort heapSort = new HeapSort();
    
        System.out.println("\nSubmit file name with extension (e.g., input.txt): \n");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        File file = new File(fileName);
        Boolean fileExist = false;

        while (!fileExist) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            
            try (Scanner fileScanner = new Scanner(file);) {
                fileExist = true;

                while (fileScanner.hasNextLine()) {
                    String input = fileScanner.nextLine();
                    arrayList.add(Integer.parseInt(input));
                }

                String[] fileNameSplit = fileName.split("\\.");
                String outFileName = fileNameSplit[0];
                
                int[] array = new int[arrayList.size()];
                int counter = 0;
                
                for (int n : arrayList) {
                    array[counter] = n;
                    counter++;
                }

                //Insertion Sort
                long t1 = System.nanoTime();
                int[] sortedInsertion = insertionSort.insertionSort(array);
                long time1 = (System.nanoTime() - t1) / 1000;

                insertionSort.insertionWriteToFile(outFileName, sortedInsertion);

                //Quick Sort
                long t2 = System.nanoTime();
                int[] sortedQuick = quickSort.quickSort(array, 0, array.length - 1);
                long time2 = (System.nanoTime() - t2) / 1000;

                quickSort.quickWriteToFile(outFileName, sortedQuick);

                //Bubble Sort
                long t3 = System.nanoTime();
                int[] sortedBubble = bubbleSort.bubbleSort(array);
                long time3 = (System.nanoTime() - t3) / 1000;

                bubbleSort.bubbleWriteToFile(outFileName, sortedBubble);
                
                //Heap Sort
                long t4 = System.nanoTime();
                int[] sortedHeap = heapSort.heapSort(array);
                long time4 = (System.nanoTime() - t4) / 1000;

                heapSort.heapWriteToFile(outFileName, sortedHeap);

            } catch (FileNotFoundException e) {
                System.out.println("\nFile does not exist! Please try again!\n");
                fileName = sc.nextLine();
                file = new File(fileName);
            }
        }
        sc.close();
    }
}