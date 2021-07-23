package com.test.nkspider.json.domain.vo;

public class ProductCommentSummary {
    private long skuId;
    private long averageScore;
    private long defaultGoodCount;
    private String defaultGoodCountStr;
    private long commentCount;
    private String commentCountStr;
    private long goodCount;
    private String goodCountStr;
    private double goodRate;
    private long goodRateShow;
    private long generalCount;
    private String generalCountStr;
    private double generalRate;
    private long generalRateShow;
    private long poorCount;
    private String poorCountStr;
    private double poorRate;
    private long poorRateShow;
    private long videoCount;
    private String videoCountStr;
    private long afterCount;
    private String afterCountStr;
    private long showCount;
    private String showCountStr;
    private long oneYear;
    private long sensitiveBook;
    private long fixCount;
    private long plusCount;
    private String plusCountStr;
    private long buyerShow;
    private long poorRateStyle;
    private long generalRateStyle;
    private long goodRateStyle;
    private long installRate;
    private long productId;
    private long score1Count;
    private long score2Count;
    private long score3Count;
    private long score4Count;
    private long score5Count;

    @Override
    public String toString() {
        return "ProductCommentSummary{" +
                "skuId=" + skuId +
                ", averageScore=" + averageScore +
                ", defaultGoodCount=" + defaultGoodCount +
                ", defaultGoodCountStr='" + defaultGoodCountStr + '\'' +
                ", commentCount=" + commentCount +
                ", commentCountStr='" + commentCountStr + '\'' +
                ", goodCount=" + goodCount +
                ", goodCountStr='" + goodCountStr + '\'' +
                ", goodRate=" + goodRate +
                ", goodRateShow=" + goodRateShow +
                ", generalCount=" + generalCount +
                ", generalCountStr='" + generalCountStr + '\'' +
                ", generalRate=" + generalRate +
                ", generalRateShow=" + generalRateShow +
                ", poorCount=" + poorCount +
                ", poorCountStr='" + poorCountStr + '\'' +
                ", poorRate=" + poorRate +
                ", poorRateShow=" + poorRateShow +
                ", videoCount=" + videoCount +
                ", videoCountStr='" + videoCountStr + '\'' +
                ", afterCount=" + afterCount +
                ", afterCountStr='" + afterCountStr + '\'' +
                ", showCount=" + showCount +
                ", showCountStr='" + showCountStr + '\'' +
                ", oneYear=" + oneYear +
                ", sensitiveBook=" + sensitiveBook +
                ", fixCount=" + fixCount +
                ", plusCount=" + plusCount +
                ", plusCountStr='" + plusCountStr + '\'' +
                ", buyerShow=" + buyerShow +
                ", poorRateStyle=" + poorRateStyle +
                ", generalRateStyle=" + generalRateStyle +
                ", goodRateStyle=" + goodRateStyle +
                ", installRate=" + installRate +
                ", productId=" + productId +
                ", score1Count=" + score1Count +
                ", score2Count=" + score2Count +
                ", score3Count=" + score3Count +
                ", score4Count=" + score4Count +
                ", score5Count=" + score5Count +
                '}';
    }

    public ProductCommentSummary() {
    }

    public ProductCommentSummary(long skuId, long averageScore, long defaultGoodCount, String defaultGoodCountStr, long commentCount, String commentCountStr, long goodCount, String goodCountStr, double goodRate, long goodRateShow, long generalCount, String generalCountStr, double generalRate, long generalRateShow, long poorCount, String poorCountStr, double poorRate, long poorRateShow, long videoCount, String videoCountStr, long afterCount, String afterCountStr, long showCount, String showCountStr, long oneYear, long sensitiveBook, long fixCount, long plusCount, String plusCountStr, long buyerShow, long poorRateStyle, long generalRateStyle, long goodRateStyle, long installRate, long productId, long score1Count, long score2Count, long score3Count, long score4Count, long score5Count) {
        this.skuId = skuId;
        this.averageScore = averageScore;
        this.defaultGoodCount = defaultGoodCount;
        this.defaultGoodCountStr = defaultGoodCountStr;
        this.commentCount = commentCount;
        this.commentCountStr = commentCountStr;
        this.goodCount = goodCount;
        this.goodCountStr = goodCountStr;
        this.goodRate = goodRate;
        this.goodRateShow = goodRateShow;
        this.generalCount = generalCount;
        this.generalCountStr = generalCountStr;
        this.generalRate = generalRate;
        this.generalRateShow = generalRateShow;
        this.poorCount = poorCount;
        this.poorCountStr = poorCountStr;
        this.poorRate = poorRate;
        this.poorRateShow = poorRateShow;
        this.videoCount = videoCount;
        this.videoCountStr = videoCountStr;
        this.afterCount = afterCount;
        this.afterCountStr = afterCountStr;
        this.showCount = showCount;
        this.showCountStr = showCountStr;
        this.oneYear = oneYear;
        this.sensitiveBook = sensitiveBook;
        this.fixCount = fixCount;
        this.plusCount = plusCount;
        this.plusCountStr = plusCountStr;
        this.buyerShow = buyerShow;
        this.poorRateStyle = poorRateStyle;
        this.generalRateStyle = generalRateStyle;
        this.goodRateStyle = goodRateStyle;
        this.installRate = installRate;
        this.productId = productId;
        this.score1Count = score1Count;
        this.score2Count = score2Count;
        this.score3Count = score3Count;
        this.score4Count = score4Count;
        this.score5Count = score5Count;
    }

    public long getSkuId() {
        return skuId;
    }

    public void setSkuId(long skuId) {
        this.skuId = skuId;
    }

    public long getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(long averageScore) {
        this.averageScore = averageScore;
    }

    public long getDefaultGoodCount() {
        return defaultGoodCount;
    }

    public void setDefaultGoodCount(long defaultGoodCount) {
        this.defaultGoodCount = defaultGoodCount;
    }

    public String getDefaultGoodCountStr() {
        return defaultGoodCountStr;
    }

    public void setDefaultGoodCountStr(String defaultGoodCountStr) {
        this.defaultGoodCountStr = defaultGoodCountStr;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

    public String getCommentCountStr() {
        return commentCountStr;
    }

    public void setCommentCountStr(String commentCountStr) {
        this.commentCountStr = commentCountStr;
    }

    public long getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(long goodCount) {
        this.goodCount = goodCount;
    }

    public String getGoodCountStr() {
        return goodCountStr;
    }

    public void setGoodCountStr(String goodCountStr) {
        this.goodCountStr = goodCountStr;
    }

    public double getGoodRate() {
        return goodRate;
    }

    public void setGoodRate(double goodRate) {
        this.goodRate = goodRate;
    }

    public long getGoodRateShow() {
        return goodRateShow;
    }

    public void setGoodRateShow(long goodRateShow) {
        this.goodRateShow = goodRateShow;
    }

    public long getGeneralCount() {
        return generalCount;
    }

    public void setGeneralCount(long generalCount) {
        this.generalCount = generalCount;
    }

    public String getGeneralCountStr() {
        return generalCountStr;
    }

    public void setGeneralCountStr(String generalCountStr) {
        this.generalCountStr = generalCountStr;
    }

    public double getGeneralRate() {
        return generalRate;
    }

    public void setGeneralRate(double generalRate) {
        this.generalRate = generalRate;
    }

    public long getGeneralRateShow() {
        return generalRateShow;
    }

    public void setGeneralRateShow(long generalRateShow) {
        this.generalRateShow = generalRateShow;
    }

    public long getPoorCount() {
        return poorCount;
    }

    public void setPoorCount(long poorCount) {
        this.poorCount = poorCount;
    }

    public String getPoorCountStr() {
        return poorCountStr;
    }

    public void setPoorCountStr(String poorCountStr) {
        this.poorCountStr = poorCountStr;
    }

    public double getPoorRate() {
        return poorRate;
    }

    public void setPoorRate(double poorRate) {
        this.poorRate = poorRate;
    }

    public long getPoorRateShow() {
        return poorRateShow;
    }

    public void setPoorRateShow(long poorRateShow) {
        this.poorRateShow = poorRateShow;
    }

    public long getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(long videoCount) {
        this.videoCount = videoCount;
    }

    public String getVideoCountStr() {
        return videoCountStr;
    }

    public void setVideoCountStr(String videoCountStr) {
        this.videoCountStr = videoCountStr;
    }

    public long getAfterCount() {
        return afterCount;
    }

    public void setAfterCount(long afterCount) {
        this.afterCount = afterCount;
    }

    public String getAfterCountStr() {
        return afterCountStr;
    }

    public void setAfterCountStr(String afterCountStr) {
        this.afterCountStr = afterCountStr;
    }

    public long getShowCount() {
        return showCount;
    }

    public void setShowCount(long showCount) {
        this.showCount = showCount;
    }

    public String getShowCountStr() {
        return showCountStr;
    }

    public void setShowCountStr(String showCountStr) {
        this.showCountStr = showCountStr;
    }

    public long getOneYear() {
        return oneYear;
    }

    public void setOneYear(long oneYear) {
        this.oneYear = oneYear;
    }

    public long getSensitiveBook() {
        return sensitiveBook;
    }

    public void setSensitiveBook(long sensitiveBook) {
        this.sensitiveBook = sensitiveBook;
    }

    public long getFixCount() {
        return fixCount;
    }

    public void setFixCount(long fixCount) {
        this.fixCount = fixCount;
    }

    public long getPlusCount() {
        return plusCount;
    }

    public void setPlusCount(long plusCount) {
        this.plusCount = plusCount;
    }

    public String getPlusCountStr() {
        return plusCountStr;
    }

    public void setPlusCountStr(String plusCountStr) {
        this.plusCountStr = plusCountStr;
    }

    public long getBuyerShow() {
        return buyerShow;
    }

    public void setBuyerShow(long buyerShow) {
        this.buyerShow = buyerShow;
    }

    public long getPoorRateStyle() {
        return poorRateStyle;
    }

    public void setPoorRateStyle(long poorRateStyle) {
        this.poorRateStyle = poorRateStyle;
    }

    public long getGeneralRateStyle() {
        return generalRateStyle;
    }

    public void setGeneralRateStyle(long generalRateStyle) {
        this.generalRateStyle = generalRateStyle;
    }

    public long getGoodRateStyle() {
        return goodRateStyle;
    }

    public void setGoodRateStyle(long goodRateStyle) {
        this.goodRateStyle = goodRateStyle;
    }

    public long getInstallRate() {
        return installRate;
    }

    public void setInstallRate(long installRate) {
        this.installRate = installRate;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getScore1Count() {
        return score1Count;
    }

    public void setScore1Count(long score1Count) {
        this.score1Count = score1Count;
    }

    public long getScore2Count() {
        return score2Count;
    }

    public void setScore2Count(long score2Count) {
        this.score2Count = score2Count;
    }

    public long getScore3Count() {
        return score3Count;
    }

    public void setScore3Count(long score3Count) {
        this.score3Count = score3Count;
    }

    public long getScore4Count() {
        return score4Count;
    }

    public void setScore4Count(long score4Count) {
        this.score4Count = score4Count;
    }

    public long getScore5Count() {
        return score5Count;
    }

    public void setScore5Count(long score5Count) {
        this.score5Count = score5Count;
    }
}
