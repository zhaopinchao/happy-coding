package structure.component;

/**
 * @author zhaopc
 * @date 2021/4/26 22:30
 */
public class Employee extends HumanResource{

    public Employee(Long id, Long salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public Long calculateSalary() {
        System.out.println("员工id:" + this.getId() + " 薪资:" + this.salary);
        return this.salary;
    }
}
