import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2020/6/21 21:29
 * @version： v1.0
 * @modified By:
 * 字母异位词分组
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

//       List<List<String>> aimList =   new GroupAnagrams().groupAnagrams(strs);
       List<List<String>> aimList =   new GroupAnagrams().groupAnagrams1(strs);
        for (List<String> list : aimList) {
            System.out.println();
            for (String s : list) {
                System.out.print(s+",");
            }
        }

    }
    // 排序数组分类
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>(16);
        for (String str : strs) {
            char [] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
    // 按计数分类
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,List<String>> map = new HashMap<>(16);
        int [] count = new int [26];

        for (String str : strs) {
            Arrays.fill(count,0);
            char [] chars = str.toCharArray();
           for (char c : chars) {
                count[c-'a']++;
           }
           StringBuilder stringBuilder = new StringBuilder();
           for(int i = 0; i < count.length; i++ ){
               stringBuilder.append("#");
               stringBuilder.append(count[i]);
           }
           String key = stringBuilder.toString();
            if (!map.containsKey(key)) {
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
