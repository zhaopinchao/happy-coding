package creation.factroy;

import creation.factroy.abstractfactory.IRedisConfigParser;

/**
 * @author zhaopc
 * @date 2021/4/18 15:10
 */
public interface ConfigParserFactory {

    /**
     * 创建系统配置解析类
     *
     * @return ConfigParser
     */
    ISystemConfigParser createSystemConfigParser();

    /**
     * 创建redis配置解析类
     *
     * @return IRedisConfigParser
     */
    IRedisConfigParser createRedisConfigParser();
}
