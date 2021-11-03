package com.kakaofriends.core.domain;

import java.util.Date;

@Deprecated
public class Stock {
    private Long stSeq;

    private String stPrcode;

    private String stOwnerid;

    private Long stEa;

    private Long stInea;

    private Long stFaultyea;

    private Long stSafeea;

    private Long stEtcea1;

    private Long stEtcea2;

    private String stMoid;

    private String stInid;

    private Date stModate;

    private Date stIndate;

    public Long getStSeq() {
        return stSeq;
    }

    public void setStSeq(Long stSeq) {
        this.stSeq = stSeq;
    }

    public String getStPrcode() {
        return stPrcode;
    }

    public void setStPrcode(String stPrcode) {
        this.stPrcode = stPrcode == null ? null : stPrcode.trim();
    }

    public String getStOwnerid() {
        return stOwnerid;
    }

    public void setStOwnerid(String stOwnerid) {
        this.stOwnerid = stOwnerid == null ? null : stOwnerid.trim();
    }

    public Long getStEa() {
        return stEa;
    }

    public void setStEa(Long stEa) {
        this.stEa = stEa;
    }

    public Long getStInea() {
        return stInea;
    }

    public void setStInea(Long stInea) {
        this.stInea = stInea;
    }

    public Long getStFaultyea() {
        return stFaultyea;
    }

    public void setStFaultyea(Long stFaultyea) {
        this.stFaultyea = stFaultyea;
    }

    public Long getStSafeea() {
        return stSafeea;
    }

    public void setStSafeea(Long stSafeea) {
        this.stSafeea = stSafeea;
    }

    public Long getStEtcea1() {
        return stEtcea1;
    }

    public void setStEtcea1(Long stEtcea1) {
        this.stEtcea1 = stEtcea1;
    }

    public Long getStEtcea2() {
        return stEtcea2;
    }

    public void setStEtcea2(Long stEtcea2) {
        this.stEtcea2 = stEtcea2;
    }

    public String getStMoid() {
        return stMoid;
    }

    public void setStMoid(String stMoid) {
        this.stMoid = stMoid == null ? null : stMoid.trim();
    }

    public String getStInid() {
        return stInid;
    }

    public void setStInid(String stInid) {
        this.stInid = stInid == null ? null : stInid.trim();
    }

    public Date getStModate() {
        return stModate;
    }

    public void setStModate(Date stModate) {
        this.stModate = stModate;
    }

    public Date getStIndate() {
        return stIndate;
    }

    public void setStIndate(Date stIndate) {
        this.stIndate = stIndate;
    }
}