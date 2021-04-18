package creation.factroy;

/**
 * @author zhaopc
 * @date 2021/4/18 14:32
 */
public class YamlSystemConfigParser implements ISystemConfigParser {

    @Override
    public SystemConfig parse(String path) {
        return new SystemConfig();
    }
}
