import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author： chenr
 * @date： Created on 2020/6/29 11:31
 * @version： v1.0
 * @modified By:
 * 全排列 II
 */
public class PermuteUnique {
    public static void main(String[] args) {
        int [] nums ={1,1,2};
        List<List<Integer>> lists = new PermuteUnique().permuteUnique(nums);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null ||  nums.length == 0 ){
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        boolean [] used = new boolean[len];
        dfs(nums,len,0,used,stack,res);
        return res;

    }

    private void dfs(int[] nums, int len, int depth, boolean [] used,Stack<Integer> stack, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]){
                continue;
            }
            if ( i > 0 && nums[i] == nums[i-1] && used[i-1] == false){
                continue;
            }
            stack.push(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1,used,stack,res);
            stack.pop();
            used[i] = false;
        }
    }
}
