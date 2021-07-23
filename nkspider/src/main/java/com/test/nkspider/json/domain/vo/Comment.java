package com.test.nkspider.json.domain.vo;

import java.util.Date;
import java.util.List;

public class Comment {
    private long id;
    private String guid;
    private String content;
    private Date creationTime;
    private boolean isDelete;
    private boolean isTop;
    private String userImageUrl;
    private long topped;
    private List<Reply> replies;
    private long replyCount;
    private long score;
    private long imageStatus;
    private String title;
    private long usefulVoteCount;
    private long userClient;
    private long discussionId;
    private long imageCount;
    private long anonymousFlag;
    private long plusAvailable;
    private String mobileVersion;
    private List<Image> images;
    private List<Video> videos;
    private long mergeOrderStatus;
    private String productColor;
    private String productSize;
    private long textlongegral;
    private long imagelongegral;
    private long status;
    private String referenceId;
    private String referenceTime;
    private String nickname;
    private long replyCount2;
    private String userImage;
    private long orderId;
    private long longegral;
    private String productSales;
    private String referenceImage;
    private String referenceName;
    private long firstCategory;
    private long secondCategory;
    private long thirdCategory;
    private String aesPin;
    private long days;
    private long afterDays;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", guid='" + guid + '\'' +
                ", content='" + content + '\'' +
                ", creationTime=" + creationTime +
                ", isDelete=" + isDelete +
                ", isTop=" + isTop +
                ", userImageUrl='" + userImageUrl + '\'' +
                ", topped=" + topped +
                ", replies=" + replies +
                ", replyCount=" + replyCount +
                ", score=" + score +
                ", imageStatus=" + imageStatus +
                ", title='" + title + '\'' +
                ", usefulVoteCount=" + usefulVoteCount +
                ", userClient=" + userClient +
                ", discussionId=" + discussionId +
                ", imageCount=" + imageCount +
                ", anonymousFlag=" + anonymousFlag +
                ", plusAvailable=" + plusAvailable +
                ", mobileVersion='" + mobileVersion + '\'' +
                ", images=" + images +
                ", videos=" + videos +
                ", mergeOrderStatus=" + mergeOrderStatus +
                ", productColor='" + productColor + '\'' +
                ", productSize='" + productSize + '\'' +
                ", textlongegral=" + textlongegral +
                ", imagelongegral=" + imagelongegral +
                ", status=" + status +
                ", referenceId='" + referenceId + '\'' +
                ", referenceTime='" + referenceTime + '\'' +
                ", nickname='" + nickname + '\'' +
                ", replyCount2=" + replyCount2 +
                ", userImage='" + userImage + '\'' +
                ", orderId=" + orderId +
                ", longegral=" + longegral +
                ", productSales='" + productSales + '\'' +
                ", referenceImage='" + referenceImage + '\'' +
                ", referenceName='" + referenceName + '\'' +
                ", firstCategory=" + firstCategory +
                ", secondCategory=" + secondCategory +
                ", thirdCategory=" + thirdCategory +
                ", aesPin='" + aesPin + '\'' +
                ", days=" + days +
                ", afterDays=" + afterDays +
                '}';
    }

    public Comment() {
    }

    public Comment(long id, String guid, String content, Date creationTime, boolean isDelete, boolean isTop, String userImageUrl, long topped, List<Reply> replies, long replyCount, long score, long imageStatus, String title, long usefulVoteCount, long userClient, long discussionId, long imageCount, long anonymousFlag, long plusAvailable, String mobileVersion, List<Image> images, List<Video> videos, long mergeOrderStatus, String productColor, String productSize, long textlongegral, long imagelongegral, long status, String referenceId, String referenceTime, String nickname, long replyCount2, String userImage, long orderId, long longegral, String productSales, String referenceImage, String referenceName, long firstCategory, long secondCategory, long thirdCategory, String aesPin, long days, long afterDays) {
        this.id = id;
        this.guid = guid;
        this.content = content;
        this.creationTime = creationTime;
        this.isDelete = isDelete;
        this.isTop = isTop;
        this.userImageUrl = userImageUrl;
        this.topped = topped;
        this.replies = replies;
        this.replyCount = replyCount;
        this.score = score;
        this.imageStatus = imageStatus;
        this.title = title;
        this.usefulVoteCount = usefulVoteCount;
        this.userClient = userClient;
        this.discussionId = discussionId;
        this.imageCount = imageCount;
        this.anonymousFlag = anonymousFlag;
        this.plusAvailable = plusAvailable;
        this.mobileVersion = mobileVersion;
        this.images = images;
        this.videos = videos;
        this.mergeOrderStatus = mergeOrderStatus;
        this.productColor = productColor;
        this.productSize = productSize;
        this.textlongegral = textlongegral;
        this.imagelongegral = imagelongegral;
        this.status = status;
        this.referenceId = referenceId;
        this.referenceTime = referenceTime;
        this.nickname = nickname;
        this.replyCount2 = replyCount2;
        this.userImage = userImage;
        this.orderId = orderId;
        this.longegral = longegral;
        this.productSales = productSales;
        this.referenceImage = referenceImage;
        this.referenceName = referenceName;
        this.firstCategory = firstCategory;
        this.secondCategory = secondCategory;
        this.thirdCategory = thirdCategory;
        this.aesPin = aesPin;
        this.days = days;
        this.afterDays = afterDays;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public long getTopped() {
        return topped;
    }

    public void setTopped(long topped) {
        this.topped = topped;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public long getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(long replyCount) {
        this.replyCount = replyCount;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(long imageStatus) {
        this.imageStatus = imageStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUsefulVoteCount() {
        return usefulVoteCount;
    }

    public void setUsefulVoteCount(long usefulVoteCount) {
        this.usefulVoteCount = usefulVoteCount;
    }

    public long getUserClient() {
        return userClient;
    }

    public void setUserClient(long userClient) {
        this.userClient = userClient;
    }

    public long getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(long discussionId) {
        this.discussionId = discussionId;
    }

    public long getImageCount() {
        return imageCount;
    }

    public void setImageCount(long imageCount) {
        this.imageCount = imageCount;
    }

    public long getAnonymousFlag() {
        return anonymousFlag;
    }

    public void setAnonymousFlag(long anonymousFlag) {
        this.anonymousFlag = anonymousFlag;
    }

    public long getPlusAvailable() {
        return plusAvailable;
    }

    public void setPlusAvailable(long plusAvailable) {
        this.plusAvailable = plusAvailable;
    }

    public String getMobileVersion() {
        return mobileVersion;
    }

    public void setMobileVersion(String mobileVersion) {
        this.mobileVersion = mobileVersion;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public long getMergeOrderStatus() {
        return mergeOrderStatus;
    }

    public void setMergeOrderStatus(long mergeOrderStatus) {
        this.mergeOrderStatus = mergeOrderStatus;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public long getTextlongegral() {
        return textlongegral;
    }

    public void setTextlongegral(long textlongegral) {
        this.textlongegral = textlongegral;
    }

    public long getImagelongegral() {
        return imagelongegral;
    }

    public void setImagelongegral(long imagelongegral) {
        this.imagelongegral = imagelongegral;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getReferenceTime() {
        return referenceTime;
    }

    public void setReferenceTime(String referenceTime) {
        this.referenceTime = referenceTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getReplyCount2() {
        return replyCount2;
    }

    public void setReplyCount2(long replyCount2) {
        this.replyCount2 = replyCount2;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getlongegral() {
        return longegral;
    }

    public void setlongegral(long longegral) {
        this.longegral = longegral;
    }

    public String getProductSales() {
        return productSales;
    }

    public void setProductSales(String productSales) {
        this.productSales = productSales;
    }

    public String getReferenceImage() {
        return referenceImage;
    }

    public void setReferenceImage(String referenceImage) {
        this.referenceImage = referenceImage;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public long getFirstCategory() {
        return firstCategory;
    }

    public void setFirstCategory(long firstCategory) {
        this.firstCategory = firstCategory;
    }

    public long getSecondCategory() {
        return secondCategory;
    }

    public void setSecondCategory(long secondCategory) {
        this.secondCategory = secondCategory;
    }

    public long getThirdCategory() {
        return thirdCategory;
    }

    public void setThirdCategory(long thirdCategory) {
        this.thirdCategory = thirdCategory;
    }

    public String getAesPin() {
        return aesPin;
    }

    public void setAesPin(String aesPin) {
        this.aesPin = aesPin;
    }

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    public long getAfterDays() {
        return afterDays;
    }

    public void setAfterDays(long afterDays) {
        this.afterDays = afterDays;
    }
}
