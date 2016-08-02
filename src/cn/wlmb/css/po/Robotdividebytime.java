package cn.wlmb.css.po;

public class Robotdividebytime {
    private Long robotchatnum;

    private String hours;

    private String date;

    public Long getRobotchatnum() {
        return robotchatnum;
    }

    public void setRobotchatnum(Long robotchatnum) {
        this.robotchatnum = robotchatnum;
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