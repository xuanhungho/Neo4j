package Controller;

import java.util.Calendar;
import java.util.Date; 
import java.util.Random;

import javax.management.loading.PrivateClassLoader;

import Data.Connection;
import Data.DataExample;
import Model.Location;
import Model.Organization;

public class CreateLocation{
//	public Location randomLocaiton() {
//		Location Location = new Location();
//		Location.setNhan(randomNhan());
//		Location.setMota(randomDescription());
//		Location.setLink(randomLink());
//		Location.setDate(randomThoiGian());
//		Location.setDinhdanh(randomDinhDanh());
//		Location.setQuocGia(randomQuocGia());
//		return Location;
//	}
	public String Tempid;
	DataExample data = new DataExample();

	public String randomNhan() {
		String nhan = null ;
		nhan = data.location[new Random().nextInt(data.location.length)];
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
		String tem = (Tempid).substring(0,3).trim();
		return tem+i;
	}
	public String randomQuocGia() {
		String des = null;
		des = data.quoctich[new Random().nextInt(data.quoctich.length)];
		return des;
	}
	
	public void CreateNodeLocation(int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		Location Org = new Location();
		try {
			ConnectionDB cn = new ConnectionDB(Connection.host,Connection.username,Connection.password);
			
			for(int i=0; i<num; i++) {	
				Org.setNhan(randomNhan());
				Org.setDinhdanh(randomDinhDanh(i));
				Org.setMota(randomMoTa());
				Org.setLink(randomLink());
				Org.setDate(randomThoiGian());
				Org.setQuocGia(randomQuocGia());
				
		cn.execute("CREATE ("+Org.getDinhdanh()+":Location { "
					+ "DinhDanh: '"+Org.getDinhdanh()+"', "
					+ "Nhan: '"+Org.getNhan()+"', "
					+ "Mota: '"+Org.getMota()+"', "
					+ "LinkTrichRut: '"+Org.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Org.getDate()+"', "
					+ "QuocGia: '"+Org.getQuocGia()+"'})");
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
