package com.hr.unipu.MassaBassa;
public class ManualVideoItem {
    private String title;
    private String description;
    private String url;
    private String thumbnailUrl;
    public ManualVideoItem(String title, String description, String url, String thumbnailUrl) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getUrl() {
        return url;
    }
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}