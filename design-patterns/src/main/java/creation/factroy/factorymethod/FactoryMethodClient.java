package creation.factroy.factorymethod;

import creation.factroy.SystemConfig;
import creation.factroy.ISystemConfigParser;

/**
 * @author zhaopc
 * @date 2021/4/18 15:18
 */
public class FactoryMethodClient {

    public static void main(String[] args) {
        String path = "config.json";
        ConfigParserFactory factory = new JsonConfigParserFactory();
        ISystemConfigParser systemConfigParser = factory.createConfigParser();
        SystemConfig systemConfig = systemConfigParser.parse(path);
    }
}
