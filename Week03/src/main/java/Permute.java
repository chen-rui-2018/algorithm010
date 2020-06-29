import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/6/29 9:42
 * @version： v1.0
 * @modified By:
 *  全排列
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        List<List<Integer>> res = new Permute().permute(nums);
    }
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean [] used = new boolean[len];
        dfs(nums,len,0,path,used,res);
        return res;

    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len ; i++) {
            if (used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1,path,used,res);
            path.removeLast();
            used[i] = false;
        }
    }
}
