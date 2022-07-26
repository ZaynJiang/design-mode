package cn.zayn.design.mode.serialize.dimit;

/**
 * 只需要反序列化的class
 */
public class Demo1 {
    private Deserializer deserializer;

    public Demo1(Deserializer deserializer) {
        this.deserializer = deserializer;
    }
}
