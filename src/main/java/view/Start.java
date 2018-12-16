package view;

import java.util.Calendar;

import controller.ConnectionDB;
import controller.CreateCountry;
import controller.CreateEvent;
import controller.CreateLocation;
import controller.CreateOrganization;
import controller.CreatePerson;
import graph.CreateRelationships;
import controller.CreateTime;
import deployment.TruyVanCoBan;
import deployment.TruyVanNangCao;
import graph.CreateEntity;

public class Start {
	public static int num = 1000;
	
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
//		
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
//
//		System.out.println("Đang tạo quan hệ...");
//		CreateRelationships Rela = new CreateRelationships();
//		Rela.CreateRelationship();
		
		//Tạo các node và quan hệ qua 1 hàm:
		
		CreateEntity en =new CreateEntity();
		en.createEntitys(50,50,50,50,50,50);
		
		// -------------- 10 truy vấn cơ bản ---------------
		TruyVanCoBan query1 = new TruyVanCoBan();

		//1. In ra ten cua tat ca nhung nguoi co tuoi 65
//		query1.findPerson(76);
		
		//2. In ra Thông tin cua tat ca nhung nguoi có quốc tịch Lao
//		query1.findPerson("Lao");

		//3. In ra thông tin của tat ca nhung nguoi ten chua tu "Hung"
//		query1.findAllPerson("Hung");
		
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
//		query2.fine_LOCATION_11_2018("Ho Van Duong");
		
		// 4. Nhập vào 1 địa điểm in ra tên của những sự kiện và thời gian diễn ra tại đó vào tháng 10/2018
//		query2.fine_EVENT_10_2018("Lầu năm góc");
		
		//5. In ra nhãn của những thực thể có đề cập trong Link nhập vào:
//		query2.findThucthe("https://search.maven.org/artifact/org.neo4j/neo4j-kernel/3.5.0/jar");
		
		
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Tổng Thời gian thực hiện: " + (end - begin)+" mili giây!");	
		try {
			ConnectionDB.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
