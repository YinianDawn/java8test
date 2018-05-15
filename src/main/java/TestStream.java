import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Candy on 2018/5/15
 *
 * 一、stream的三个操作步骤
 *
 * 1. 创建Stream
 * 2. 中间操作
 *  筛选与切片 filter limit skip distinct
 *  映射 map flatMap
 *  排序 sorted
 * 3. 终止操作
 *  查找与匹配 allMatch anyMatch noneMatch findFirst findAny count max min forEach
 *  归约与收集 reduce collect
 *
 * 二、并行
 * parallel
 */
public class TestStream {

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        List<Integer> l = list.stream()
                            .map(s -> new Integer(s.length()))
                            .collect(Collectors.toList());
    }


    @Test
    public void test1() {
        List<String> list = new ArrayList<>();

        Stream<String> s1 = list.stream();
        Stream<String> s2 = list.parallelStream();

        String[] array = new String[0];
        Stream<String> s3 = Arrays.stream(array);

        Stream<String> s4 = Stream.of("12", "23");

        Stream<Integer> s5 = Stream.iterate(0, x -> x + 2);
        s5.limit(10).forEach(System.out::println);

        Stream<Double> s6 = Stream.generate(() -> Math.random());
        s6.limit(5).forEach(System.out::println);
    }

}
