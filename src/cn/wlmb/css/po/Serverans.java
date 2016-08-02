package cn.wlmb.css.po;

public class Serverans {
    private String sanid;

    private String word;

    private String content;

    public String getSanid() {
        return sanid;
    }

    public void setSanid(String sanid) {
        this.sanid = sanid == null ? null : sanid.trim();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}