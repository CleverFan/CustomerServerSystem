package cn.wlmb.css.po;

public class Systemans {
    private String syanid;

    private String syword;

    private String sycontent;

    public String getSyanid() {
        return syanid;
    }

    public void setSyanid(String syanid) {
        this.syanid = syanid == null ? null : syanid.trim();
    }

    public String getSyword() {
        return syword;
    }

    public void setSyword(String syword) {
        this.syword = syword == null ? null : syword.trim();
    }

    public String getSycontent() {
        return sycontent;
    }

    public void setSycontent(String sycontent) {
        this.sycontent = sycontent == null ? null : sycontent.trim();
    }
}