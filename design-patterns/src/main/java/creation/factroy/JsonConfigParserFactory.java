package creation.factroy;

import creation.factroy.abstractfactory.IRedisConfigParser;
import creation.factroy.abstractfactory.JsonRedisConfigParser;

/**
 * @author zhaopc
 * @date 2021/4/18 15:15
 */
public class JsonConfigParserFactory implements ConfigParserFactory {

    @Override
    public ISystemConfigParser createSystemConfigParser() {
        return new JsonSystemConfigParser();
    }

    @Override
    public IRedisConfigParser createRedisConfigParser() {
        return new JsonRedisConfigParser();
    }
}
