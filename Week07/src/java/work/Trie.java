package work;

import model.TrieNode;

/**
 * @author： chenr
 * @date： Created on 2020/7/23 14:45
 * @version： v1.0
 * @modified By:
 */
public class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setIsEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node != null && node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                node = null;

            }
        }
        return node != null && node.getIsEnd();

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (node != null && node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else {

                node = null;
            }
        }
        return node != null;
    }

}
