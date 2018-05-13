import org.junit.Test;

import java.util.*;

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
        TreeSet<Integer> ts = new TreeSet<>(com);
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

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 12, 19999.12),
            new Employee("李四", 38, 12222.12),
            new Employee("王五", 50, 1244.12),
            new Employee("赵六", 16, 1222.12),
            new Employee("天气", 8, 7777.12)
    );

    @Test
    public void test4() {
        List<Employee> list = filterEmployees(employees);
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }

    public List<Employee> filterEmployees(List<Employee> list){
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }
        return emps;
    }

    public List<Employee> filterEmployees2(List<Employee> list){
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getSalary() >= 5000) {
                emps.add(emp);
            }
        }
        return emps;
    }

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee e : list) {
            if (mp.test(e)) emps.add(e);
        }
        return emps;
    }

    @Test
    public void test5() {
        List<Employee> list = filterEmployee(employees, new FilterEmployeeByAge());
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void test6() {
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() <= 35 && employee.getSalary() >= 5000;
            }
        });
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }

    // lambda 表达式
    @Test
    public void test7() {
        List<Employee> list = filterEmployee(employees, (e) -> e.getSalary() >= 5000);
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }

    // stream api
    @Test
    public void test8() {
        employees.stream()
                .filter((e) -> e.getSalary() >= 5000)
                .forEach(System.out::println);
    }

}
