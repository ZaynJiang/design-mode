package cn.zayn.design.mode.transport;

import sun.net.www.http.HttpClient;

import javax.xml.ws.Response;

public class SecurityTransporter extends Transporter {
    private String appId;
    private String appToken;
    public SecurityTransporter(HttpClient httpClient, String appId, String appToken) {
        super(httpClient);
        this.appId = appId;
        this.appToken = appToken;
    }
    @Override
    public Response sendRequest(Request request) {
        if (appId != null && appToken != null) {
            request.addPayload("app-id", appId);
            request.addPayload("app-token", appToken);
        }
        return super.sendRequest(request);
    }
}