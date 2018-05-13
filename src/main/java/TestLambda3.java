import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Candy on 2018/5/13
 *
 * 一、方法引用：若lambda体已经有方法实现了，那就用“方法引用”引用该方法，省的写lambda表达式了
 * 三种语法格式：
 * 对象::方法名
 * 类::静态方法名
 * 类::实例方法名
 *
 * 二、构造器引用
 * 格式
 * ClassName::new
 *
 * 三、数组引用
 * Type[]::new
 *
 */
public class TestLambda3 {

    public void test5() {
        Function<Integer, String[]> fun = (x) -> new String[x];
        Function<Integer, String[]> fun2 = String[]::new;

    }

    public void test4() {
        Supplier<Employee> sup = () -> new Employee();
        Supplier<Employee> sup2 = Employee::new;

        Function<String, Employee> fun = (s) -> new Employee(s);
        Function<String, Employee> fun2 = Employee::new;

    }

    @Test
    public void test3() {
        BiPredicate<String, String> bp = (s1, s2) -> s1.equals(s2);
        BiPredicate<String, String> bp2 = String::equals;


    }

    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> com2 = Integer::compare;

    }

    @Test
    public void test1() {
        PrintStream ps = System.out;
        Consumer<String> con = (s) -> ps.println(s);
        Consumer<String> con2 = ps::println;

        Employee e = new Employee("123", 12, 12);
        Supplier<String> sup = () -> e.getName();
        Supplier<String> sup2 = e::getName;

    }

}
