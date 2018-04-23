package sorting.insertionSort;

public class InsertionSort {

    private int[] array;

    public int[] sort(int[] arr) {
        this.array = arr;
        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            if(array[i] > array[temp]) {
                temp = i;
            } else {
                int swap = array[i];
                for(int j = 0; j <= temp; j++) {
                    if(array[i] < array[j]) {

                    }
                }
            }
        }

        return arr;
    }

    private void swap(int from, int to) {
        for(int i = to; i > from; i--) {
            array[i + 1] = array[i];
        }
    }
}
