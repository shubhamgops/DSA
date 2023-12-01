import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquilibriumIndexOfArray {

    public static void main(String[] args) {

      EquilibriumIndexOfArray obj = new EquilibriumIndexOfArray();

      int[] input = {-7, 1, 5, 2, -4, 3, 0};
      ArrayList<Integer> arrayList = new ArrayList<>(List.of(Arrays.stream(input).boxed().toArray(Integer[]::new)));
      System.out.println(obj.solve(arrayList));

      int[] input2 = {1, 2, 3};
      ArrayList<Integer> arrayList2 = new ArrayList<>(List.of(Arrays.stream(input2).boxed().toArray(Integer[]::new)));
      System.out.println(obj.solve(arrayList2));

    }

    public int solve(ArrayList<Integer> A) {

        int n = A.size();

        if (n == 0) {
            return -1;
        }

        int[] ps = new int[n];


        //creating prefix sum array
        ps[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i-1] + A.get(i);
        }

        //iterate, calculate and check sum of li and sum of hi
        for (int i = 0; i < n; i++) {
            int sumli = (i == 0) ? 0 : ps[i-1];
            int sumhi = ps[n-1] - ps[i];
            if (sumli == sumhi) {
                return i;
            }
        }
        return -1;

    }
}
