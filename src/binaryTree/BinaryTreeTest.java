/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Pavel Rice
 */
public class BinaryTreeTest {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    //removeTest();
    //testMap();
    testTime();
  }

  private static void removeTest() {
    BTMap map = new BTMap();
    map.put("N", "N");
    map.put("H", "H");
    map.put("C", "C");
    map.put("K", "K");
    map.put("S", "S");
    map.put("Q", "Q");
    map.put("V", "V");
    map.put("A", "A");
    map.put("D", "D");
    map.put("J", "J");
    map.put("L", "L");
    map.put("P", "P");
    map.put("R", "R");
    map.put("U", "U");
    map.put("W", "W");
    map.remove("N");
    map.remove("H");
    System.out.println(map.get("N"));
    System.out.println(map.get("H"));
    System.out.println(map.get("A"));
    System.out.println(map.get("C"));
    System.out.println(map.get("S"));
    System.out.println(map.get("V"));
    System.out.println(map.get("W"));
  }

  private static void testTime() {

    System.out.println("start test");
    Map<String, Object> etalonMap = new HashMap();
    BTMap testMap = new BTMap();
    List<String> etalonKeys = new ArrayList();
    List<String> testKeys = new ArrayList();

    int size = 100000;
    
    long ms = new Date().getTime();
    for (int i = 1; i <= size; i++) {
      String key = getRandomString();
      String value = getRandomString();
      etalonMap.put(key, value);
      etalonKeys.add(key);
    }
    long ms2 = new Date().getTime();
    long diff = ms2 - ms;
    System.out.println("etalon put: " + diff);

    ms = new Date().getTime();
    for (int i = 1; i <= size; i++) {
      String key = getRandomString();
      String value = getRandomString();
      testMap.put(key, value);
      testKeys.add(key);
    }
    ms2 = new Date().getTime();
    diff = ms2 - ms;
    System.out.println("test put: " + diff);
    
    ms = new Date().getTime();
    for (int i = 1; i <= size; i++) {
      String key = getRandomString();
      etalonMap.get(key);
    }
    ms2 = new Date().getTime();
    diff = ms2 - ms;
    System.out.println("etalon get: " + diff);
    
    ms = new Date().getTime();
    for (int i = 1; i <= size; i++) {
      String key = getRandomString();
      testMap.get(key);
    }
    ms2 = new Date().getTime();
    diff = ms2 - ms;
    System.out.println("test get: " + diff);
    
    ms = new Date().getTime();
    for (String key: etalonKeys) {
      etalonMap.remove(key);
    }
    ms2 = new Date().getTime();
    diff = ms2 - ms;
    System.out.println("etalon remove: " + diff);
    
     ms = new Date().getTime();
    for (String key: testKeys) {
      testMap.remove(key);
    }
    ms2 = new Date().getTime();
    diff = ms2 - ms;
    System.out.println("test remove: " + diff);
    
    ms = new Date().getTime();
    for (int i = 1; i <= size; i++) {
      String key = getRandomString();
      etalonMap.remove(key);
    }
    ms2 = new Date().getTime();
    diff = ms2 - ms;
    System.out.println("etalon remove random: " + diff);
    
    ms = new Date().getTime();
    for (int i = 1; i <= size; i++) {
      String key = getRandomString();
      testMap.remove(key);
    }
    ms2 = new Date().getTime();
    diff = ms2 - ms;
    System.out.println("test remove random: " + diff);
  }

  private static void testMap() {
    System.out.println("start test");
    Map<String, Object> etalonMap = new HashMap();
    BTMap testMap = new BTMap();
    for (int i = 1; i <= 10000; i++) {
      String key = getRandomString();
      String value = getRandomString();
      etalonMap.put(key, value);
      testMap.put(key, value);
    }
    for (String key : etalonMap.keySet()) {
      if (!(testMap.get(key) == etalonMap.get(key))) {
        System.out.println("FALSE " + key + " " + etalonMap.get(key) + " " + testMap.get(key));
      }
    }
    for (int i = 1; i <= 100; i++) {
      String key = getRandomString();
      if (!(testMap.get(key) == etalonMap.get(key))) {
        System.out.println("FALSE " + key + " " + etalonMap.get(key) + " " + testMap.get(key));
      }
    }
    Random random = new Random();
    List<String> keys = new ArrayList();
    for (String key : etalonMap.keySet()) {
      keys.add(key);
    }
    for (String key : keys) {
      if (random.nextBoolean()) {
        etalonMap.remove(key);
        testMap.remove(key);
      }
    }
    for (String key : keys) {
      if (!(testMap.get(key) == etalonMap.get(key))) {
        System.out.println("FALSE " + key + " " + etalonMap.get(key) + " " + testMap.get(key));
      }
    }
    for (int i = 1; i <= 100; i++) {
      String key = getRandomString();
      if (!(testMap.get(key) == etalonMap.get(key))) {
        System.out.println("FALSE " + key + " " + etalonMap.get(key) + " " + testMap.get(key));
      }
    }
    System.out.println("end test");
  }

  private static String getRandomString() {
    String[] chars = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
      "-", "=", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "[", "]",
      "a", "s", "d", "f", "g", "h", "j", "k", "l", ";", "'", "z", "x", "c",
      "v", "b", "n", "m", ",", ".", "й", "ц", "у", "к", "е", "н", "г", "ш",
      "щ", "з", "х", "ъ", "ф", "ы", "в", "а", "п", "р", "о", "л", "д", "ж",
      "э", "я", "ч", "с", "м", "и", "т", "ь", "б", "ю"};
    Random random = new Random();
    int count = random.nextInt(50);
    String str = "";
    for (int i = 1; i <= count; i++) {
      int index = random.nextInt(chars.length - 1);
      str += chars[index];
    }
    return str;
  }
}
