import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/8/10 20:10
 * @version： v1.0
 * @modified By:
 */
public class CountBinarySubstrings {
    public static void main(String[] args) {
        String s = "10101";
        System.out.println(new CountBinarySubstrings().countBinarySubstrings(s));
    }
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>();
        int ptr = 0;
        int n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ptr++;
                count++;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); i++) {
            ans += Math.min(counts.get(i),counts.get(i-1));
        }
        return ans;
    }
}
