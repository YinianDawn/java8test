import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Created by Candy on 2018/5/13
 *
 * 一、lambda表达式基础。
 *      新的操作符 ->
 *      左侧：参数列表
 *      右侧：执行的代码，lambda体
 *
 *  语法格式一：无参数，无返回值  () -> System.out.println("123")
 *  语法格式二：一参数，无返回值  (str) -> System.out.println(str)
 *  语法格式三：一参数，小括号可以不写 str -> System.out.println(str)
 *  语法格式四：多参数，多条语句
 *  语法格式五：多参数，一语句   (x, y) ->  Integer.compare(x, y)
 *  语法格式六：参数列表的数据类型可以省略，实际上是编译器通过上下文推断的类型
 *
 * 二、lambda表达式需要函数式接口的支持
 *  函数式接口：只有一个抽象方法的接口
 *  有一个FunctionInterface接口修饰
 *
 * 三、Java8内置的四大核心函数式接口
 *  Consumer<T> 消费型接口 void accept(T t)
 *  Suppler<T> 供给型接口 T get();
 *  Function<T, R> 函数型接口 R apply(T t);
 *  Predicate<T> 断言型接口 boolean test(T t);
 */
public class TestLambda2 {

    public void test4() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println(123);
            return Integer.compare(x, y);
        };
    }

    public void test2() {
        Consumer<String> con = (str) -> System.out.println(str);
        con.accept("123");
    }

    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        };
        r.run();

        Runnable r2 = () -> System.out.println("123");
        r2.run();
    }

}
