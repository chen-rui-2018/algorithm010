import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/7/5 16:21
 * @version： v1.0
 * @modified By:
 */
public class FindContentChildren {
    public static void main(String[] args) {
        int [] g ={1,2,};
        int [] s ={1,2,3};
        int count =  new FindContentChildren().findContentChildren(g,s);
        System.out.println(count);
    }
    public int findContentChildren(int[] g, int[] s) {
        if (g == null  || s == null || g.length == 0 || s.length==0) {
            return 0;
        }
        int gi = 0;
        int si = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
