import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Tang on 2018/5/11.
 */
public class TestLambda {

    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
    }

    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    @Test
    public void test3() {
        Comparator<Integer> com = Integer::compare;
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //--------------------------------------------------------------------------------

    List<>


}
