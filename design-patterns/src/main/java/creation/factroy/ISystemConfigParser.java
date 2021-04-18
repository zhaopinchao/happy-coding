package creation.factroy;

/**
 * 配置解析
 *
 * @author zhaopc
 * @date 2021/4/18 14:27
 */
public interface ISystemConfigParser {

    /**
     * 解析系统配置文件
     *
     * @param path 文件路径
     * @return Config
     */
    SystemConfig parse(String path);
}
