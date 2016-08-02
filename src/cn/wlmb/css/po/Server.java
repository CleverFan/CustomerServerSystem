package cn.wlmb.css.po;

import java.util.Date;

public class Server {
    private String serverid;

    private String name;

    private String headimg;

    private Integer state;

    private Date serCreatime;

    private Double mask;

    private Integer personnum;

    public String getServerid() {
        return serverid;
    }

    public void setServerid(String serverid) {
        this.serverid = serverid == null ? null : serverid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getSerCreatime() {
        return serCreatime;
    }

    public void setSerCreatime(Date serCreatime) {
        this.serCreatime = serCreatime;
    }

    public Double getMask() {
        return mask;
    }

    public void setMask(Double mask) {
        this.mask = mask;
    }

    public Integer getPersonnum() {
        return personnum;
    }

    public void setPersonnum(Integer personnum) {
        this.personnum = personnum;
    }
}