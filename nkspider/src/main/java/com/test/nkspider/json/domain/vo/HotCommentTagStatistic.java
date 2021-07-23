package com.test.nkspider.json.domain.vo;

public class HotCommentTagStatistic {
    private String id;
    private String name;
    private long count;
    private long type;
    private boolean canBeFiltered;
    private long stand;
    private String rid;
    private String ckeKeyWordBury;

    @Override
    public String toString() {
        return "HotCommentTagStatistic{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", type=" + type +
                ", canBeFiltered=" + canBeFiltered +
                ", stand=" + stand +
                ", rid='" + rid + '\'' +
                ", ckeKeyWordBury='" + ckeKeyWordBury + '\'' +
                '}';
    }

    public HotCommentTagStatistic() {
    }

    public HotCommentTagStatistic(String id, String name, long count, long type, boolean canBeFiltered, long stand, String rid, String ckeKeyWordBury) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.type = type;
        this.canBeFiltered = canBeFiltered;
        this.stand = stand;
        this.rid = rid;
        this.ckeKeyWordBury = ckeKeyWordBury;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public boolean isCanBeFiltered() {
        return canBeFiltered;
    }

    public void setCanBeFiltered(boolean canBeFiltered) {
        this.canBeFiltered = canBeFiltered;
    }

    public long getStand() {
        return stand;
    }

    public void setStand(long stand) {
        this.stand = stand;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCkeKeyWordBury() {
        return ckeKeyWordBury;
    }

    public void setCkeKeyWordBury(String ckeKeyWordBury) {
        this.ckeKeyWordBury = ckeKeyWordBury;
    }
}
