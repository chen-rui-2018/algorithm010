import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author： chenr
 * @date： Created on 2020/6/18 22:34
 * @version： v1.0
 * @modified By:
 * 最小的k个数
 */
public class LeastNumbers {
    public static void main(String[] args) {
        int k = 4;
        int [] array = {4,5,1,6,2,7,3,8};
        int [] aim = new LeastNumbers().getLeastNumbers(array,k);
        int [] aim1 = new LeastNumbers().getLeastNumbers1(array,k);
        int i = 0;
        while (i<k){
            System.out.print(aim1[i]);
            i++;
        }
    }
    // sort 排序 取前k 个值
    public int[] getLeastNumbers(int[] arr, int k) {
        int [] aim = new int [k];
         Arrays.sort(arr);
        for (int i=0; i<k; i++) {
            aim[i]=arr[i];
        }
        return aim;
    }
    //小根堆
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆,实现大根堆要重写比较器
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1,v2)->v2-v1);
        for (int num : arr) {
            if(pq.size()<k){
                pq.offer(num);
            }else if (num < pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }
        int [] res = new int[k];
        int index = 0;
        for (int num :pq){
            res[index++] = num;
        }
       return res;
    }

}
