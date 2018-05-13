import lombok.Data;

/**
 * Created by Tang on 2018/5/11.
 */
@Data
public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee() {}

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
