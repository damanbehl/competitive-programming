package trie.hard;

//https://www.codingninjas.com/codestudio/problems/design-search-autocomplete-system_3583446
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class AutocompleteSystem {
    static StringBuffer sb;
    private static TrieNode root, curr;

    static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isWord;
        HashMap<String, Integer> freq;

        public TrieNode() {
            freq = new HashMap<>();
            children = new HashMap<>();
        }
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        // Write your code here.
        if (sentences == null || times == null || sentences.length != times.length) {
            return;
        }
        reset();
        root = new TrieNode();
        for (int i = 0; i < sentences.length; i++) {
            insert(root, sentences[i], times[i]);
        }
    }

    public static List<String> input(char c) {
        // Write your code here.
        if (curr == null) {
            curr = root;
        }
        if (c == '#') {
            insert(root, sb.toString(), 1);
            reset();
            return new ArrayList<>();
        }
        sb.append(c);
        curr.children.putIfAbsent(c, new TrieNode());
        curr = curr.children.get(c);
        return getSuggestions(curr, sb.toString());
    }

    public static List<String> getSuggestions(TrieNode root, String word) {
        List<String> result = new ArrayList<>();
        if (root.freq.isEmpty()) {
            return result;
        } else {
            PairComparator pc = new PairComparator();
            PriorityQueue<Pair> minHeap = new PriorityQueue<>(pc);
            for (Map.Entry<String, Integer> m : root.freq.entrySet()) {
                if (minHeap.size() < 3 || m.getValue() >= minHeap.peek().freq) {
                    minHeap.add(new Pair(m.getKey(), m.getValue()));
                }
                if (minHeap.size() > 3) {
                    minHeap.poll();
                }
            }
            while (minHeap.size() > 0) {
                result.add(0, minHeap.poll().word);
            }
        }
        return result;
    }

    static void insert(TrieNode root, String word, int n) {
        for (int i = 0; i < word.length(); i++) {
            root.children.putIfAbsent(word.charAt(i), new TrieNode());
            root = root.children.get(word.charAt(i));
            root.freq.put(word, root.freq.getOrDefault(word, 0) + n);
        }
        root.isWord = true;
    }

    static void reset() {
        curr = null;
        sb = new StringBuffer();
    }

    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            if (a.freq == b.freq) {
                // have to retain lexiographically smaller string as it will have more priority
                // than a same frequency lexiographically
                // larger string
                return b.word.compareTo(a.word);
            } else {
                return a.freq - b.freq;
            }
        }
    }

    static class Pair {
        String word;
        int freq;

        public Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
}
