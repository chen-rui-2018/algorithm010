import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/7/2 9:26
 * @version： v1.0
 * @modified By:
 * 括号生成
 */
public class GenerateParenthesisTwo {
    public static void main(String[] args) {
        int n = 3;
        List<String> list = new GenerateParenthesisTwo().generateParenthesis(n);
        for (String s : list) {
            System.out.println(s);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>  list = new ArrayList<>();
        String s = "";
        return  _generate(n,0,0,s,list);
    }

    private List<String> _generate(int n, int left, int right, String s, List<String> list) {
        if (left == n && right == n) {
            list.add(s);
            return list;
        }

        if (left < n) {
           _generate(n,left+1,right,s+"(",list);
        }
        if (right < left) {
            _generate(n,left,right+1,s+")",list);
        }

        return list;

    }

}
