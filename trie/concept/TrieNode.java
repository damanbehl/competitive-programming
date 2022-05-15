package trie.concept;

public class TrieNode {
    char data;
    TrieNode children[];
    boolean isTerminating;
    int childCount;

    TrieNode(char data) {
        this.data = data;
        children = new TrieNode[26];
        isTerminating = false;
        childCount = 0;
    }
}