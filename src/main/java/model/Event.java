package model;

import java.util.Date;

public class Event extends Thucthe {
		 private String diadiem;
		 private String daidientochuc;
		 private Date time;
		 
		public Event() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Event(String dinhdanh, String nhan, String mota, String link, Date thoigian,String diadiem, String daidientochuc,Date time) {
			super(dinhdanh, nhan, mota, link, thoigian);
			// TODO Auto-generated constructor stub
			this.diadiem=diadiem;
			this.daidientochuc=daidientochuc;
			this.time=time;
		}
		public String getDiadiem() {
			return diadiem;
		}
		public void setDiadiem(String diadiem) {
			this.diadiem = diadiem;
		}
		public String getDaidientochuc() {
			return daidientochuc;
		}
		public void setDaidientochuc(String daidientochuc) {
			this.daidientochuc = daidientochuc;
		}
		public Date getTime() {
			return time;
		}
		public void setTime(Date time) {
			this.time = time;
		}
	     
}
