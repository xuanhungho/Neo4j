package controller;

import java.util.Calendar; 
import java.util.Date;
import java.util.Random;

import data.DataExample;
import model.Country;

public class CreateCountry{
	
	public String Tempid;
	
	DataExample data = new DataExample();

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
	
	public Date randomThoiGian(int i) {
		Calendar calendar = Calendar.getInstance();
		i = i%6500;
		calendar.add(Calendar.DATE, -i);
		return calendar.getTime();
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
			System.out.println("Đang thêm node Country...");
			for(int i=0; i<num; i++) {	
				Country.setNhan(randomNhan());
				Country.setDinhdanh(randomDinhDanh(i));
				Country.setMota(randomMoTa());
				Country.setLink(randomLink());
				Country.setDate(randomThoiGian(i));
				
				ConnectionDB.cn.execute("CREATE ("+Country.getDinhdanh()+":Country { "
					+ "DinhDanh: '"+Country.getDinhdanh()+"', "
					+ "Nhan: '"+Country.getNhan()+"', "
					+ "Mota: '"+Country.getMota()+"', "
					+ "LinkTrichRut: '"+Country.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Country.getDate()+"'})");
//				System.out.println("Đã thêm "+Country.getDinhdanh()+"!");
		}	
			
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thêm Country: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
