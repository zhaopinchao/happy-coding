package creation.factroy;

import creation.factroy.abstractfactory.IRedisConfigParser;
import creation.factroy.abstractfactory.YamlRedisConfigParser;

/**
 * @author zhaopc
 * @date 2021/4/18 15:16
 */
public class YamlConfigParserFactory implements ConfigParserFactory {

    @Override
    public ISystemConfigParser createSystemConfigParser() {
        return new YamlSystemConfigParser();
    }

    @Override
    public IRedisConfigParser createRedisConfigParser() {
        return new YamlRedisConfigParser();
    }
}
