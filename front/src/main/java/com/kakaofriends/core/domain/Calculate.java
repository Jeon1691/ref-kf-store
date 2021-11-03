package com.kakaofriends.core.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Calculate {
    private BigDecimal ccSeq;

    private String ccNum;

    private String ccCpcode;

    private BigDecimal ccOrgmoney;

    private BigDecimal ccVatmoney;

    private BigDecimal ccMoney;

    private Integer ccStatus;

    private String ccTaxyn;

    private String ccEtc1;

    private String ccEtc2;

    private String ccEtc3;

    private String ccEtc4;

    private String ccEtc5;

    private String ccEtc6;

    private String ccLevel;

    private String ccType;

    private String ccUse;

    private String ccMoid;

    private String ccInid;

    private Date ccModate;

    private Date ccIndate;

    private Long ccTxSeq;

    private String ccSalesyn;

    public BigDecimal getCcSeq() {
        return ccSeq;
    }

    public void setCcSeq(BigDecimal ccSeq) {
        this.ccSeq = ccSeq;
    }

    public String getCcNum() {
        return ccNum;
    }

    public void setCcNum(String ccNum) {
        this.ccNum = ccNum == null ? null : ccNum.trim();
    }

    public String getCcCpcode() {
        return ccCpcode;
    }

    public void setCcCpcode(String ccCpcode) {
        this.ccCpcode = ccCpcode == null ? null : ccCpcode.trim();
    }

    public BigDecimal getCcOrgmoney() {
        return ccOrgmoney;
    }

    public void setCcOrgmoney(BigDecimal ccOrgmoney) {
        this.ccOrgmoney = ccOrgmoney;
    }

    public BigDecimal getCcVatmoney() {
        return ccVatmoney;
    }

    public void setCcVatmoney(BigDecimal ccVatmoney) {
        this.ccVatmoney = ccVatmoney;
    }

    public BigDecimal getCcMoney() {
        return ccMoney;
    }

    public void setCcMoney(BigDecimal ccMoney) {
        this.ccMoney = ccMoney;
    }

    public Integer getCcStatus() {
        return ccStatus;
    }

    public void setCcStatus(Integer ccStatus) {
        this.ccStatus = ccStatus;
    }

    public String getCcTaxyn() {
        return ccTaxyn;
    }

    public void setCcTaxyn(String ccTaxyn) {
        this.ccTaxyn = ccTaxyn == null ? null : ccTaxyn.trim();
    }

    public String getCcEtc1() {
        return ccEtc1;
    }

    public void setCcEtc1(String ccEtc1) {
        this.ccEtc1 = ccEtc1 == null ? null : ccEtc1.trim();
    }

    public String getCcEtc2() {
        return ccEtc2;
    }

    public void setCcEtc2(String ccEtc2) {
        this.ccEtc2 = ccEtc2 == null ? null : ccEtc2.trim();
    }

    public String getCcEtc3() {
        return ccEtc3;
    }

    public void setCcEtc3(String ccEtc3) {
        this.ccEtc3 = ccEtc3 == null ? null : ccEtc3.trim();
    }

    public String getCcEtc4() {
        return ccEtc4;
    }

    public void setCcEtc4(String ccEtc4) {
        this.ccEtc4 = ccEtc4 == null ? null : ccEtc4.trim();
    }

    public String getCcEtc5() {
        return ccEtc5;
    }

    public void setCcEtc5(String ccEtc5) {
        this.ccEtc5 = ccEtc5 == null ? null : ccEtc5.trim();
    }

    public String getCcEtc6() {
        return ccEtc6;
    }

    public void setCcEtc6(String ccEtc6) {
        this.ccEtc6 = ccEtc6 == null ? null : ccEtc6.trim();
    }

    public String getCcLevel() {
        return ccLevel;
    }

    public void setCcLevel(String ccLevel) {
        this.ccLevel = ccLevel == null ? null : ccLevel.trim();
    }

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String ccType) {
        this.ccType = ccType == null ? null : ccType.trim();
    }

    public String getCcUse() {
        return ccUse;
    }

    public void setCcUse(String ccUse) {
        this.ccUse = ccUse == null ? null : ccUse.trim();
    }

    public String getCcMoid() {
        return ccMoid;
    }

    public void setCcMoid(String ccMoid) {
        this.ccMoid = ccMoid == null ? null : ccMoid.trim();
    }

    public String getCcInid() {
        return ccInid;
    }

    public void setCcInid(String ccInid) {
        this.ccInid = ccInid == null ? null : ccInid.trim();
    }

    public Date getCcModate() {
        return ccModate;
    }

    public void setCcModate(Date ccModate) {
        this.ccModate = ccModate;
    }

    public Date getCcIndate() {
        return ccIndate;
    }

    public void setCcIndate(Date ccIndate) {
        this.ccIndate = ccIndate;
    }

    public Long getCcTxSeq() {
        return ccTxSeq;
    }

    public void setCcTxSeq(Long ccTxSeq) {
        this.ccTxSeq = ccTxSeq;
    }

    public String getCcSalesyn() {
        return ccSalesyn;
    }

    public void setCcSalesyn(String ccSalesyn) {
        this.ccSalesyn = ccSalesyn == null ? null : ccSalesyn.trim();
    }
}