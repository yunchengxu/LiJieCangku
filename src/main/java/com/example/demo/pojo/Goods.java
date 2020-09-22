package com.example.demo.pojo;

import java.io.Serializable;

public class Goods implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Integer goodsId;

    private String goodsName;

    private String goodsImg;

    private Integer goodsPrice;

    private Integer goodsNumber;

    private String goodsNo;

    private String goodsType1;

    private String goodsManufacturer;

    private String goodsType2;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo == null ? null : goodsNo.trim();
    }

    public String getGoodsType1() {
        return goodsType1;
    }

    public void setGoodsType1(String goodsType1) {
        this.goodsType1 = goodsType1 == null ? null : goodsType1.trim();
    }

    public String getGoodsManufacturer() {
        return goodsManufacturer;
    }

    public void setGoodsManufacturer(String goodsManufacturer) {
        this.goodsManufacturer = goodsManufacturer == null ? null : goodsManufacturer.trim();
    }

    public String getGoodsType2() {
        return goodsType2;
    }

    public void setGoodsType2(String goodsType2) {
        this.goodsType2 = goodsType2 == null ? null : goodsType2.trim();
    }

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsImg=" + goodsImg + ", goodsPrice="
				+ goodsPrice + ", goodsNumber=" + goodsNumber + ", goodsNo=" + goodsNo + ", goodsType1=" + goodsType1
				+ ", goodsManufacturer=" + goodsManufacturer + ", goodsType2=" + goodsType2 + "]";
	}
}