package trie.easy;

//https://www.codingninjas.com/codestudio/problems/implement-trie_1387095
class TrieNode {
    char data;
    int childCount;
    TrieNode children[];
    boolean isTerminating;
    int noOfTerminations;
    int passBy;

    public TrieNode(char data) {
        this.data = data;
        children = new TrieNode[26];
    }
}

class TrieDummy {
    private TrieNode root;

    public TrieDummy() {
        // Write your code here.
        root = new TrieNode('\0');
    }

    public void insert(String word) {
        // Write your code here.
        insert(root, word);
    }

    private void insert(TrieNode root, String word) {
        // Write your code here.
        if (word.length() == 0) {
            root.isTerminating = true;
            root.passBy++;
            root.noOfTerminations++;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        root.passBy++;
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        insert(child, word.substring(1));
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        return countWordEqualToTwo(root, word);
    }

    private int countWordEqualToTwo(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.noOfTerminations;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return 0;
        }
        return countWordEqualToTwo(child, word.substring(1));
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        return countWordsStartingWith(root, word);
    }

    private int countWordsStartingWith(TrieNode root, String word) {
        // Write your code here.
        if (word.length() == 0) {
            return root.passBy;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return 0;
        }
        return countWordsStartingWith(child, word.substring(1));
    }

    public void erase(String word) {
        // Write your code here.
        erase(root, word);
    }

    public void erase(TrieNode root, String word) {
        // Write your code here.
        if (word.length() == 0) {
            root.isTerminating = false;
            root.noOfTerminations--;
            root.passBy--;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;
        }
        erase(child, word.substring(1));
        root.passBy--;
        if (!child.isTerminating && child.childCount == 0 && child.noOfTerminations == 0) {
            root.children[childIndex] = null;
            child = null;
            root.childCount--;

        }
    }

}
