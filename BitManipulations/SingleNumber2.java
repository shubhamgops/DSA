package BitManipulations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber2 {
  public static void main(String[] args) {
    SingleNumber2 obj = new SingleNumber2();

    int[] input = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
    System.out.println(obj.solve(obj.arraytoArrayList(input)));

    int[] input2 = {0, 0, 0, 1};
    System.out.println(obj.solve(obj.arraytoArrayList(input2)));
  }

  private int solve(ArrayList<Integer> A)
  {
    int ans = 0;
    for (int i = 0; i < 32; i++) {
      int cnt = 0;
      for (int j = 0; j < A.size(); j++) {
        if (this.checkBit(A.get(j), i)) {
            cnt++;
        }
      }

      if (cnt % 3 != 0) {
        int num = (1 << i);
        ans = ans | num;
      }
    }
    return ans;
  }

  private Boolean checkBit(int num, int index)
  {
    int num2 = 1 << index;
    return (num & num2) == num2;
  }

  private ArrayList<Integer> arraytoArrayList(int[] input) {
    ArrayList<Integer> list = new ArrayList<>(List.of(Arrays.stream(input).boxed().toArray(Integer[]::new)));
    return list;
  }
}
