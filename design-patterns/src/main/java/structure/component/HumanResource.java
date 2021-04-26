package structure.component;

/**
 * @author zhaopc
 * @date 2021/4/26 22:28
 */
public abstract class HumanResource {

    private Long id;
    protected Long salary;

    public HumanResource(Long id) {
        this.id = id;
    }

    /**
     * 计算薪资
     *
     * @return
     */
    public abstract Long calculateSalary();

    public Long getId() {
        return id;
    }
}
