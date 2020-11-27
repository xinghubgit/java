package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @date 2020/11/25
 */

public class QuickSort {

    public static void main(String[] args) {
//        int[] array = {3, 5, 6, 9, 1, 4, 7};
        int[] array = {5, 9, 1, 9, 5, 3, 7, 6, 1};
//        bubbleSort(array);
//        selectionSort(array);
        quickSort(array);
//        Arrays.stream(array).forEach(System.out::println);
    }


    static int[] quickSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }

        quickSort(array, 0, array.length-1);
        return array;
    }

    static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int baseIndex = left;
        int endIndex = right;
        int baseValue = array[baseIndex];



        while (left < right) {
            while (left < right) {
                if (array[right] < baseValue) {
                    array[left] = array[right];
                    left++;
                    break;
                }
                right--;
            }

            while (left < right) {
                if (array[left] > baseValue) {
                    array[right] = array[left];
                    right--;
                    break;
                }
                left++;
            }
        }
        array[left] = baseValue;

        Arrays.stream(array).forEach(System.out::print);
        System.out.println("NexIndex : " + left);
        quickSort(array, baseIndex, left - 1);
        quickSort(array, left + 1, endIndex);
    }



    static int[] bubbleSort(int[] array) {
        if (array == null || array.length <= 2) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = t;
                }
            }
        }

        return array;
    }


    static int[] selectionSort(int[] array) {
        if (array == null || array.length <= 2) {
            return array;
        }

        int minIndex = 0;
        int i = 0, j = 0;
        for (i = 0; i < array.length - 1; i++) {
            int minValue = array[i];
            for (j = i + 1; j < array.length; j++) {
                if (minValue > array[j]) {
                    minIndex = j;
                    minValue = array[j];
                }
            }
            if (i != j) {
                int t = array[i];
                array[i] = array[minIndex];
                array[minIndex] = t;
            }
        }

        return array;
    }

}


