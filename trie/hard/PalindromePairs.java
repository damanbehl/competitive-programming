package trie.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PalindromePairs {
    static class TrieNode {
        int index;
        List<Integer> otherPalin;
        TrieNode[] children;

        public TrieNode() {
            index = -1;
            children = new TrieNode[26];
            otherPalin = new ArrayList<>();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            add(root, i, words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }
        return res;
    }

    public void add(TrieNode root, int index, String word) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int childIndex = word.charAt(i) - 'a';
            if (root.children[childIndex] == null) {
                root.children[childIndex] = new TrieNode();
            }
            if (isPalindrome(word, 0, i)) {
                root.otherPalin.add(index);
            }
            root = root.children[childIndex];
        }
        root.index = index;
        // Trienode that is suffix of a word
        // since if it's exact palindrome is present, we want to add that trienode
        // itself along with the other words that passed through this node and were a
        // palindrome
        root.otherPalin.add(index);
    }

    public void search(String words[], int i, TrieNode root, List<List<Integer>> res) {
        // check if a node is terminating, and different than the current word we are
        // checking and that the remaining input word is a palindrome
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.index));
            }
            root = root.children[words[i].charAt(j) - 'a'];
            if (root == null) {
                return;
            }
        }
        // index of word with current trienode as suffix (case when we find the exact
        // match
        // as palindrome there, the index of word is stored for it being suffix)
        // and the remaining words which have input as a suffix of that word and their
        // remaining part
        // is a palindrome
        for (int x : root.otherPalin) {
            if (x == i) {
                continue;
            }
            res.add(Arrays.asList(i, x));
        }
    }

    public boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}