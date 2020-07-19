import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/7/15 10:39
 * @version： v1.0
 * @modified By:
 * 三角形最小路径和
 */
public class MinimumTotal {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(0,2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(0,3);
        list2.add(1,4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(0,6);
        list3.add(1,5);
        list3.add(2,7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(0,4);
        list4.add(1,1);
        list4.add(2,8);
        list4.add(3,3);
        List<List<Integer>> param = new ArrayList<>();
        param.add(0,list1);
        param.add(1,list2);
        param.add(2,list3);
        param.add(3,list4);
      int result =   new MinimumTotal().minimumTotal(param);
      int result2 =   new MinimumTotal().minimumTotal2(param);
      int result3 =   new MinimumTotal().minimumTotal3(param);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n =  triangle.size();
        int [][] f = new int [n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i-1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i-1][j-1],f[i-1][j])+triangle.get(i).get(j);
            }
            f[i][i] = f[i-1][i-1] + triangle.get(i).get(i);
        }
        int minTotal = f[n-1][0];
        for (int i = 0; i < n; i++) {
            minTotal = Math.min(minTotal,f[n-1][i]);
        }
        return minTotal;
    }
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n =  triangle.size();
        int [][] f = new int [2][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
           int curr = i % 2;
           int prev = 1 - curr;
           f[curr][0] = f[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                f[curr][j] = Math.min(f[prev][j-1],f[prev][j-1])+ triangle.get(i).get(j);
            }
            f[curr][i] = f[curr][i-1] + triangle.get(i).get(i);
        }
        int minTotal = f[(n-1)%2][0];
        for (int i = 0; i < n; i++) {
            minTotal = Math.min(minTotal,f[(n-1)%2][i]);
        }
        return minTotal;
    }
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int []  f = new int [triangle.get(n-1).size()];
        for (int i = 0; i < f.length; i++) {
            f[i] = triangle.get(n-1).get(i);
        }
        for (int i = n-2; i >= 0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                f[j] = Math.min(f[j],f[j+1]) + triangle.get(i).get(j);
            }
        }
        return f[0];
    }
}
