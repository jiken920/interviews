import java.util.List;

/**
 * Created by jiken920 on 3/21/17.
 */
public class ZigzagIterator {
    private List<Integer> v1;
    private List<Integer> v2;
    private int v1index = 0;
    private int v2index = 0;
    private boolean alt = true;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if(v1.isEmpty() || v1index == v1.size()) {
            return v2.get(v2index++);
        } else if(v2.isEmpty() || v2index == v2.size()) {
            return v1.get(v1index++);
        }

        if(alt) {
            alt = !alt;
            return v1.get(v1index++);
        } else {
            alt = !alt;
            return v2.get(v2index++);
        }
    }

    public boolean hasNext() {
        return v1index < v1.size() || v2index < v2.size();
    }
}