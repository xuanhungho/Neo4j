package View;

import java.util.Calendar; 

import Controller.ConnectionDB;
import Controller.CreateCountry;
import Controller.CreateEvent;
import Controller.CreateLocation;
import Controller.CreateOrganization;
import Controller.CreatePerson;
import Controller.CreateRelationships;
import Controller.CreateTime;
import Deployment.TruyVanCoBan;
import Controller.createEntity;
import Data.Connection;

public class main {
	public final static int num = 5;
	
	public static void main(String[] args) {
		
		long begin = Calendar.getInstance().getTimeInMillis();
		
		// Xoá hết các node hiện có
//		try {
//			ConnectionDB.cn.removeData();
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//		}
//		System.out.println("Đang xoá các node cũ...");
		
		// Tạo các Node
		
//		System.out.println("Đang tạo node...");
//		CreatePerson per = new CreatePerson();
//		per.CreateNodePerson(num);
//		
//		CreateOrganization Org = new CreateOrganization();
//		Org.CreateNodeOrganization(num);
//		
//		CreateLocation location = new CreateLocation();
//		location.CreateNodeLocation(num);
//		
//		CreateEvent event = new CreateEvent();
//		event.CreateNodeEvent(num);
//		
//		CreateCountry country = new CreateCountry();
//		country.CreateNodeCountry(num);
//		
//		CreateTime time = new CreateTime();
//		time.CreateNodeTime(num);
		
//		Tạo node Link bài viết và quan hệ tới các node sẵn có
		
//		System.out.println("Đang tạo quan hệ...");
//		CreateRelationships Rela = new CreateRelationships();
//		Rela.CreateRelationship();
		
		//Tạo các node và quan hệ qua 1 hàm:
		
		createEntity en =new createEntity();
		en.createEntitys(40,40,40,40,40,40);
		
		// 10 truy vấn cơ bản
//		TruyVanCoBan query = new TruyVanCoBan();
		
		//1. In ra ten cua tat ca nhung nguoi co tuoi 65
//		query.findPerson("65");
		
		//2. In ra ten cua tat ca nhung nguoi có quốc tịch Lao
//		query.findPerson("Lao");
		
		//3. In ra ten cua tat ca nhung nguoi họ "Ho"
//		query.findPerson("Ho");
		
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Tổng Thời gian thực hiện: " + (end - begin)+" mili giây!");	
		try {
			ConnectionDB.cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 12000 node hết 74s
		// 120 node hết 4s
	}
}
