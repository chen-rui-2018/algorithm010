package model;

/**
 * @author： chenr
 * @date： Created on 2020/7/23 15:05
 * @version： v1.0
 * @modified By:
 */
public class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode () {
        links = new TrieNode[R];
    }
    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }
    public TrieNode get(char ch){
        return links[ch-'a'];
    }
    public void put (char ch, TrieNode node) {
        links[ch -  'a'] = node;
    }
    public void setIsEnd(){
        isEnd = true;
    }
    public  boolean getIsEnd(){
        return isEnd;
    }


}
