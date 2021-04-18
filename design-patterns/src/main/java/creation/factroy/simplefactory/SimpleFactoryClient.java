package creation.factroy.simplefactory;

import creation.factroy.SystemConfig;
import creation.factroy.ISystemConfigParser;

import java.util.Objects;

/**
 * @author zhaopc
 * @date 2021/4/18 14:37
 */
public class SimpleFactoryClient {

    public static void main(String[] args) {
        String configType = ConfigParserSimpleFactory.JSON;
        String path = "config.json";
        ISystemConfigParser systemConfigParser = ConfigParserSimpleFactory.getConfigParser(configType);
        if(Objects.isNull(systemConfigParser)) {
            throw new RuntimeException("config parser cannot be null");
        }
        SystemConfig systemConfig = systemConfigParser.parse(path);
    }
}
