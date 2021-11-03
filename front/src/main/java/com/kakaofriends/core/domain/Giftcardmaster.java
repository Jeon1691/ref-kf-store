package com.kakaofriends.core.domain;

import java.util.Date;

@Deprecated
public class Giftcardmaster {
    private String gcmCode;

    private String gcmName;

    private String gcmGoal;

    private Short gcmEa;

    private String gcmMsg;

    private Date gcmSdate;

    private Date gcmEdate;

    private Short gcmPrice;

    private String gcmType;

    private Date gcmIndate;

    private Date gcmModate;

    private String gcmInid;

    private String gcmMoid;

    private Date gcmTime;

    private String gcmMemo;

    private int gcPrice;

    public String getGcmCode() {
        return gcmCode;
    }

    public void setGcmCode(String gcmCode) {
        this.gcmCode = gcmCode == null ? null : gcmCode.trim();
    }

    public String getGcmName() {
        return gcmName;
    }

    public void setGcmName(String gcmName) {
        this.gcmName = gcmName == null ? null : gcmName.trim();
    }

    public String getGcmGoal() {
        return gcmGoal;
    }

    public void setGcmGoal(String gcmGoal) {
        this.gcmGoal = gcmGoal == null ? null : gcmGoal.trim();
    }

    public Short getGcmEa() {
        return gcmEa;
    }

    public void setGcmEa(Short gcmEa) {
        this.gcmEa = gcmEa;
    }

    public String getGcmMsg() {
        return gcmMsg;
    }

    public void setGcmMsg(String gcmMsg) {
        this.gcmMsg = gcmMsg == null ? null : gcmMsg.trim();
    }

    public Date getGcmSdate() {
        return gcmSdate;
    }

    public void setGcmSdate(Date gcmSdate) {
        this.gcmSdate = gcmSdate;
    }

    public Date getGcmEdate() {
        return gcmEdate;
    }

    public void setGcmEdate(Date gcmEdate) {
        this.gcmEdate = gcmEdate;
    }

    public Short getGcmPrice() {
        return gcmPrice;
    }

    public void setGcmPrice(Short gcmPrice) {
        this.gcmPrice = gcmPrice;
    }

    public String getGcmType() {
        return gcmType;
    }

    public void setGcmType(String gcmType) {
        this.gcmType = gcmType == null ? null : gcmType.trim();
    }

    public Date getGcmIndate() {
        return gcmIndate;
    }

    public void setGcmIndate(Date gcmIndate) {
        this.gcmIndate = gcmIndate;
    }

    public Date getGcmModate() {
        return gcmModate;
    }

    public void setGcmModate(Date gcmModate) {
        this.gcmModate = gcmModate;
    }

    public String getGcmInid() {
        return gcmInid;
    }

    public void setGcmInid(String gcmInid) {
        this.gcmInid = gcmInid == null ? null : gcmInid.trim();
    }

    public String getGcmMoid() {
        return gcmMoid;
    }

    public void setGcmMoid(String gcmMoid) {
        this.gcmMoid = gcmMoid == null ? null : gcmMoid.trim();
    }

    public Date getGcmTime() {
        return gcmTime;
    }

    public void setGcmTime(Date gcmTime) {
        this.gcmTime = gcmTime;
    }

    public String getGcmMemo() {
        return gcmMemo;
    }

    public void setGcmMemo(String gcmMemo) {
        this.gcmMemo = gcmMemo == null ? null : gcmMemo.trim();
    }

    public int getGcPrice() {return gcPrice; }

    public void setGcPrice(int gcPrice) { this.gcPrice = gcPrice;}
}