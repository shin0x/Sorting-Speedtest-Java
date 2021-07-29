import java.awt.*;
import java.security.spec.AlgorithmParameterSpec;

public class Comparison {
    public static Time comp(int[] numbers, boolean bubble, boolean selection, boolean insertion, boolean quicksort, boolean heapsort){
        Time t = new Time();
        if(bubble) {
            long bubbleSortTimeStart = System.currentTimeMillis();
            Algorithms.bubbleSort(numbers.clone());
            t.bubbleSort = (int) (System.currentTimeMillis() - bubbleSortTimeStart);
        }
        if (selection) {
            long selectionSortTimeStart = System.currentTimeMillis();
            Algorithms.selectionSort(numbers.clone());
            t.selectionSort = (int) (System.currentTimeMillis() - selectionSortTimeStart);
        }
        if(insertion) {
            long insertionSortTimeStart = System.currentTimeMillis();
            Algorithms.insertionSort(numbers.clone());
            t.insertionSort = (int) (System.currentTimeMillis() - insertionSortTimeStart);
        }
        if(quicksort){
            long quicksortSortTimeStart = System.currentTimeMillis();
            int[] arr = numbers.clone();
            Algorithms.quickSort(arr, 0, arr.length-1);
            t.quickSort = (int) (System.currentTimeMillis() - quicksortSortTimeStart);
        }
        if(heapsort){
            long heapSortTimeStart = System.currentTimeMillis();
            int[] arr = numbers.clone();
            Algorithms.heapSort(arr);
            t.heapSort = (int) (System.currentTimeMillis() - heapSortTimeStart);
        }
        return t;
    }
}
