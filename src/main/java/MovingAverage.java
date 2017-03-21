import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by krudio on 3/21/17.
 */
public class MovingAverage {
    private Queue<Integer> vals;
    private final int size;

    public MovingAverage(int size) {
        vals = new ArrayDeque<>();
        this.size = size;
    }

    public double next(int value) {
        if(vals.size() == this.size) {
            vals.poll();
        }

        vals.offer(value);

        double sum = 0;
        for(Integer val : vals) {
            sum += val;
        }

        return sum / (double)vals.size();
    }
}