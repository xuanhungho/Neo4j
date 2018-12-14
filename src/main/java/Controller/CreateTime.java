package Controller;

import java.util.Calendar; 
import java.util.Date;
import java.util.Random;
import Data.DataExample;
import Model.Time;

public class CreateTime{
	String Tempid;
	DataExample data = new DataExample();

	public String randomNhan(int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -i);
		Tempid = calendar.getTime().toString();
		return Tempid;
	}

	public String randomMoTa() {
		return Tempid;
	}
	
	public String randomLink() {
		String link ;
		link = data.link[new Random().nextInt(data.link.length)];
		return link;
	}
	
	public Date randomThoiGian(int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -i);
		return calendar.getTime();
	}
	
	public String randomDinhDanh(int i) {
		String tem = (Tempid).substring(0,3).trim();
		return tem+i;
	}
	
	public void CreateNodeTime(int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		Time Time = new Time();

		try {
				for(int i=0; i<num; i++) {	
				Time.setNhan(randomNhan(i));
				Time.setDinhdanh(randomDinhDanh(i));
				Time.setMota(randomMoTa());
				Time.setLink(randomLink());
				Time.setDate(randomThoiGian(i));

				ConnectionDB.cn.execute("CREATE ("+Time.getDinhdanh()+":Time { "
					+ "DinhDanh: '"+Time.getDinhdanh()+"', "
					+ "Nhan: '"+Time.getNhan()+"', "
					+ "Mota: '"+Time.getMota()+"', "
					+ "LinkTrichRut: '"+Time.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Time.getDate()+"'})");
		System.out.println("Da them "+Time.getDinhdanh()+"!");
		}	
		
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thời gian thực hiện: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
