package cn.zayn.design.mode.alert;

public class AlertContext {

    private Alert alert;

    private Notifier notifier;

    private AlertRule alertRule;

    public void init() {
        this.alert = new Alert();
        this.notifier = new DefaultNotify();
        this.alertRule = new AlertRule();
        alert.addHandler(new TpsHandler(notifier, alertRule));
    }

    public Alert getAlert() {
        return this.alert;
    }

}
