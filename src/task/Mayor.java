/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Новый профиль
 */
public class Mayor {

  int n;
  List<Way> ways;
  List<Result> results = new ArrayList();
  Cross[] crosses;

  public Mayor(int n, List<Way> ways) {
    this.n = n;
    this.ways = ways;
    calculate();
  }

  public List<Result> getResults() {
    return results;
  }
  

  private void calculate() {
    // создать массив перекрестков
    crosses = new Cross[n+1];
    for (int i = 1; i <= n; i++) {
      crosses[i] = new Cross();
    }
    createResults();
    filterRepeatResults();
    filterRightResults();
    findMaxResults();
    sortResults();
  }

  private void createResults() {
    createResults(1);
  }
  
  private void createResults(int index) {
    if (0 < index && index <= n) {
      Cross cross = crosses[index];
      if (index == n) {
        for (State state : State.values()) {
          cross.state = state;
          checkVar();
        }
      } else if (index < n) {
        for (State state : State.values()) {
          cross.state = state;
          checkVar();
          createResults(index + 1);
        }
      }
    }
  }

  private void checkVar() {
    boolean ok = true;
    for (Way way: ways) {
      ok = checkWay(way);
      if (!ok) {
        break;
      }
    }
    if (ok) {
      saveResult();
    }
  }
  
  
  private boolean checkWay(Way way) {
    Cross crossOne = crosses[way.crossOne];
    Cross crossTwo = crosses[way.crossTwo];
    boolean res;
    if (!crossOne.state.equals(crossTwo.state) && 
           !crossOne.state.equals(State.none) && !crossTwo.state.equals(State.none)) {
      res = false;
    } else {
      res = true;
    }
    return res;
  }
  
  private void saveResult() {
    Result res = new Result();
    results.add(res);
    for (int i = 1; i <= n; i++) {
      Cross cross = crosses[i];
      if (cross.state.equals(State.b)) {
        res.bCount++;
      } else if (cross.state.equals(State.a)) {
        res.aCount++;
      }
    }
  }
  
  private void filterRepeatResults() {
    Map<String, Result> map = new HashMap();
    for (Result res: results) {
      String key = res.aCount + "_" + res.bCount;
      map.put(key, res);
    }
    List<Result> newResults = new ArrayList();
    for (Result res: map.values()) {
      newResults.add(res);
    }
    results = newResults;
  }
  
  private void filterRightResults() {
    List<Result> newResults = new ArrayList();
    for (Result res: results) {
      if (res.aCount > 0 && res.bCount > 0) {
        newResults.add(res);
      }
    }
    results = newResults;
  }
  
  private void findMaxResults() {
    int max = 0;
    for (Result res: results) {
      int summ = res.bCount + res.aCount;
      if (summ > max) {
        max = summ;
      }
    }
    List<Result> newResults = new ArrayList();
    for (Result res: results) {
      int summ = res.bCount + res.aCount;
      if (summ == max) {
        newResults.add(res);
      }
    }
    results = newResults;
  }
  
  private void sortResults() {
    Collections.sort(results, new ResultComparator());
  }
  
}


