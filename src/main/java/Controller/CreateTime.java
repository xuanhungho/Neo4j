package Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import Data.Connection;
import Data.DataExample;
import Model.Country;
import Model.Person;
import Model.Time;

public class CreateTime{
	String Tempid;
	DataExample data = new DataExample();

	public String randomNhan() {
		Date date = new Date();
		Tempid = date.toString();
		return  Tempid;
	}

	public String randomMoTa() {
		return Tempid;
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
		String tem = (Tempid).substring(0,3).trim();
		return tem+i;
	}
	
	public void CreateNodeTime(int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		Time Person = new Time();

		try {
			ConnectionDB cn = new ConnectionDB(Connection.host,Connection.username,Connection.password);
			for(int i=0; i<num; i++) {	
				Person.setNhan(randomNhan());
				Person.setDinhdanh(randomDinhDanh(i));
				Person.setMota(randomMoTa());
				Person.setLink(randomLink());
				Person.setDate(randomThoiGian());

		cn.execute("CREATE ("+Person.getDinhdanh()+":Time { "
					+ "DinhDanh: '"+Person.getDinhdanh()+"', "
					+ "Nhan: '"+Person.getNhan()+"', "
					+ "Mota: '"+Person.getMota()+"', "
					+ "LinkTrichRut: '"+Person.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Person.getDate()+"'})");
		System.out.println("Da them "+Person.getDinhdanh()+"!");
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
