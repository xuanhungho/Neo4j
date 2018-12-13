package Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import Data.Connection;
import Data.DataExample;
import Model.Country;
import Model.Location;

public class CreateCountry{
	
	public String Tempid;
	
	DataExample data = new DataExample();
	
//	public Country randomCountry() {
//		Country Country = new Country();
//		Country.setNhan(randomNhan());
//		Country.setMota(randomMoTa());
//		Country.setLink(randomLink());
//		Country.setDate(randomThoiGian());
//		Country.setDinhdanh(randomDinhDanh());
//		return Country;
//	}

	public String randomNhan() {
		String nhan = null ;
		nhan = data.quoctich[new Random().nextInt(data.quoctich.length)];
		Tempid = nhan;
		return nhan;
	}

	public String randomMoTa() {
		String des = null;
		des = data.desquoctich[new Random().nextInt(data.desquoctich.length)];
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
		nhan = data.quoctich[new Random().nextInt(data.event.length)];
		return nhan;
	}
	
	public void CreateNodeCountry(int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		Country Country = new Country();
		try {
			ConnectionDB cn = new ConnectionDB(Connection.host,Connection.username,Connection.password);
			
			for(int i=0; i<num; i++) {	
				Country.setNhan(randomNhan());
				Country.setDinhdanh(randomDinhDanh(i));
				Country.setMota(randomMoTa());
				Country.setLink(randomLink());
				Country.setDate(randomThoiGian());
				
		cn.execute("CREATE ("+Country.getDinhdanh()+":Country { "
					+ "DinhDanh: '"+Country.getDinhdanh()+"', "
					+ "Nhan: '"+Country.getNhan()+"', "
					+ "Mota: '"+Country.getMota()+"', "
					+ "LinkTrichRut: '"+Country.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Country.getDate()+"'})");
		System.out.println("Da them "+Country.getDinhdanh()+"!");
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
