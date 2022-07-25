package cn.zayn.design.mode.alert;

import java.util.ArrayList;
import java.util.List;

public class Alert {

    private List<AlertHandler> handlers;

    public Alert() {
        this.handlers = new ArrayList<>();
    }

    public void addHandler(AlertHandler alertHandler) {
        this.handlers.add(alertHandler);
    }

    public void doHandle(ApiStatInfo apiStatInfo) {
        handlers.stream().forEach(alertHandler -> alertHandler.doHandle(apiStatInfo));
    }

}
