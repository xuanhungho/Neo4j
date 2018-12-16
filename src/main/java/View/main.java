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
		en.createEntitys(2500000,2500000,2500000,2500000,2500000,2500000);
		
		// -------------- 10 truy vấn cơ bản ---------------
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
			
		//6. In ra những link bài viết có viết về Organization nhập vào:
//		query1.findLink("Apple");
		
		//7. In ra nhãn của những thực thể Person có đề cập trong Link nhập vào:
//		query1.findThucthePerson("https://search.maven.org/artifact/org.neo4j/neo4j-kernel/3.5.0/jar");
		
		
		// --------------- 10 truy vấn nâng cao ---------------
		TruyVanNangCao query2 = new TruyVanNangCao();
		
		//1. Nhập vào một String bất kì in ra tất cả thông tin của 1 người có liên quan đến String đấy 
//		query2.findPerson("Hung");
//		query2.findPerson("Lao");
		
		// 2. Nhập vào 1 người xác định in ra thời gian và nước mà người ấy đến thăm
//		query2.finePerson_Country("Ho Thi Duong");

		// 3. Nhập vào 1 người xác định in ra những địa điểm và thời gian người đó đến thăm vào Tháng 11/2018
//		query2.fine_LOCATION_11_2018("Ho Thi Duong");
		
		// 4. Nhập vào 1 địa điểm in ra tên của những sự kiện và thời gian diễn ra tại đó vào tháng 10/2018
//		query2.fine_EVENT_10_2018("Toà nhà FPT Cầu Giấy");
		
		//5. In ra nhãn của những thực thể có đề cập trong Link nhập vào:
//		query2.findThucthe("https://search.maven.org/artifact/org.neo4j/neo4j-kernel/3.5.0/jar");
		
		
		
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
