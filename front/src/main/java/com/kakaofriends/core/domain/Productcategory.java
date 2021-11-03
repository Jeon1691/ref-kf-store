package com.kakaofriends.core.domain;

import java.util.Date;

@Deprecated
public class Productcategory {
    private Long prcSeq;

    private String prcPrcode;

    private Long prcCtseq;

    private String prcEtc1;

    private String prcEtc2;

    private String prcEtc3;

    private String prcEtc4;

    private String prcEtc5;

    private String prcEtc6;

    private String prcLevel;

    private String prcType;

    private String prcUse;

    private String prcMoid;

    private String prcInid;

    private Date prcModate;

    private Date prcIndate;

    public Long getPrcSeq() {
        return prcSeq;
    }

    public void setPrcSeq(Long prcSeq) {
        this.prcSeq = prcSeq;
    }

    public String getPrcPrcode() {
        return prcPrcode;
    }

    public void setPrcPrcode(String prcPrcode) {
        this.prcPrcode = prcPrcode == null ? null : prcPrcode.trim();
    }

    public Long getPrcCtseq() {
        return prcCtseq;
    }

    public void setPrcCtseq(Long prcCtseq) {
        this.prcCtseq = prcCtseq;
    }

    public String getPrcEtc1() {
        return prcEtc1;
    }

    public void setPrcEtc1(String prcEtc1) {
        this.prcEtc1 = prcEtc1 == null ? null : prcEtc1.trim();
    }

    public String getPrcEtc2() {
        return prcEtc2;
    }

    public void setPrcEtc2(String prcEtc2) {
        this.prcEtc2 = prcEtc2 == null ? null : prcEtc2.trim();
    }

    public String getPrcEtc3() {
        return prcEtc3;
    }

    public void setPrcEtc3(String prcEtc3) {
        this.prcEtc3 = prcEtc3 == null ? null : prcEtc3.trim();
    }

    public String getPrcEtc4() {
        return prcEtc4;
    }

    public void setPrcEtc4(String prcEtc4) {
        this.prcEtc4 = prcEtc4 == null ? null : prcEtc4.trim();
    }

    public String getPrcEtc5() {
        return prcEtc5;
    }

    public void setPrcEtc5(String prcEtc5) {
        this.prcEtc5 = prcEtc5 == null ? null : prcEtc5.trim();
    }

    public String getPrcEtc6() {
        return prcEtc6;
    }

    public void setPrcEtc6(String prcEtc6) {
        this.prcEtc6 = prcEtc6 == null ? null : prcEtc6.trim();
    }

    public String getPrcLevel() {
        return prcLevel;
    }

    public void setPrcLevel(String prcLevel) {
        this.prcLevel = prcLevel == null ? null : prcLevel.trim();
    }

    public String getPrcType() {
        return prcType;
    }

    public void setPrcType(String prcType) {
        this.prcType = prcType == null ? null : prcType.trim();
    }

    public String getPrcUse() {
        return prcUse;
    }

    public void setPrcUse(String prcUse) {
        this.prcUse = prcUse == null ? null : prcUse.trim();
    }

    public String getPrcMoid() {
        return prcMoid;
    }

    public void setPrcMoid(String prcMoid) {
        this.prcMoid = prcMoid == null ? null : prcMoid.trim();
    }

    public String getPrcInid() {
        return prcInid;
    }

    public void setPrcInid(String prcInid) {
        this.prcInid = prcInid == null ? null : prcInid.trim();
    }

    public Date getPrcModate() {
        return prcModate;
    }

    public void setPrcModate(Date prcModate) {
        this.prcModate = prcModate;
    }

    public Date getPrcIndate() {
        return prcIndate;
    }

    public void setPrcIndate(Date prcIndate) {
        this.prcIndate = prcIndate;
    }
}