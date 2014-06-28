/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * проверка алгоритмов сортировки
 * @author Pavel Rice
 */
public class TestSort {

  public static void main(String[] args) {
    int size = 50000;
    int[] arr = randomArray(size);

    int[] array = Arrays.copyOf(arr, size);
    MergeSort mergeSorter = new MergeSort();
    long ms = new Date().getTime();
    array = mergeSorter.sort(array);
    long ms2 = new Date().getTime();
    long diff = ms2 - ms;
    //showArray(array);
    System.out.println("merge sort: " + diff);
    System.out.println("merge sort count operation: " + mergeSorter.getCountOperation());

    int[] arrayTwo = Arrays.copyOf(arr, size);
    QuickSort quickSorter = new QuickSort();
    ms = new Date().getTime();
    quickSorter.sort(arrayTwo);
    ms2 = new Date().getTime();
    diff = ms2 - ms;
    //showArray(arrayTwo);
    System.out.println("quick sort: " + diff);
    System.out.println("quick sort count operation: " + quickSorter.getCountOperation());

    int[] arrayThree =  Arrays.copyOf(arr, size);
    SelectionSort selectionSorter = new SelectionSort();
    ms = new Date().getTime();
    selectionSorter.sort(arrayThree);
    ms2 = new Date().getTime();
    diff = ms2 - ms;
    //showArray(arrayThree);
    System.out.println("selection sort: " + diff);
    System.out.println("selection sort count operation: " + selectionSorter.getCountOperation());
    
    int[] arrayEtalon = Arrays.copyOf(arr, size);
    ms = new Date().getTime();
    Arrays.sort(arrayEtalon, 0, arrayEtalon.length);
    ms2 = new Date().getTime();
    diff = ms2 - ms;
    //showArray(arrayEtalon);
    System.out.println("java standart sort: " + diff);

    showArray(arr);

  }

  private static int[] randomArray(int size) {
    int[] array = new int[size];
    Random random = new Random();
    int idx = 0;
    while (idx < array.length) {
      array[idx] = random.nextInt(1000);
      idx++;
    }
    return array;
  }

  private static void showArray(int[] array) {
    for (int i : array) {
      System.out.print(i + ", ");
    }
    System.out.println(" ");
  }
}
