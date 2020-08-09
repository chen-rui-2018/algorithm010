/**
 * @author： chenr
 * @date： Created on 2020/8/9 21:17
 * @version： v1.0
 * @modified By:
 * 反转字符串2
 */
public class ReverseStr {
    public static void main(String[] args) {
        System.out.println( new ReverseStr().reverseStr("abcdefg",3));
    }
    public String reverseStr(String s, int k) {
        char [] chars = s.toCharArray();
        for( int start = 0; start < chars.length; start+=2*k){
            int i = start;
            int j = Math.min(chars.length-1,start+k-1);
            while( i < j ){
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }
        }
        return new String(chars);
    }
}
