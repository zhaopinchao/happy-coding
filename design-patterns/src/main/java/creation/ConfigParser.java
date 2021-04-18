package creation;

/**
 * 配置解析
 *
 * @author zhaopc
 * @date 2021/4/18 14:27
 */
public interface ConfigParser {

    /**
     * 解析配置文件
     *
     * @param path 文件路径
     * @return Config
     */
    Config parse(String path);
}
