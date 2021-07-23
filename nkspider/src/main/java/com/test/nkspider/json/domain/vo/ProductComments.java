package com.test.nkspider.json.domain.vo;

import java.util.List;

public class ProductComments {
    private String productAttr;
    private List<ProductCommentSummary> productCommentSummary;
    private List<HotCommentTagStatistic> hotCommentTagStatistics;
    private String jwotestProduct;
    private long maxPage;
    private String testId;
    private long score;
    private long soType;
    private long imageListCount;
    private String vTagStatistics;
    private String csv;
    private List<Comment> comments;

    @Override
    public String toString() {
        return "ProductComments{" +
                "productAttr='" + productAttr + '\'' +
                ", productCommentSummary=" + productCommentSummary +
                ", hotCommentTagStatistics=" + hotCommentTagStatistics +
                ", jwotestProduct='" + jwotestProduct + '\'' +
                ", maxPage=" + maxPage +
                ", testId='" + testId + '\'' +
                ", score=" + score +
                ", soType=" + soType +
                ", imageListCount=" + imageListCount +
                ", vTagStatistics='" + vTagStatistics + '\'' +
                ", csv='" + csv + '\'' +
                ", comments=" + comments +
                '}';
    }

    public ProductComments() {
    }

    public ProductComments(String productAttr, List<ProductCommentSummary> productCommentSummary, List<HotCommentTagStatistic> hotCommentTagStatistics, String jwotestProduct, long maxPage, String testId, long score, long soType, long imageListCount, String vTagStatistics, String csv, List<Comment> comments) {
        this.productAttr = productAttr;
        this.productCommentSummary = productCommentSummary;
        this.hotCommentTagStatistics = hotCommentTagStatistics;
        this.jwotestProduct = jwotestProduct;
        this.maxPage = maxPage;
        this.testId = testId;
        this.score = score;
        this.soType = soType;
        this.imageListCount = imageListCount;
        this.vTagStatistics = vTagStatistics;
        this.csv = csv;
        this.comments = comments;
    }

    public String getProductAttr() {
        return productAttr;
    }

    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }

    public List<ProductCommentSummary> getProductCommentSummary() {
        return productCommentSummary;
    }

    public void setProductCommentSummary(List<ProductCommentSummary> productCommentSummary) {
        this.productCommentSummary = productCommentSummary;
    }

    public List<HotCommentTagStatistic> getHotCommentTagStatistics() {
        return hotCommentTagStatistics;
    }

    public void setHotCommentTagStatistics(List<HotCommentTagStatistic> hotCommentTagStatistics) {
        this.hotCommentTagStatistics = hotCommentTagStatistics;
    }

    public String getJwotestProduct() {
        return jwotestProduct;
    }

    public void setJwotestProduct(String jwotestProduct) {
        this.jwotestProduct = jwotestProduct;
    }

    public long getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(long maxPage) {
        this.maxPage = maxPage;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getSoType() {
        return soType;
    }

    public void setSoType(long soType) {
        this.soType = soType;
    }

    public long getImageListCount() {
        return imageListCount;
    }

    public void setImageListCount(long imageListCount) {
        this.imageListCount = imageListCount;
    }

    public String getvTagStatistics() {
        return vTagStatistics;
    }

    public void setvTagStatistics(String vTagStatistics) {
        this.vTagStatistics = vTagStatistics;
    }

    public String getCsv() {
        return csv;
    }

    public void setCsv(String csv) {
        this.csv = csv;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
