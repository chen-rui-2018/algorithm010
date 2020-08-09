import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2020/8/5 20:59
 * @version： v1.0
 * @modified By:
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "wangjunjiao";
        System.out.println( new FirstUniqChar().firstUniqChar(s));

        String column = "otherid19";

        column = column.substring(0,5)+"_p"+column.substring(5);
        System.out.println(column);
    }
    public int firstUniqChar(String s) {
        if(s == null || s == ""){
            return -1;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
