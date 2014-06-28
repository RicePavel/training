/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discrete;

/**
 *
 * тест
 * @author Новый профиль
 */
public class SumNumbersTest {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    int count = 0;
    int number = 1;
    while (number < 10000) {
      if (sumNumbers(number) == 12) {
        count++;
      }
      number++;
    }
    System.out.println(count);
  }

  private static int sumNumbers(Integer number) {
    int summ = 0;
    String str = number.toString();
    for (int i = 0; i < str.length(); i++) {
      String n = str.substring(i, i+1);
      summ += Integer.parseInt(n);
    }
    return summ;
  }
}
