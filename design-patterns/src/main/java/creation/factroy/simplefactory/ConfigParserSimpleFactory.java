package creation.factroy.simplefactory;

import creation.factroy.ISystemConfigParser;
import creation.factroy.JsonSystemConfigParser;
import creation.factroy.XmlSystemConfigParser;
import creation.factroy.YamlSystemConfigParser;

/**
 * @author zhaopc
 * @date 2021/4/18 14:34
 */
public class ConfigParserSimpleFactory {

    public static final String JSON = "json";
    public static final String XML = "xml";
    public static final String YAML = "yaml";

    public static ISystemConfigParser getConfigParser(String configType) {
        if (JSON.equals(configType)) {
            return new JsonSystemConfigParser();
        } else if (XML.equals(configType)) {
            return new XmlSystemConfigParser();
        } else if (YAML.equals(configType)) {
            return new YamlSystemConfigParser();
        } else {
            return null;
        }
    }
}
