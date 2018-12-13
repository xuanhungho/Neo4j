package Controller;

import java.util.Calendar;
import java.util.Date; 
import java.util.Random;

import Data.Connection;
import Data.DataExample;
import Model.Event;
import Model.Location;

public class CreateEvent{
	
	public String Tempid;
	DataExample data = new DataExample();
	
//	public Event randomEvent() {
//		Event Event = new Event();
//		Event.setNhan(randomNhan());
//		Event.setMota(randomMoTa());
//		Event.setLink(randomLink());
//		Event.setDate(randomThoiGian());
//		Event.setDiadiem(randomDiaDiem());
//		Event.setDinhdanh(randomDinhDanh());
//		Event.setDaidientochuc(randomDaiDien());
//		Event.setTime(randomTime());
//		return Event;
//	}

	public String randomNhan() {
		String nhan = null ;
		nhan = data.event[new Random().nextInt(data.event.length)];
		Tempid = nhan;
		return nhan;
	}

	public String randomMoTa() {
		String des = null;
		des = data.event[new Random().nextInt(data.event.length)];
		return des;
	}
	
	public String randomLink() {
		String link ;
		link = data.link[new Random().nextInt(data.link.length)];
		return link;
	}
	
	public Date randomThoiGian() {
		Date date = new Date();
		return date;
	}
	
	public String randomDinhDanh(int i) {
		String tem = (Tempid).substring(0,2).trim();
		return tem+i;
	}
	
	public String randomDiaDiem() {
		String nhan = null ;
		nhan = data.location[new Random().nextInt(data.location.length)];
		return nhan;
	}
	
	public String randomDaiDien() {
		String nhan = null ;
		nhan = data.firstName[new Random().nextInt(data.firstName.length)]+" "+
				data.midName[new Random().nextInt(data.midName.length)]+" "+
				data.lastName[new Random().nextInt(data.lastName.length)];
		return nhan;
	}

	public Date randomTime() {
		Date date = new Date();
		return date;
	}
	
	public void CreateNodeEvent(int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		Event Org = new Event();
		try {
			ConnectionDB cn = new ConnectionDB(Connection.host,Connection.username,Connection.password);
			
			for(int i=0; i<num; i++) {	
				Org.setNhan(randomNhan());
				Org.setDinhdanh(randomDinhDanh(i));
				Org.setMota(randomMoTa());
				Org.setLink(randomLink());
				Org.setDate(randomThoiGian());
				Org.setDaidientochuc(randomDaiDien());
				Org.setDiadiem(randomDiaDiem());
				Org.setTime(randomTime());
				
		cn.execute("CREATE ("+Org.getDinhdanh()+":Event { "
					+ "Nhan: '"+Org.getNhan()+"', "
					+ "DinhDanh: '"+Org.getDinhdanh()+"', "
					+ "Mota: '"+Org.getMota()+"', "
					+ "LinkTrichRut: '"+Org.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Org.getDate()+"', "
					+ "DiaDiem: '"+Org.getDiadiem()+"', "
					+ "ThoiGianToChuc: '"+Org.getTime()+"', "
					+ "DaiDien: '"+Org.getDaidientochuc()+"'})");
		
		System.out.println("Da them "+Org.getDinhdanh()+"!");
		}	
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thời gian thực hiện: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

}
