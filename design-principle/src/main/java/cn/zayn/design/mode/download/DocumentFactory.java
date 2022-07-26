package cn.zayn.design.mode.download;

public class DocumentFactory {

    HtmlDownloader downloader;

    public DocumentFactory(HtmlDownloader downloader) {
        this.downloader = downloader;
    }

    public Document createDoc(String url) {
        Html html = downloader.downloadHtml(url);
        return new Document(url, html);
    }
}
