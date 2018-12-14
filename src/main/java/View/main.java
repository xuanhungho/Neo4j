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
import Deployment.TruyVanNangCao;
import Controller.createEntity;
import Data.Connection;

public class main {
	public final static int num = 20;
	
	public static void main(String[] args) {
		
		long begin = Calendar.getInstance().getTimeInMillis();
		
//		// Xoá hết các node hiện có
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
		en.createEntitys(100,100,100,100,100,100);
		
		// 10 truy vấn cơ bản
		TruyVanCoBan query1 = new TruyVanCoBan();
		/*
		//1. In ra ten cua tat ca nhung nguoi co tuoi 65
		query1.findPerson(76);
		
		//2. In ra Thông tin cua tat ca nhung nguoi có quốc tịch Lao
		query1.findPerson("Lao");
		*/	
		//3. In ra thông tin của tat ca nhung nguoi ten "Hung"
//		query1.findPerson1("Hung");
		
		//4. In ra tên của tất cả Person
//		query1.findPerson();
				
		//5. In ra nhãn của 1 thực thể tùy  
		//Nhập Person, Organization, Event, Location, Country, Time hoặc 1,2,3,4,5,6 để xác định đối 
		 
//		query1.find("Person");
			
		//6. In ra nhữnginhk có viết về Organization nhập vào:
//		query1.findLink("Apple");
		
		
		//10 truy vấn nâng cao:
		TruyVanNangCao query2 = new TruyVanNangCao();
		
		//1. In ra thông tin của người có thông tin nhập vào là Tên, họ, tuổi, quốc gia
//		query2.findPerson("Hung");
//		query2.findPerson("Lao");
		
		
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
