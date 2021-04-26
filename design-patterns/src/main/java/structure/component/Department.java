package structure.component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaopc
 * @date 2021/4/26 22:33
 */
public class Department extends HumanResource {

    public Department(Long id) {
        super(id);
    }

    private List<HumanResource> hrs = new ArrayList<>();

    public void addNode(HumanResource hr) {
        hrs.add(hr);
    }

    @Override
    public Long calculateSalary() {
        Long salary = 0L;
        for (HumanResource hr : hrs) {
            salary += hr.calculateSalary();
        }
        this.salary = salary;
        System.out.println("部门id:" + this.getId() + " 薪资:" + this.salary);
        return salary;
    }
}
