/**
 * @author： chenr
 * @date： Created on 2020/7/19 20:42
 * @version： v1.0
 * @modified By:
 * 回文子串
 */
public class CountSubstrings {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(new CountSubstrings().countSubstrings(s));
        System.out.println(new CountSubstrings().countSubstrings2(s));
    }
    public int countSubstrings(String s) {
        int N = s.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
    public int countSubstrings2(String s) {
        char[] A = new char[2 * s.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c: s.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right) {
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            }
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1]) {
                Z[i]++;
            }
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v: Z) {
            ans += (v + 1) / 2;
        }
        return ans;
    }
}
