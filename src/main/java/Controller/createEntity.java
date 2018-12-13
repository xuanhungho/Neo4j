package Controller;

import java.util.Calendar;

import Data.Connection;
import Data.DataExample;
import Model.Country;
import Model.Event;
import Model.Location;
import Model.Organization;
import Model.Person;
import Model.Time;

public class createEntity {

	public createEntity() {
		// TODO Auto-generated constructor stub
	}
	public static String LinkID(String link) {
		int index1 = link.indexOf("/");
		int index2 = link.indexOf(".",index1+2);
		return link.substring(index1+2, index2);
	}
	
	public void createEntity(int personCount, int OrganizatuionCount, int locationCount, int eventCount, int countryCount, int timeCount ) {
		
		Person Person = new Person();
		CreatePerson person = new CreatePerson();
		
		Organization Org = new Organization();
		CreateOrganization Organization = new CreateOrganization();
		
		Location Location = new Location();
		CreateLocation loca = new CreateLocation();
		
		Event Event = new Event();
		CreateEvent event = new CreateEvent();
		
		Country Country = new Country();
		CreateCountry count = new CreateCountry();
		
		Time Time = new Time();
		CreateTime time = new CreateTime();
		
		DataExample  data = new DataExample();
		
		long begin = Calendar.getInstance().getTimeInMillis();
		try {
			ConnectionDB cn = new ConnectionDB(Connection.host,Connection.username,Connection.password);
			System.out.println("Kết nối thành công!");
			cn.execute("match (n) detach delete n");
			System.out.println("Xoá các node cũ!");
			
			//Tạo person
			System.out.println("Bắt đầu tạo các node!");
			for(int i=0; i<personCount; i++) {	
				Person.setNhan(person.randomNhan());
				Person.setDinhdanh(person.randomDinhDanh(i));
				Person.setMota(person.randomMoTa());
				Person.setLink(person.randomLink());
				Person.setDate(person.randomThoiGian());
				Person.setAge(person.randomAge());
				Person.setJob(person.randomJob());
				Person.setQuoctich(person.randomQuocTich());

		cn.execute("CREATE ("+Person.getDinhdanh()+":Person { "
					+ "DinhDanh: '"+Person.getDinhdanh()+"', "
					+ "Nhan: '"+Person.getNhan()+"', "
					+ "Mota: '"+Person.getMota()+"', "
					+ "LinkTrichRut: '"+Person.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Person.getDate()+"', "
					+ "Age: '"+Person.getAge()+"', "
					+ "Job: '"+Person.getJob()+"', "
					+ "Quoctich: '"+Person.getQuoctich()+"'})");
//		System.out.println("Da them "+Person.getDinhdanh()+"!");
		}	
			//Tạo Orga
			for(int i=0; i<OrganizatuionCount; i++) {	
				Org.setNhan(Organization.randomNhan());
				Org.setDinhdanh(Organization.randomDinhDanh(i));
				Org.setMota(Organization.randomMoTa());
				Org.setLink(Organization.randomLink());
				Org.setDate(Organization.randomThoiGian());
				Org.setTruSo(Organization.randomTruSo());
				
		cn.execute("CREATE ("+Org.getDinhdanh()+":Organization { "
					+ "DinhDanh: '"+Org.getDinhdanh()+"', "
					+ "Nhan: '"+Org.getNhan()+"', "
					+ "Mota: '"+Org.getMota()+"', "
					+ "LinkTrichRut: '"+Org.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Org.getDate()+"', "
					+ "TruSo: '"+Org.getTruSo()+"'})");
//		System.out.println("Da them "+Org.getDinhdanh()+"!");
		}	
			//Tạo Location
			for(int i=0; i<locationCount; i++) {	
				Location.setNhan(loca.randomNhan());
				Location.setDinhdanh(loca.randomDinhDanh(i));
				Location.setMota(loca.randomMoTa());
				Location.setLink(loca.randomLink());
				Location.setDate(loca.randomThoiGian());
				Location.setQuocGia(loca.randomQuocGia());
				
		cn.execute("CREATE ("+Location.getDinhdanh()+":Location { "
					+ "DinhDanh: '"+Location.getDinhdanh()+"', "
					+ "Nhan: '"+Location.getNhan()+"', "
					+ "Mota: '"+Location.getMota()+"', "
					+ "LinkTrichRut: '"+Location.getLink()+"', "			
					+ "ThoiGianTrichRut:'"+Location.getDate()+"', "
					+ "QuocGia: '"+Location.getQuocGia()+"'})");
//		System.out.println("Da them "+Location.getDinhdanh()+"!");
		}	
			//Tạo Event
			for(int i=0; i<eventCount; i++) {	
				Event.setNhan(event.randomNhan());
				Event.setDinhdanh(event.randomDinhDanh(i));
				Event.setMota(event.randomMoTa());
				Event.setLink(event.randomLink());
				Event.setDate(event.randomThoiGian());
				Event.setDaidientochuc(event.randomDaiDien());
				Event.setDiadiem(event.randomDiaDiem());
				Event.setTime(event.randomTime());
				
		cn.execute("CREATE ("+Event.getDinhdanh()+":Event { "
					+ "Nhan: '"+Event.getNhan()+"', "
					+ "DinhDanh: '"+Event.getDinhdanh()+"', "
					+ "Mota: '"+Event.getMota()+"', "
					+ "LinkTrichRut: '"+Event.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Event.getDate()+"', "
					+ "DiaDiem: '"+Event.getDiadiem()+"', "
					+ "ThoiGianToChuc: '"+Event.getTime()+"', "
					+ "DaiDien: '"+Event.getDaidientochuc()+"'})");
		
//		System.out.println("Da them "+Event.getDinhdanh()+"!");
		}	
			//Tạo Country
			for(int i=0; i<countryCount; i++) {	
				Country.setNhan(count.randomNhan());
				Country.setDinhdanh(count.randomDinhDanh(i));
				Country.setMota(count.randomMoTa());
				Country.setLink(count.randomLink());
				Country.setDate(count.randomThoiGian());
				
		cn.execute("CREATE ("+Country.getDinhdanh()+":Country { "
					+ "DinhDanh: '"+Country.getDinhdanh()+"', "
					+ "Nhan: '"+Country.getNhan()+"', "
					+ "Mota: '"+Country.getMota()+"', "
					+ "LinkTrichRut: '"+Country.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Country.getDate()+"'})");
//		System.out.println("Da them "+Country.getDinhdanh()+"!");
		}	
			
			//Tạo Time
			for(int i=0; i<timeCount; i++) {	
				Time.setNhan(time.randomNhan());
				Time.setDinhdanh(time.randomDinhDanh(i));
				Time.setMota(time.randomMoTa());
				Time.setLink(time.randomLink());
				Time.setDate(time.randomThoiGian());

		cn.execute("CREATE ("+Time.getDinhdanh()+":Time { "
					+ "DinhDanh: '"+Time.getDinhdanh()+"', "
					+ "Nhan: '"+Time.getNhan()+"', "
					+ "Mota: '"+Time.getMota()+"', "
					+ "LinkTrichRut: '"+Time.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Time.getDate()+"'})");
//		System.out.println("Da them "+Time.getDinhdanh()+"!");
		}
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Đã chèn xong node trong: " + (end - begin)+" mili giây!");
			// Tạo các node Link
			for(int i=0; i<data.link.length; i++) {	
				String linkid = LinkID(data.link[i]);
				cn.execute("CREATE ("+linkid+":Link { "
					+ "Link: '"+data.link[i]+"', "			
					+ "LinhID: '"+linkid+"'})");
//				System.out.println("Da them "+linkid+"!");
			}	
			
			System.out.println("Đã tạo xong các nốt! Đang tạo quan hệ ..."); 
			// Tạo các quan hệ
			cn.execute("MATCH (per:Person),(lk:Link) WHERE per.LinkTrichRut = lk.Link\r\n" + 
					"CREATE (per)-[:TRICH_RUT_TU]->(lk)");
			cn.execute("MATCH (org:Organization),(lk:Link) WHERE org.LinkTrichRut = lk.Link\r\n" + 
					"CREATE (org)-[:TRICH_RUT_TU]->(lk)");
			cn.execute("MATCH (loca:Location),(lk:Link) WHERE loca.LinkTrichRut = lk.Link\r\n" + 
					"CREATE (loca)-[:TRICH_RUT_TU]->(lk)");
			cn.execute("MATCH (event:Event),(lk:Link) WHERE event.LinkTrichRut = lk.Link\r\n" + 
					"CREATE (event)-[:TRICH_RUT_TU]->(lk)");
			cn.execute("MATCH (time:Time),(lk:Link) WHERE time.LinkTrichRut = lk.Link\r\n" + 
					"CREATE (time)-[:TRICH_RUT_TU]->(lk)");
			cn.execute("MATCH (country:Country),(lk:Link) WHERE country.LinkTrichRut = lk.Link\r\n" + 
					"CREATE (country)-[:TRICH_RUT_TU]->(lk)");
			
			System.out.println("Done!");
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Chen qua code java: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
