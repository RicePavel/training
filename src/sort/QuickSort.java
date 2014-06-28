/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * быстрая сортировка
 * @author Pavel Rice 
 */
public class QuickSort {

  private int countOperation = 0;

  public int getCountOperation() {
    return countOperation;
  }
  
  /**
   * быстрая сортировка
   *
   * @param array массив, который надо отосортировать
   * @return
   */
  /*
   public int[] sort(int[] array) {
   List<Integer> list = new ArrayList();
   for (int elem : array) {
   list.add(elem);
   }
   list = sort(list);
   int idx = 0;
   for (int elem : list) {
   array[idx] = elem;
   idx++;
   }
   return array;
   }

   private List<Integer> sort(List<Integer> list) {
   // если в списке больше одного элемента
   if (list.size() > 1) {
   // взять первый элемент
   int first = list.get(0);
   // создать два новых списка - больше и меньше
   List<Integer> lesserList = new ArrayList();
   List<Integer> largerList = new ArrayList();
   int idx = 0;
   for (Integer elem : list) {
   if (idx != 0) {
   countOperation++;
   if (elem < first) {
   lesserList.add(elem);
   } else {
   largerList.add(elem);
   }
   }
   idx++;
   }
   lesserList.add(first);
   // для каждого списка повторить процедуру
   lesserList = sort(lesserList);
   largerList = sort(largerList);
   // соединить два списка в один
   list = new ArrayList();
   list.addAll(lesserList);
   list.addAll(largerList);
   }
   return list;
   }
   */
  public void sort(int[] array) {
    sort(array, 0, array.length - 1);
  }

  /**
   * быстрая сортировка части массива
   *
   * @param array массив
   * @param startIndex индекс начала части массива, включительно
   * @param endIndex нидекс конца части массив, включительно
   * @return
   */
  private void sort(int[] array, int startIndex, int endIndex) {
    // если длина массива больше 1
    if (endIndex > startIndex) {
      // взять первый элемент
      int etalonIdx = startIndex;
      // для каждого элемента после первого
      int idx = startIndex + 1;
      while (idx <= endIndex) {
        countOperation++;
        // если элемент меньше первого
        if (array[idx] < array[etalonIdx]) {
          // поставить этот элемент на первое место
          moveElement(array, idx, startIndex);
          // увеличить индекс первого элемента
          etalonIdx++;
        }
        idx++;
      }

      // повторить то же самое для двух подсписков
      sort(array, startIndex, etalonIdx);
      sort(array, etalonIdx + 1, endIndex);
    }
  }

  /**
   * поставить элемент на первое место
   *
   * @param array массив
   * @param idx индекс элемента, которрый надо поставить на первое место
   * @return
   */
  private void moveElement(int[] array, int idx, int newIdx) {
    //if (idx < array.length && newIdx < array.length && idx != newIdx) {
      int elem = array[idx];
      if (newIdx < idx) {
        while (idx != newIdx) {
          array[idx] = array[idx - 1];
          idx--;
        }
      } else {
        while (idx != newIdx) {
          array[idx] = array[idx + 1];
          idx++;
        }
      }
      array[newIdx] = elem;
    //}
  }
}
