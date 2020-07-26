import javafx.util.Pair;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2020/7/22 11:07
 * @version： v1.0
 * @modified By:
 * 单词接龙
 */
public class LadderLength2 {
    int count = Integer.MAX_VALUE;
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        System.out.println(System.currentTimeMillis());
        System.out.println( new LadderLength2().ladderLength(beginWord,endWord,list));
        System.out.println(System.currentTimeMillis());
    }

    /** 超时*/
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<>();

        dfs(0,beginWord,endWord,wordList,visited);


        return count == Integer.MAX_VALUE ? 0 : count+1;
    }
    private void dfs(int minCount, String beginWord, String endWord,  List<String> wordList,HashSet<String> visited) {
        if (beginWord.equals(endWord)) {
            count = Math.min(minCount,count);
            return;
        }
        for (int i = 0; i < wordList.size(); i++) {
            int deff = 0;
            for (int j = 0; j < beginWord.length(); j++) {
                if (wordList.get(i).charAt(j) != beginWord.charAt(j)) {
                    deff++;
                }
                if (deff > 1) {
                    break;
                }
            }
                 if (deff == 1 && !visited.contains(wordList.get(i))) {
                     visited.add(wordList.get(i));
                     dfs(minCount+1,wordList.get(i),endWord,wordList,visited);
                     visited.remove(wordList.get(i));
                 }


        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 所有单词长度相同
        int length = beginWord.length();
        //字典包含可组成的单词组合
        //从任何给定的词。 通过一次更改一个字母。
        Map<String,List<String>> allComboDict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                // Key是通用词
                //值是具有相同中间通用词的词的列表。
                String newWord = word.substring(0,i)+"*"+word.substring(i+1,length);
                List<String> transformations = allComboDict.getOrDefault(newWord,new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord,transformations);
            }
        }
        // queue for bfs
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        // 访问以确保我们不会重复处理相同的单词。
        Map<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);
        while (!queue.isEmpty()) {
            Pair<String,Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0;i < length; i++) {
                //当前单词的中间单词
                String newWord = word.substring(0,i)+"*"+word.substring(i+1,length);
                //下一个状态是共享相同中间状态的所有单词
                for (String adjacentWord : allComboDict.getOrDefault(newWord,new ArrayList<>())) {
                    //如果在任何时候找到我们想要的东西
                    //即结尾词-我们可以返回答案。
                    if (adjacentWord.equals(endWord)) {
                        return level+1;
                    }
                    //否则，将其添加到BFS队列中。 同时标记为已访问
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord,true);
                         queue.add(new Pair<>(adjacentWord,level+1));
                    }
                }
            }
        }

        return 0;
    }

}
