package creation.factroy.factorymethod;

import creation.factroy.ISystemConfigParser;

/**
 * @author zhaopc
 * @date 2021/4/18 15:10
 */
public interface ConfigParserFactory {

    /**
     * 创建配置解析类
     *
     * @return ConfigParser
     */
    ISystemConfigParser createConfigParser();
}
