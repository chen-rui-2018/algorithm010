import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： chenr
 * @date： Created on 2020/7/26 22:26
 * @version： v1.0
 * @modified By:
 * 朋友圈
 */
public class FindCircleNum  {
    public static void main(String[] args) {
      int [][] m = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(new FindCircleNum().findCircleNum(m));
        System.out.println(new FindCircleNum().findCircleNum1(m));

    }
    public int findCircleNum(int[][] M) {
        int [] visited = new int [M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
            }
            while (!queue.isEmpty()){
                int s = queue.remove();
                visited[s] = 1;
                for (int j = 0; j < M.length; j++) {
                    if (M[s][j] == 1 && visited[j] == 0){
                         queue.add(j);
                    }
                }
                count++;
            }

        }
        return count;
    }
    public int findCircleNum1(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue < Integer > queue = new LinkedList < > ();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }


}
