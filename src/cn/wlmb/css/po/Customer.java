package cn.wlmb.css.po;

import java.util.Date;

public class Customer {
    private String customerid;

    private String ip;

    private String location;

    private Integer state;

    private Date cuCreatime;

    private String serverid;

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCuCreatime() {
        return cuCreatime;
    }

    public void setCuCreatime(Date cuCreatime) {
        this.cuCreatime = cuCreatime;
    }

    public String getServerid() {
        return serverid;
    }

    public void setServerid(String serverid) {
        this.serverid = serverid == null ? null : serverid.trim();
    }
}