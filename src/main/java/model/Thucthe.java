package model;

import java.util.Date;

public class Thucthe {
	 private String dinhdanh;
	 private String nhan;
	 private String mota;
	 private String link;
	 private Date thoigian;
	 
	 public Thucthe() {
	 } 
	 
	 public Thucthe(String dinhdanh, String nhan, String mota, String link,Date thoigian ) {
		super();
		this.dinhdanh = dinhdanh;
		this.nhan = nhan;
		this.mota = mota;
		this.link = link;
		this.thoigian=thoigian;
	}

	public String getDinhdanh() {
		return dinhdanh;
	}
	public void setDinhdanh(String dinhdanh) {
		this.dinhdanh = dinhdanh;
	}
	public String getNhan() {
		return nhan;
	}
	public void setNhan(String nhan) {
		this.nhan = nhan;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setDate(Date date) {
		this.thoigian = date;
	}
	public Date getDate() {
		return thoigian;
	}
	
	public String getThucthe() {
		return "Thucthe: [Dinhdanh =" + dinhdanh + ", Nhan =" + nhan + ", Mo ta =" + mota + ", Link =" + link + "]";
	}
}
