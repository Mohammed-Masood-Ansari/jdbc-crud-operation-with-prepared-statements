package com.qsp.jdbc_prepared_statement_eve.dto;

public class Mobile {

	private int mobileId;
	private String mobileBrand;
	private double mobilePrice;
	private String mobileColor;
	private String mobileCamera;
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public String getMobileBrand() {
		return mobileBrand;
	}
	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}
	public double getMobilePrice() {
		return mobilePrice;
	}
	public void setMobilePrice(double mobilePrice) {
		this.mobilePrice = mobilePrice;
	}
	public String getMobileColor() {
		return mobileColor;
	}
	public void setMobileColor(String mobileColor) {
		this.mobileColor = mobileColor;
	}
	public String getMobileCamera() {
		return mobileCamera;
	}
	public void setMobileCamera(String mobileCamera) {
		this.mobileCamera = mobileCamera;
	}
	
	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", mobileBrand=" + mobileBrand + ", mobilePrice=" + mobilePrice
				+ ", mobileColor=" + mobileColor + ", mobileCamera=" + mobileCamera + "]";
	}
	
	
}
