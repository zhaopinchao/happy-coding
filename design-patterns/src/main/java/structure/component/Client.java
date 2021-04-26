package structure.component;

/**
 * @author zhaopc
 * @date 2021/4/26 22:36
 */
public class Client {

    public static void main(String[] args) {
        Employee e1 = new Employee(1L, 3000L);
        Employee e2 = new Employee(2L, 5000L);
        Employee e3 = new Employee(3L, 6000L);
        Employee e4 = new Employee(4L, 3000L);
        Employee e5 = new Employee(5L, 5000L);

        Department d1 = new Department(1L);
        d1.addNode(e1);
        d1.addNode(e2);
        d1.addNode(e3);

        Department d2 = new Department(2L);
        d2.addNode(e4);
        d2.addNode(e5);

        Department root = new Department(0L);
        root.addNode(d1);
        root.addNode(d2);
        root.calculateSalary();
    }
}
