import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/6/23 11:41
 * @version： v1.0
 * @modified By:
 * 括号生成
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        List<String> list =  new GenerateParenthesis().generateParenthesis(n);
        for (String s : list) {
            System.out.println(s);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>  list = new ArrayList<>();
        String s = "";
        return  _generate(n,0,0,s,list);
    }

    private List<String>   _generate(int max,int left, int right  ,String s,List<String>  list) {
        // 递归终止条件
        if (left == max && right == max){
            list.add(s);
            return list;
        }
        if (left < max) {
            _generate(max, left + 1, right, s + "(",list);
        }
        if (right < left) {
            _generate(max, left, right + 1, s + ")",list);
        }
        return list;

    }

}
