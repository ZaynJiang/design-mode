package cn.zayn.design.mode.download;

public class HtmlDownloader {

    NetworkTransport networkTransport;

    public HtmlDownloader(NetworkTransport networkTransport) {
        this.networkTransport = networkTransport;
    }


    // HtmlDownloader 这里也要有相应的修改
    public Html downloadHtml(String url) {
        HtmlRequest htmlRequest = new HtmlRequest(url);
        Byte[] rawHtml = networkTransport.send(
                htmlRequest.getAddress(), htmlRequest.getContent().getBytes());
        return new Html(rawHtml);
    }
}
