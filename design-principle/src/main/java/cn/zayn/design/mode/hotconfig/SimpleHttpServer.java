package cn.zayn.design.mode.hotconfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleHttpServer {
    private String host;
    private int port;
    private Map<String, List<Viewer>> viewers = new HashMap<>();

    public SimpleHttpServer(String host, int port) {

    }

    public void addViewers(String urlDirectory, Viewer viewer) {
        this.viewers.computeIfAbsent(urlDirectory, x -> new ArrayList<>()).add(viewer);
    }


}
