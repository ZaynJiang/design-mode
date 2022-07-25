package cn.zayn.design.mode.transport;

import javax.xml.ws.Response;

public class Demo {
    public void demoFunction(Transporter transporter) {
        Request request = new Request();
        //... 省略设置 request 中数据值的代码...
        Response response = transporter.sendRequest(request);
        //... 省略其他逻辑...
    }

    public static void main(String[] args) {
// 里式替换原则
        Demo demo = new Demo();
        demo.demoFunction(new SecurityTransporter(null, null, null));

    }
}
