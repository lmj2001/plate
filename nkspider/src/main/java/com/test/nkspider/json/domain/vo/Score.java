package com.test.nkspider.json.domain.vo;

public class Score {
    private long chinese;
    private long math;
    private long english;

    @Override
    public String toString() {
        return "Score{" +
                "chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                '}';
    }

    public Score() {
    }

    public Score(long chinese, long math, long english) {
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public long getChinese() {
        return chinese;
    }

    public void setChinese(long chinese) {
        this.chinese = chinese;
    }

    public long getMath() {
        return math;
    }

    public void setMath(long math) {
        this.math = math;
    }

    public long getEnglish() {
        return english;
    }

    public void setEnglish(long english) {
        this.english = english;
    }
}
