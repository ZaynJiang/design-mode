package cn.zayn.design.mode.serialize.dimit;

/**
 * public class Serializer { // 参看 JSON 的接口定义
 *   public String serialize(Object object) { //... }
 *   public String serializeMap(Map map) { //... }
 *   public String serializeList(List list) { //... }
 *
 *   public Object deserialize(String objectString) { //... }
 *   public Map deserializeMap(String mapString) { //... }
 *   public List deserializeList(String listString) { //... }
 * }
 * 这种就有必要拆成两种不通的接口了
 */
public class Serialization implements Deserializer, Serializable{
    @Override
    public Object deserialize(String text) {
        return null;
    }

    @Override
    public String serialize(Object object) {
        return null;
    }
}
