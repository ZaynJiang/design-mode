package cn.zayn.design.mode.alert;

public class TpsHandler implements AlertHandler {

    private Notifier notifier;

    private AlertRule alertRule;

    public TpsHandler(Notifier notifier, AlertRule alertRule) {
        this.notifier = notifier;
        this.alertRule = alertRule;
    }

    @Override
    public void doHandle(ApiStatInfo apiStatInfo) {
        if (alertRule.match()) {//do some other thing
            notifier.alertNotify();
        }
    }
}
