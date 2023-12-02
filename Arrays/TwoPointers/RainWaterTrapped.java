package Arrays.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainWaterTrapped {
  public static void main(String[] args) {
    RainWaterTrapped obj = new RainWaterTrapped();

    int[] input = { 0, 1, 0, 2 };
    ArrayList<Integer> listInput = obj.arraytoArrayList(input);
    System.out.println(obj.solveTP(listInput));

    int[] input2 = { 1, 2 };
    ArrayList<Integer> listInput2 = obj.arraytoArrayList(input2);
    System.out.println(obj.solveTP(listInput2));

    int[] input3 = { 2, 0, 3, 0, 1, 0, 1, 2, 4 };
    ArrayList<Integer> listInput3 = obj.arraytoArrayList(input3);
    System.out.println(obj.solveTP(listInput3));

    int[] input4 = { 1, 2, 0, 1, 0, 3, 1, 0, 1, 0, 4, 1 };
    ArrayList<Integer> listInput4 = obj.arraytoArrayList(input4);
    System.out.println(obj.solveTP(listInput4));

  }

  /* using two pointers T.C:O(n) S.C:O(1) */
  private int solveTP(ArrayList<Integer> A)
  {
    int total = 0;
    int l = 0;
    int r = A.size() - 1;
    int lMax = 0;
    int rMax = 0;

    while (l <= r) {
      if (lMax <= rMax) {
        int sum = lMax - A.get(l);
        if (sum > 0) {
          total += sum;
        } else {
          lMax = A.get(l);
        }
        l++;
      } else {
        int sum = rMax - A.get(r);
        if (sum > 0) {
          total += sum;
        } else {
          rMax = A.get(r);
        }
        r--;
      }
    }

    return total;
  }


  /* Using Prefix Sum Approach T.C:O(n) S.C:O(n) */
  private int solvePS(ArrayList<Integer> A)
  {
    int total = 0;
    int lMax = 0;
    int n = A.size();
    int[] rMax = new int[n + 1];

    //calculate the pSum of rMax;
    for (int i = n - 1; i >= 0; i--) {
      if (A.get(i) > rMax[i+1]) {
        rMax[i] = A.get(i);
      } else {
        rMax[i] = rMax[i+1];
      }
    }

    for (int i = 0; i < n; i++) {
      if (A.get(i) > lMax) {
        lMax = A.get(i);
      }

      int min = Math.min(lMax, rMax[i]);
      int sum = min - A.get(i);
      if (sum > 0) {
        total += sum;
      }
    }


    return total;
  }

  /* Brutforce Approach T.C:O(n^2) S.C:O(1) */
  private int solveBF(ArrayList<Integer> A)
  {
      int total = 0;
      int lMax = 0;
      int rMax = 0;
      int sum  = 0;

      for (int i = 0; i < A.size(); i++) {

        lMax = 0; rMax = 0;
        //get the lMax
        for (int j = i-1; j >= 0; j--) {
          if (A.get(j) > lMax) {
            lMax = A.get(j);
          }
        }

        //get the rMax
        for (int j = i+1; j < A.size(); j++) {
          if (A.get(j) > rMax) {
            rMax = A.get(j);
          }
        }

        int min = Math.min(lMax, rMax);
        sum = min - A.get(i);
        if (sum > 0) {
          total += sum;
        }
      }

      return total;
  }

  private ArrayList<Integer> arraytoArrayList(int[] input) {
    ArrayList<Integer> list = new ArrayList<>(List.of(Arrays.stream(input).boxed().toArray(Integer[]::new)));
    return list;
  }
}
