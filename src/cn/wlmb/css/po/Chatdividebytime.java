package cn.wlmb.css.po;

public class Chatdividebytime {
    private Long chatmsgnum;

    private String hours;

    private String date;

    public Long getChatmsgnum() {
        return chatmsgnum;
    }

    public void setChatmsgnum(Long chatmsgnum) {
        this.chatmsgnum = chatmsgnum;
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