/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task;

import java.util.Comparator;

/**
 *
 * @author Новый профиль
 */
class ResultComparator implements Comparator<Result> {

  @Override
  public int compare(Result res1, Result res2) {
   if (res1.aCount > res2.aCount) {
     return +1;
   } else {
     return -1;
   }
  }
  
}
