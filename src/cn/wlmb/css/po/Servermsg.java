package cn.wlmb.css.po;

import java.math.BigDecimal;

public class Servermsg {
    private String serverid;

    private Long msgnum;

    private BigDecimal servermsgnum;

    public String getServerid() {
        return serverid;
    }

    public void setServerid(String serverid) {
        this.serverid = serverid == null ? null : serverid.trim();
    }

    public Long getMsgnum() {
        return msgnum;
    }

    public void setMsgnum(Long msgnum) {
        this.msgnum = msgnum;
    }

    public BigDecimal getServermsgnum() {
        return servermsgnum;
    }

    public void setServermsgnum(BigDecimal servermsgnum) {
        this.servermsgnum = servermsgnum;
    }
}