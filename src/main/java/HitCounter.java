import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiken920 on 3/23/17.
 */
public class HitCounter {
    private Map<Integer, Integer> hits;
    private static final int FIVE_MINUTES_SEC = 300;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        hits = new LinkedHashMap<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        if (hits.containsKey(timestamp)) {
            hits.put(timestamp, hits.get(timestamp) + 1);
        } else {
            hits.put(timestamp, 1);
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        if (hits.size() > 0) {
            int totalHits = 0;
            if (timestamp <= FIVE_MINUTES_SEC) {
                //return everything
                for (Map.Entry<Integer, Integer> entry : hits.entrySet()) {
                    totalHits += entry.getValue();
                }
            } else {
                int endTime = timestamp - FIVE_MINUTES_SEC;
                List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hits.entrySet());

                for (int i = list.size() - 1; i >= 0; i--) {
                    Map.Entry<Integer, Integer> entry = list.get(i);
                    if (entry.getKey() <= endTime) {
                        hits.remove(entry.getKey());
                    } else {
                        totalHits += entry.getValue();
                    }
                }
            }
            return totalHits;
        } else {
            return 0;
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */