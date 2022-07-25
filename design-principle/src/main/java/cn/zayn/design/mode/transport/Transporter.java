package cn.zayn.design.mode.transport;

import sun.net.www.http.HttpClient;

import javax.xml.ws.Response;


public class Transporter {
    private HttpClient httpClient;

    public Transporter(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    public Response sendRequest(Request request) {
        // ...use httpClient to send request
        return null;
    }
}
