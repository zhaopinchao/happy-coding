package creation.simplefactory;

import creation.ConfigParser;
import creation.JsonConfigParser;
import creation.XmlConfigParser;
import creation.YamlConfigParser;

/**
 * @author zhaopc
 * @date 2021/4/18 14:34
 */
public class ConfigParserSimpleFactory {

    public static final String JSON = "json";
    public static final String XML = "xml";
    public static final String YAML = "yaml";

    public static ConfigParser getConfigParser(String configType) {
        if (JSON.equals(configType)) {
            return new JsonConfigParser();
        } else if (XML.equals(configType)) {
            return new XmlConfigParser();
        } else if (YAML.equals(configType)) {
            return new YamlConfigParser();
        } else {
            return null;
        }
    }
}
