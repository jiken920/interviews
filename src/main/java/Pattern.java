import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by krudio on 5/15/17.
 */
public interface Pattern {
    void init(boolean[][] board) throws InvalidArgumentException;
}
