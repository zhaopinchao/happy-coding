package creation.factroy;

import creation.factroy.abstractfactory.IRedisConfigParser;
import creation.factroy.abstractfactory.XmlRedisConfigParser;

/**
 * @author zhaopc
 * @date 2021/4/18 15:16
 */
public class XmlConfigParserFactory implements ConfigParserFactory {

    @Override
    public ISystemConfigParser createSystemConfigParser() {
        return new XmlSystemConfigParser();
    }

    @Override
    public IRedisConfigParser createRedisConfigParser() {
        return new XmlRedisConfigParser();
    }
}
