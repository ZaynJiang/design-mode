package cn.zayn.design.mode.serialize;

import com.google.gson.Gson;

import java.util.Map;

public class Serializer {

    private static final String IDENTIFIER_STRING = "UEUEUE;";
    private Gson gson;

    public Serializer() {
        this.gson = new Gson();
    }

    public String serialize(Map<String, String> object) {
        StringBuilder textBuilder = new StringBuilder();
        textBuilder.append(IDENTIFIER_STRING);
        textBuilder.append(gson.toJson(object));
        return textBuilder.toString();
    }


    /**
     *
     *
     * 虽然经过拆分之后，Serializer 类和 Deserializer 类的职责更加单一了，但也随之带来了新的问题。如果我们修改了协议的格式，数据标识从“UEUEUE”改为“DFDFDF”，
     * 或者序列化方式从 JSON 改为了 XML，那 Serializer 类和 Deserializer 类都需要做相应的修改，
     * 代码的内聚性显然没有原来 Serialization 高了。而且，如果我们仅仅对 Serializer 类做了协议修改，
     * 而忘记了修改 Deserializer 类的代码，那就会导致序列化、反序列化不匹配，程序运行出错，也就是说，拆分之后，代码的可维护性变差了。
     * 实际上，不管是应用设计原则还是设计模式，最终的目的还是提高代码的可读性、可扩展性、复用性、可维护性等。
     * 我们在考虑应用某一个设计原则是否合理的时候，也可以以此作为最终的考量标准
     *
     */

    /**
     *
     * 尽管拆分之后的代码更能满足迪米特法则，
     * 但却违背了高内聚的设计思想。高内聚要求相近的功能要放到同一个类中，
     * 这样可以方便功能修改的时候，修改的地方不至于过于分散。
     * 对于刚刚这个例子来说，如果我们修改了序列化的实现方式，比如从 JSON 换成了 XML，
     * 那反序列化的实现逻辑也需要一并修改。在未拆分的情况下，我们只需要修改一个类即可。
     * 在拆分之后，我们需要修改两个类。显然，这种设计思路的代码改动范围变大了。
     *
     *
     */
}
