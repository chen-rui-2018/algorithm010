package model;


import work.Trie;

/**
 * @author： chenr
 * @date： Created on 2020/7/23 15:37
 * @version： v1.0
 * @modified By:
 */
public class TestTrie {
    public static void main(String[] args) {
//    ["Trie","search","insert","search","search","startsWith","startsWith"]
//     [[],["ab"],["ab"],["ab"],["ab"],["ab"],["ab"]]
        Trie trie = new Trie();
//        trie.insert("ab");
        boolean search = trie.search("ab");
        boolean search1 = trie.search("ab");
        boolean start = trie.startsWith("ab");
        trie.insert("ab");
        boolean search2 = trie.search("ab");

        System.out.println(search);
        System.out.println(search1);
        System.out.println(start);
        System.out.println(search2);
    }
}
