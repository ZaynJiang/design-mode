package cn.zayn.design.mode.hotconfig;

import java.util.Map;

public class RedisConfig  extends Config implements Updater, Viewer{

    private ConfigSource configSource; // 配置中心（比如 zookeeper）

    public RedisConfig(ConfigSource configSource) {
        super(configSource);
    }

    @Override
    public void update() {
        //do some thing
    }

    @Override
    public String outputInPlainText() {
        return null;
    }

    @Override
    public Map<String, String> output() {
        return null;
    }
}
