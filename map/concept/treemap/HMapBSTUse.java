package map.concept.treemap;

public class HMapBSTUse {
    public static void main(String[] args) {
        HMapBst<String, Integer> hm = new HMapBst<String, Integer>();
        hm.put("daman", 1);
        hm.put("nishnat", 10);
        hm.printLevelWise();
        hm.put("sahil", -1);
        hm.put("zebra", 10);
        hm.put("zola", 10);
        hm.put("zola", 111);
        hm.printLevelWise();
        hm.delete("zola");
        hm.printLevelWise();

    }
}
