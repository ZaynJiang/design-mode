package cn.zayn.design.mode.alert;

public class AlertSingleInstance {

    private final static AlertContext alertContext = new AlertContext();

    public AlertSingleInstance() {
        alertContext.init();
    }

    public static AlertContext getInstance() {
        return alertContext;
    }

    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        // ... 省略设置 apiStatInfo 数据值的代码
        AlertSingleInstance.alertContext.getAlert().doHandle(apiStatInfo);
    }
}
