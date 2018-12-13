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
import Controller.createEntity;
import Data.Connection;
import Data.DataExample;

public class main {
	public final static int num = 4;
	
	public static void main(String[] args) {
		
		long begin = Calendar.getInstance().getTimeInMillis();
	
		// Xoá hết các node hiện có
//		try {
//			ConnectionDB cn = new ConnectionDB(Connection.host,Connection.username,Connection.password);
//			cn.removeData();
//			try {
//				cn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//		}
		
		// Tạo các Node
		
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
		
//		CreateRelationships Rela = new CreateRelationships();
//		Rela.CreateRelationships();
		
		//Tạo các node và quan hệ qua 1 hàm:
		
		createEntity en =new createEntity();
		en.createEntity(20000,20000,20000,20000,20000,20000);
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Tổng Thời gian thực hiện: " + (end - begin)+" mili giây!");
		
		System.out.println("Done!");
		
		// 12000 node hết 74s
		// 120 node hết 4s
	}
}
