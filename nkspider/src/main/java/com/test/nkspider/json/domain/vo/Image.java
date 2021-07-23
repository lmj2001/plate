package com.test.nkspider.json.domain.vo;

public class Image {
    private long id;
    private String imgUrl;
    private String imgTitle;
    private long status;

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", imgTitle='" + imgTitle + '\'' +
                ", status=" + status +
                '}';
    }

    public Image(long id, String imgUrl, String imgTitle, long status) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.imgTitle = imgTitle;
        this.status = status;
    }

    public Image() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }
}
