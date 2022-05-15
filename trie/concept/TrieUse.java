package trie.concept;

public class TrieUse {
    public static void main(String[] args) {
        Trie t1 = new Trie();
        t1.add("this");
        t1.add("news");
        System.out.println(t1.search("news"));
        t1.remove("news");
        System.out.println(t1.search("news"));
        System.out.println(t1.startsWith("thi"));
    }
}
