package cn.zayn.design.mode.hotconfig;

import java.util.Map;

public interface Viewer {
    String outputInPlainText();

    Map<String, String> output();
}
