import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author： chenr
 * @date： Created on 2020/7/1 17:21
 * @version： v1.0
 * @modified By:
 * 最小基因变化
 */
public class MinMutation {
    private int count=Integer.MAX_VALUE;
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        String []  bank = {"hot","dot","dog","lot","log","cog"};
        System.out.println(new MinMutation().minMutation(start,end,bank));
        System.out.println(20%1000);
    }
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>();
        dfs(0,start,end,bank,set);
        return count== Integer.MAX_VALUE ? -1 : count;
    }

    private void dfs(int minCount, String start, String end, String[] bank, HashSet<String> set) {
        if (start.equals(end)) {
            count = Math.min(minCount,count);
            return;
        }
        for (int i = 0; i < bank.length; i++) {
            int deff = 0;
            for (int j = 0; j < start.length(); j++) {
                if (bank[i].charAt(j) != start.charAt(j)) {
                    deff++;
                }
                if (deff > 1) {
                    break;
                }
            }
            if (deff == 1 && !set.contains(bank[i])) {
                set.add(bank[i]);
                dfs(minCount +1,bank[i],end,bank,set);
                set.remove(bank[i]);
            }
        }
    }

}
