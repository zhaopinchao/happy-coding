package creation.factroy.factorymethod;

import creation.factroy.ISystemConfigParser;
import creation.factroy.JsonSystemConfigParser;

/**
 * @author zhaopc
 * @date 2021/4/18 15:15
 */
public class JsonConfigParserFactory implements ConfigParserFactory {

    @Override
    public ISystemConfigParser createConfigParser() {
        return new JsonSystemConfigParser();
    }
}
