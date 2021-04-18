package creation.factroy.abstractfactory;

import creation.factroy.SystemConfig;
import creation.factroy.ISystemConfigParser;
import creation.factroy.ConfigParserFactory;
import creation.factroy.JsonConfigParserFactory;

/**
 * @author zhaopc
 * @date 2021/4/18 15:18
 */
public class AbstractFactoryClient {

    public static void main(String[] args) {
        String systemConfigPath = "system-config.json";
        String redisConfigPath = "redis-config.json";
        ConfigParserFactory factory = new JsonConfigParserFactory();
        ISystemConfigParser systemConfigParser = factory.createSystemConfigParser();
        SystemConfig systemConfig = systemConfigParser.parse(systemConfigPath);
        IRedisConfigParser redisConfigParser = factory.createRedisConfigParser();
        RedisConfig redisConfig = redisConfigParser.parse(redisConfigPath);
    }
}
