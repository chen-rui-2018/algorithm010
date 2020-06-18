
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2020/6/15 22:26
 * @version： v1.0
 * @modified By:
 * 242. 有效的字母异位词
 */
public class IsAnagram {
    public static void main(String[] args) {
       String s = "anagram";
       String  t = "nagaram";
       System.out.println(new IsAnagram().isAnagram(s,t));
       System.out.println(new IsAnagram().isAnagram2(s,t));
    }
    // 排序 后相等
    public boolean isAnagram(String s, String t) {
        char [] chars = s.toCharArray();
        char [] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        String newS = new String(chars);
        String newT = new String(chart);
        return newS.equals(newT);
    }

    // map 计算个数
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char [] chars = s.toCharArray();
        char [] chart = t.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0 ;  i< chars.length; i++){
            if(map.containsKey(chars[i])){
                map.put(chars[i],map.get(chars[i])+1);
            }else {
                map.put(chars[i], 1);
            }
        }
        for (int i = 0 ;  i< chart.length; i++){
            if(map.containsKey(chart[i])){
                map.put(chart[i], map.get(chart[i]) - 1);
             }
        }
        for (Integer integer : map.values() ){
            if(integer != 0){
                return false;
            }
        }
        return true;
    }
}
