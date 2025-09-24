import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

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

                try (FileWriter csv = new FileWriter(outFileName + "_results.csv")) {
                    csv.write("n, insert_cmp, insert_swaps, insert_time, quick_cmp, quick_swaps, quick_time, bubble_cmp, bubble_swaps, bubble_time, heap_cmp, heap_swaps, heap_time\n");

                    for (int n = 0; n <= array.length; n++) {

                        int[] subArray = Arrays.copyOfRange(array, 0, n);

                        //Insertion Sort
                        int[] insertionArray = Arrays.copyOf(subArray, subArray.length);
                        long t1 = System.nanoTime();
                        int[] sortedInsertion = insertionSort.insertionSort(insertionArray);
                        long insertTime = (System.nanoTime() - t1) / 1000;
                        long insertSwap = insertionSort.getSwaps();
                        long insertCmp = insertionSort.getComparisons();

                        insertionSort.insertionWriteToFile(outFileName, sortedInsertion);

                        //Quick Sort
                        int[] quickArray = Arrays.copyOf(subArray, subArray.length);
                        long t2 = System.nanoTime();
                        int[] sortedQuick = quickSort.quickSort(quickArray, 0, quickArray.length - 1);
                        long quickTime = (System.nanoTime() - t2) / 1000;
                        long quickSwap = quickSort.getSwaps();
                        long quickCmp = quickSort.getComparisons();

                        quickSort.quickWriteToFile(outFileName, sortedQuick);

                        //Bubble Sort
                        int[] bubbleArray = Arrays.copyOf(subArray, subArray.length);
                        long t3 = System.nanoTime();
                        int[] sortedBubble = bubbleSort.bubbleSort(bubbleArray);
                        long bubbleTime = (System.nanoTime() - t3) / 1000;
                        long bubbleSwap = bubbleSort.getSwaps();
                        long bubbleCmp = bubbleSort.getComparisons();

                        bubbleSort.bubbleWriteToFile(outFileName, sortedBubble);
                        
                        //Heap Sort
                        int[] heapArray = Arrays.copyOf(subArray, subArray.length);
                        long t4 = System.nanoTime();
                        int[] sortedHeap = heapSort.heapSort(heapArray);
                        long heapTime = (System.nanoTime() - t4) / 1000;
                        long heapSwap = heapSort.getSwaps();
                        long heapCmp = heapSort.getComparisons();

                        heapSort.heapWriteToFile(outFileName, sortedHeap);

                        csv.write(n + ", " + insertCmp + ", " + insertSwap + ", " + insertTime + ", " + quickCmp + ", " + quickSwap + ", " + quickTime + ", " + bubbleCmp + ", " + bubbleSwap + ", " + bubbleTime + ", " + heapCmp + ", " + heapSwap + ", " + heapTime + "\n");
                    }

                } catch (IOException e) {
                    System.out.println("Could not write to file!");
                }

            } catch (FileNotFoundException e) {
                System.out.println("\nFile does not exist! Please try again!\n");
                fileName = sc.nextLine();
                file = new File(fileName);
            }
        }
        sc.close();
    }
}