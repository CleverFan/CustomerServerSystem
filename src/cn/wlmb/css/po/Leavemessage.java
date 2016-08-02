package cn.wlmb.css.po;

import java.util.Date;

public class Leavemessage {
    private Long msgnum;

    private String chatid;

    private String serverid;

    private String customerid;

    private Date createtime;

    public Long getMsgnum() {
        return msgnum;
    }

    public void setMsgnum(Long msgnum) {
        this.msgnum = msgnum;
    }

    public String getChatid() {
        return chatid;
    }

    public void setChatid(String chatid) {
        this.chatid = chatid == null ? null : chatid.trim();
    }

    public String getServerid() {
        return serverid;
    }

    public void setServerid(String serverid) {
        this.serverid = serverid == null ? null : serverid.trim();
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}