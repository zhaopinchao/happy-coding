package creation.factroy;

/**
 * @author zhaopc
 * @date 2021/4/18 14:31
 */
public class XmlSystemConfigParser implements ISystemConfigParser {

    @Override
    public SystemConfig parse(String path) {
        return new SystemConfig();
    }
}
