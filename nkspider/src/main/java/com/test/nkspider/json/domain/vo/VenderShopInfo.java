package com.test.nkspider.json.domain.vo;

public class VenderShopInfo {
    private long id;
    private String appName;
    private String title;
    private long venderId;

    @Override
    public String toString() {
        return "VenderShopInfo{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", title='" + title + '\'' +
                ", venderId=" + venderId +
                '}';
    }

    public VenderShopInfo() {
    }

    public VenderShopInfo(long id, String appName, String title, long venderId) {
        this.id = id;
        this.appName = appName;
        this.title = title;
        this.venderId = venderId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getVenderId() {
        return venderId;
    }

    public void setVenderId(long venderId) {
        this.venderId = venderId;
    }
}
