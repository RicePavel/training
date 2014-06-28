/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 *
 * сортировка выбором
 * @author Pavel Rice 
 */
public class SelectionSort {

  private int countOperation = 0;

  public int getCountOperation() {
    return countOperation;
  }

  public void sort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      // найти наименьший элемент
      int idxMin = i;
      for (int n = i; n < array.length; n++) {
        countOperation++;
        if (array[n] < array[idxMin]) {
          idxMin = n;
        }
      }
      // поменять местами этот элемент и наименьший элемент
      int elem = array[i];
      array[i] = array[idxMin];
      array[idxMin] = elem;
    }
  }
}
