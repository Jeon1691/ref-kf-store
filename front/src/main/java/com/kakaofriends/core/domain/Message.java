package com.kakaofriends.core.domain;

import java.util.Date;

public class Message {
    private Long msSeq;

    private String msContents;

    private String msInid;

    private Date msIndate;

    private String msInname;

    public Long getMsSeq() {
        return msSeq;
    }

    public void setMsSeq(Long msSeq) {
        this.msSeq = msSeq;
    }

    public String getMsContents() {
        return msContents;
    }

    public void setMsContents(String msContents) {
        this.msContents = msContents == null ? null : msContents.trim();
    }

    public String getMsInid() {
        return msInid;
    }

    public void setMsInid(String msInid) {
        this.msInid = msInid == null ? null : msInid.trim();
    }

    public Date getMsIndate() {
        return msIndate;
    }

    public void setMsIndate(Date msIndate) {
        this.msIndate = msIndate;
    }

    public String getMsInname() {
        return msInname;
    }

    public void setMsInname(String msInname) {
        this.msInname = msInname == null ? null : msInname.trim();
    }
}