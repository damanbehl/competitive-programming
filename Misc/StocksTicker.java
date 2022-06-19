package misc;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;
import java.util.AbstractMap;
/*
* Question
*Given a stream of stock prices, design a data structure to *support the following operations:

*StockSticker(int k) Initialize the size of the ticker.
*void addOrUpdate(String stock, double price) add or update the *price of a stock to the data structure.
*List<Map.Entry<String, double>> top() return the top k price *stocks and their current prices.
*/

public class StocksTicker {
    int k;
    HashMap<String, Double> map;
    TreeSet<Map.Entry<String, Double>> set;

    public StocksTicker(int k) {
        this.k = k;
        this.map = new HashMap<>();
        this.set = new TreeSet<>(new TSComparator());
    }

    public static void main(String[] args) {
        StocksTicker ticker = new StocksTicker(10);

        ticker.addOrUpdate("A", 10.00);
        ticker.addOrUpdate("B", 1.00);
        ticker.addOrUpdate("C", 9.00);
        ticker.addOrUpdate("D", 2.00);
        ticker.addOrUpdate("E", 8.00);
        ticker.addOrUpdate("F", 3.00);
        ticker.addOrUpdate("G", 7.00);
        ticker.addOrUpdate("H", 4.00);
        ticker.addOrUpdate("I", 6.00);
        ticker.addOrUpdate("J", 5.00);

        List<Map.Entry<String, Double>> topStocks = ticker.top(5);

        for (Map.Entry<String, Double> s : topStocks) {
            System.out.print(s.getKey() + ": " + s.getValue() + " ");
        }
    }

    void addOrUpdate(String stock, double price) {
        AbstractMap.Entry<String, Double> entry = new AbstractMap.SimpleEntry<>(stock, price);
        if (map.containsKey(stock)) {
            set.remove(new AbstractMap.SimpleEntry<>(stock, map.get(stock)));
        }
        map.put(stock, price);
        set.add(entry);
    }

    static class TSComparator implements Comparator<Map.Entry<String, Double>> {
        @Override
        public int compare(Map.Entry<String, Double> obj1,
                Map.Entry<String, Double> obj2) {
            int res = obj2.getValue().compareTo(obj1.getValue());
            if (res == 0) {
                return obj2.getKey().compareTo(obj1.getKey());
            }
            return res;
        }
    }

    List<Map.Entry<String, Double>> top(int k) {
        List<Map.Entry<String, Double>> res = new ArrayList<>();
        Iterator<Map.Entry<String, Double>> setIter = set.iterator();
        int i = 0;
        while (i < k && setIter.hasNext()) {
            res.add(setIter.next());
            i++;
        }
        return res;
    }
}