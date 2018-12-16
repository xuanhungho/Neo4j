package Deployment;

import static org.neo4j.driver.v1.Values.parameters;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import Controller.ConnectionDB;

public class TruyVanNangCao {

	public void findPerson(String Ho) {
    	String q = "MATCH (e:Person) WHERE e.Nhan CONTAINS {Ho} OR e.Age = {Ho} OR e.Quoctich = {Ho} OR e.Mota = {Ho} "
    			+ "RETURN e.Nhan AS Nhan, e.Age AS Age, e.Mota AS Mota, e.Job AS Job";
    	System.out.println("Người có thông tin trên là: "+Ho+":");
    	 try (Session session = ConnectionDB.cn.driver.session()){
             StatementResult result = session.run(q,parameters("Ho", Ho));
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Tên: "+record.get("Nhan").asString());
                 System.out.println("Tuổi: "+record.get("Age").asString());
                 System.out.println("Nghề nghiệp: "+record.get("Job").asString());
                 System.out.println("SĐT: "+record.get("Mota").asString());
             }
         }
    }

	public void finePerson_Country(String ten) {
		String q = "MATCH (per:Person)-[:DEN_THAM]->(country:Location)-[:DEN_THAM_VAO]->(time:Time) WHERE per.Nhan = {ten} "
				+ " WITH DISTINCT country, time RETURN country.Nhan AS locaNhan, time.Nhan AS timeNhan";
		System.out.println("Những địa điểm "+ten+" đã đến thăm là:");
   	 try (Session session = ConnectionDB.cn.driver.session()){
            StatementResult result = session.run(q,parameters("ten", ten));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println("Địa điểm: "+record.get("locaNhan").asString()+" - Thời gian: "+record.get("timeNhan").asString());
                
            }
        }
	}

	public void fine_LOCATION_11_2018(String ten) {
		String q = "MATCH (per:Person)-[:DEN_THAM]->(loca:Location)-[:DEN_THAM_VAO]->(time:Time) WHERE per.Nhan = {ten}"
				+ " AND time.Nhan CONTAINS 'Nov' "
				+ " AND time.Nhan ENDS WITH '2018' "
				+ " WITH DISTINCT loca, time RETURN loca.Nhan AS locaNhan, time.Nhan AS timeNhan ";
		System.out.println(" ");
		System.out.println("Những nơi "+ten+" đến thăm vào tháng 11/2018 là:");
   	 try (Session session = ConnectionDB.cn.driver.session()){
            StatementResult result = session.run(q,parameters("ten", ten));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("locaNhan").asString()+" - Thời gian: "+record.get("timeNhan").asString());
                
            }
        }
	}
	
	public void fine_EVENT_10_2018(String location) {
		String q = "MATCH (event:Event)-[:DIEN_RA_TAI]->(loca:Location)-[:DIEN_RA_VAO]->(time:Time) WHERE loca.Nhan = {location}"
				+ " AND time.Nhan CONTAINS 'Oct' "
				+ " AND time.Nhan ENDS WITH '2018' "
				+ " WITH DISTINCT event, time RETURN event.Nhan AS locaNhan, time.Nhan AS timeNhan ";
		System.out.println(" ");
		System.out.println("Những sự kiện diễn ra tại "+location+" vào tháng 10/2018 là:");
   	 try (Session session = ConnectionDB.cn.driver.session()){
            StatementResult result = session.run(q,parameters("location", location));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("locaNhan").asString()+" - Thời gian: "+record.get("timeNhan").asString());
                
            }
        }
	}
	public void findThucthe(String link) {
    	System.out.println("Những thực thể đề cập đến bài viết trong "+link+" là:");
    	
    	String q1 = "MATCH (per:Person) WHERE per.LinkTrichRut = {link} RETURN per.Nhan AS perNhan";
    	
    	 try (Session session = ConnectionDB.cn.driver.session()){
             StatementResult result = session.run(q1,parameters("link", link));
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Person: "+record.get("perNhan").asString());
             }
         }
    	 
    	 String q2 = "MATCH (Org:Organization) WHERE Org.LinkTrichRut = {link} RETURN Org.Nhan AS OrgNhan";
     	
     	 try (Session session = ConnectionDB.cn.driver.session()){
              StatementResult result = session.run(q2,parameters("link", link));
              while (result.hasNext())
              {
                  Record record = result.next();
                  System.out.println("Organization: "+record.get("OrgNhan").asString());
              }
          }
     	 
     	String q3 = "MATCH (loca:Location) WHERE loca.LinkTrichRut = {link} RETURN loca.Nhan AS perNhan";
    	
    	 try (Session session = ConnectionDB.cn.driver.session()){
             StatementResult result = session.run(q3,parameters("link", link));
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Location: "+record.get("perNhan").asString());
             }
         }
    	 
    	 String q4 = "MATCH (event:Event) WHERE event.LinkTrichRut = {link} RETURN event.Nhan AS perNhan";
     	
     	 try (Session session = ConnectionDB.cn.driver.session()){
              StatementResult result = session.run(q4,parameters("link", link));
              while (result.hasNext())
              {
                  Record record = result.next();
                  System.out.println("Event: "+record.get("perNhan").asString());
              }
          }
     	 
     	String q5 = "MATCH (country:Country) WHERE country.LinkTrichRut = {link} RETURN country.Nhan AS perNhan";
    	
    	 try (Session session = ConnectionDB.cn.driver.session()){
             StatementResult result = session.run(q5,parameters("link", link));
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Country: "+record.get("perNhan").asString());
             }
         }
    	 
    	 String q6 = "MATCH (time:Time) WHERE time.LinkTrichRut = {link} RETURN time.Nhan AS perNhan";
     	
     	 try (Session session = ConnectionDB.cn.driver.session()){
              StatementResult result = session.run(q6,parameters("link", link));
              while (result.hasNext())
              {
                  Record record = result.next();
                  System.out.println("Time: "+record.get("perNhan").asString());
              }
          }
    }
	
}
