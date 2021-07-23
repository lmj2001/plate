package com.test.nkspider.json.domain.vo;

import java.util.List;

public class pr {
    private String s;
    private String maxPage;
    private long score;
    private int soType;
    private String vTagStatistics;
    private String csv;

    @Override
    public String toString() {
        System.out.println("hhhhhhhhhhhh");
        return "ProductComments{" +
                "productAttr='" + s + '\'' +
                ", testId='" + maxPage + '\'' +
                ", score=" + score +
                ", imageListCount=" + soType +
                ", vTagStatistics='" + vTagStatistics + '\'' +
                ", csv='" + csv + '\'' +
                '}';
    }

    public pr() {
    }

    public pr(String productAttr, String testId, long score, int soType, String vTagStatistics, String csv) {
        this.s = productAttr;
        this.maxPage = testId;
        this.score = score;
        this.soType = soType;
        this.vTagStatistics = vTagStatistics;
        this.csv = csv;
    }

    public String getProductAttr() {
        return s;
    }

    public void setProductAttr(String productAttr) {
        this.s = productAttr;
    }


    public String getTestId() {
        return maxPage;
    }

    public void setTestId(String testId) {
        this.maxPage = testId;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }


    public long getImageListCount() {
        return soType;
    }

    public void setImageListCount(int imageListCount) {
        this.soType = imageListCount;
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

}
