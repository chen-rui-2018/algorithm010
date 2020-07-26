
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author： chenr
 * @date： Created on 2020/7/12 11:31
 * @version： v1.0
 * @modified By:
 */
public class IsValid {
    public static void main(String[] args) {
        String str = "()]";
        System.out.println( new IsValid().c(str));
    }
    public boolean c(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>(3);
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        if (map.containsKey(s.charAt(0))) {
            return false;
        }
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char topElement = stack.isEmpty() ? '$' : stack.pop();
                if (map.get(c) != topElement) {
                    return false;
                }
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
