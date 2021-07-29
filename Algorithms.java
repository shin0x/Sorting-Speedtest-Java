public class Algorithms {

    //O(n2)
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //O(n2)
    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    //O(n2)
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }

    //O(n log n)
    public static void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            quickSort(array, begin, partitionIndex-1);
            quickSort(array, partitionIndex+1, end);
        }
    }

    //function needed for the quickSort algorithm
    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        int swapTemp = array[i+1];
        array[i+1] = array[end];
        array[end] = swapTemp;

        return i+1;
    }

    //O(n log (n))
    public static void heapSort(int[] array){
        int temp = 0;
        for (int i=array.length; i>=0; i--)
            heap(array, array.length, i, temp);
        for (int i=array.length-1; i>=0;i--){
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heap(array, i, 0, temp);
        }
    }
    private static void heap(int array[], int length, int i, int temp){
        int biggestElement = i;
        int leftElement = 2*i+1;
        int rightElement = 2*i+2;


        if(leftElement < length && array[leftElement]>array[biggestElement])
            biggestElement=leftElement;
        if(rightElement < length && array[rightElement]>array[biggestElement])
            biggestElement=rightElement;
        if (biggestElement != i){
            temp = array[i];
            array[i] = array[biggestElement];
            array[biggestElement] = temp;
            heap(array, length, biggestElement, temp);
        }
    }
}
