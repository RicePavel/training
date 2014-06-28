/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 *
 * сортировка слиянием
 * @author Pavel Rice 
 */
public class MergeSort {

  private int countOperation = 0;

  public int getCountOperation() {
    return countOperation;
  }

  /**
   * сортировка слиянием
   *
   * @param array массив, который надо отсортировать
   * @return
   */
  public int[] sort(int[] array) {
    if (array.length > 1) {
      // разделить массив пополам
      int half = array.length / 2;
      int[] arr1 = Arrays.copyOfRange(array, 0, half);
      int[] arr2 = Arrays.copyOfRange(array, half, array.length);
      // отсортировать каждую половину
      arr1 = sort(arr1);
      arr2 = sort(arr2);
      // выполнить слияние двух половин
      array = merge(arr1, arr2);
    }
    return array;
  }

  /**
   * слияние двух массивов
   *
   * @param arr1
   * @param arr2
   * @return
   */
  private int[] merge(int[] arr1, int[] arr2) {
    // новый массив для результата
    int[] array = new int[arr1.length + arr2.length];
    int idx = 0;
    int idx1 = 0;
    int idx2 = 0;
    while (idx1 < arr1.length && idx2 < arr2.length) {
      // добавить в массив меньший элемент с начала
      int elem;
      countOperation++;
      if (arr1[idx1] < arr2[idx2]) {
        elem = arr1[idx1];
        idx1++;
      } else {
        elem = arr2[idx2];
        idx2++;
      }
      array[idx] = elem;
      idx++;
    }
    // добавить в массив остающиеся элементы
    while (idx1 < arr1.length) {
      array[idx] = arr1[idx1];
      idx1++;
      idx++;
    }
    while (idx2 < arr2.length) {
      array[idx] = arr2[idx2];
      idx2++;
      idx++;
    }
    return array;
  }
  
}
