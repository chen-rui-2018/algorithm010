import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author： chenr
 * @date： Created on 2020/6/21 10:20
 * @version： v1.0
 * @modified By:
 * 前 K 个高频元素
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int [] arrays = {1,1,1,2,2,3};
        int k = 2;
        int [] aim = new TopKFrequent().topKFrequent(arrays,k);
        for (int i : aim) {
            System.out.print(i+",");
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((v1,v2)->map.get(v1)-map.get(v2));
        for (int i : map.keySet()) {
            heap.add(i);
            if (heap.size()>k) {
                heap.poll();
            }
        }
        int [] aim = new int [k];
        int index = k-1;
        while (!heap.isEmpty()) {
            aim[index--] = heap.poll();
        }

        return  aim;
    }
}
