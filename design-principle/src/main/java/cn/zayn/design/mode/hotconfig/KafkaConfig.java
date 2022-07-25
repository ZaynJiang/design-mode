package cn.zayn.design.mode.hotconfig;

import java.util.Map;

public class KafkaConfig extends Config implements Updater, Viewer{

    public KafkaConfig(ConfigSource configSource) {
        super(configSource);
    }

    @Override
    public void update() {

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
