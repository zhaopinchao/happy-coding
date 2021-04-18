package creation.factroy.abstractfactory;

/**
 * @author zhaopc
 * @date 2021/4/18 15:58
 */
public interface IRedisConfigParser {

    /**
     * 解析redis配置文件
     *
     * @param path 文件路径
     * @return Config
     */
    RedisConfig parse(String path);
}
