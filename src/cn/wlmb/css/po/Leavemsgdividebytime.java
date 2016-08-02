package cn.wlmb.css.po;

public class Leavemsgdividebytime {
    private Long leavemsgnum;

    private String hours;

    private String date;

    public Long getLeavemsgnum() {
        return leavemsgnum;
    }

    public void setLeavemsgnum(Long leavemsgnum) {
        this.leavemsgnum = leavemsgnum;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours == null ? null : hours.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }
}