package creation.simplefactory;

import creation.Config;
import creation.ConfigParser;

import java.util.Objects;

/**
 * @author zhaopc
 * @date 2021/4/18 14:37
 */
public class SimpleFactoryClient {

    public static void main(String[] args) {
        String configType = ConfigParserSimpleFactory.JSON;
        String path = "config.json";
        ConfigParser configParser = ConfigParserSimpleFactory.getConfigParser(configType);
        if(Objects.isNull(configParser)) {
            throw new RuntimeException("config parser cannot be null");
        }
        Config config = configParser.parse(path);
    }
}
