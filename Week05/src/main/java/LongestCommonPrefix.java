import com.sun.jndi.ldap.Ber;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/7/11 17:58
 * @version： v1.0
 * @modified By:
 * 最长公共前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String [] strs = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String result = "";
        String first = strs[0];
        String last = strs[strs.length-1];
        int i = 0;
        for (; i < first.length(); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
        }
        result = first.substring(0,i);
        return result;
    }
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < result.length() && j < strs[i].length(); j++) {
                if (result.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            result = result.substring(0,j);
            if ("".equals(result)) {
                return result;
            }
        }
        return result;
    }
}
