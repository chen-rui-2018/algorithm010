import java.util.LinkedList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/6/28 23:28
 * @version： v1.0
 * @modified By:
 */
public class Combine  {
    List<List<Integer>> output = new LinkedList();
    int n;
    int k;
    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.output =    new Combine().combine(4,2);
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        _combineHelper(1,new LinkedList<Integer>());
        return output;
    }

    private void _combineHelper(int first, LinkedList<Integer> integers) {
        if (integers.size() == k) {
            output.add(new LinkedList<>(integers));
            return;
        }
        for (int i=first; i<n+1;i++) {
            integers.add(i);
            _combineHelper(i+1,integers);
            integers.removeLast();
        }

    }

}
