package com.test.nkspider.json.domain.vo;

public class Video {
    private long id;
    private String mainUrl;
    private long videoHeight;
    private long videoWidth;
    private long videoLength;
    private String videoTitle;
    private long videoUrl;
    private long videoId;
    private long status;
    private String remark;

    public Video() {
    }

    public Video(long id, String mainUrl, long videoHeight, long videoWidth, long videoLength, String videoTitle, long videoUrl, long videoId, long status, String remark) {
        this.id = id;
        this.mainUrl = mainUrl;
        this.videoHeight = videoHeight;
        this.videoWidth = videoWidth;
        this.videoLength = videoLength;
        this.videoTitle = videoTitle;
        this.videoUrl = videoUrl;
        this.videoId = videoId;
        this.status = status;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", mainUrl='" + mainUrl + '\'' +
                ", videoHeight=" + videoHeight +
                ", videoWidth=" + videoWidth +
                ", videoLength=" + videoLength +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoUrl=" + videoUrl +
                ", videoId=" + videoId +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMainUrl() {
        return mainUrl;
    }

    public void setMainUrl(String mainUrl) {
        this.mainUrl = mainUrl;
    }

    public long getVideoHeight() {
        return videoHeight;
    }

    public void setVideoHeight(long videoHeight) {
        this.videoHeight = videoHeight;
    }

    public long getVideoWidth() {
        return videoWidth;
    }

    public void setVideoWidth(long videoWidth) {
        this.videoWidth = videoWidth;
    }

    public long getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(long videoLength) {
        this.videoLength = videoLength;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public long getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(long videoUrl) {
        this.videoUrl = videoUrl;
    }

    public long getVideoId() {
        return videoId;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
