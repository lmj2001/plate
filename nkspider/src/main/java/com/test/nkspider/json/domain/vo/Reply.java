package com.test.nkspider.json.domain.vo;

import java.util.List;

public class Reply {
    private long id;
    private long commentId;
    private String content;
    private String pin;
    private long userClient;
    private String userImage;
    private String ip;
    private long productId;
    private List<Reply> replyList;
    private String nickname;
    private String creationTime;
    private long parentId;
    private long targetId;
    private VenderShopInfo venderShopInfo;

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", commentId=" + commentId +
                ", content='" + content + '\'' +
                ", pin='" + pin + '\'' +
                ", userClient=" + userClient +
                ", userImage='" + userImage + '\'' +
                ", ip='" + ip + '\'' +
                ", productId=" + productId +
                ", replyList=" + replyList +
                ", nickname='" + nickname + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", parentId=" + parentId +
                ", targetId=" + targetId +
                ", venderShopInfo=" + venderShopInfo +
                '}';
    }

    public Reply() {
    }

    public Reply(long id, long commentId, String content, String pin, long userClient, String userImage, String ip, long productId, List<Reply> replyList, String nickname, String creationTime, long parentId, long targetId, VenderShopInfo venderShopInfo) {
        this.id = id;
        this.commentId = commentId;
        this.content = content;
        this.pin = pin;
        this.userClient = userClient;
        this.userImage = userImage;
        this.ip = ip;
        this.productId = productId;
        this.replyList = replyList;
        this.nickname = nickname;
        this.creationTime = creationTime;
        this.parentId = parentId;
        this.targetId = targetId;
        this.venderShopInfo = venderShopInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public long getUserClient() {
        return userClient;
    }

    public void setUserClient(long userClient) {
        this.userClient = userClient;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getTargetId() {
        return targetId;
    }

    public void setTargetId(long targetId) {
        this.targetId = targetId;
    }

    public VenderShopInfo getVenderShopInfo() {
        return venderShopInfo;
    }

    public void setVenderShopInfo(VenderShopInfo venderShopInfo) {
        this.venderShopInfo = venderShopInfo;
    }
}
