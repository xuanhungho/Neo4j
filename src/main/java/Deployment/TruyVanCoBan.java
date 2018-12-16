package Deployment;

import static org.neo4j.driver.v1.Values.parameters; 

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import Controller.ConnectionDB;

public class TruyVanCoBan {

	public TruyVanCoBan() {
		// TODO Auto-generated constructor stub
	}
	
	public void find(String s) {
		if(s=="1") s = "Person";
		else if(s=="2") s = "Organization";
		else if(s=="3") s = "Event";
		else if(s=="4") s = "Location";
		else if(s=="5") s = "Country";
		else if(s=="6") s = "Time";
    	System.out.println("Tất cả "+s+":");
    	 try (Session session = ConnectionDB.cn.driver.session()){
             StatementResult result = session.run("MATCH (e:"+s+") RETURN e.Nhan AS Nhan");
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println(record.get("Nhan").asString());
             }
         }
    }
	
	public void findPerson() {
    	System.out.println("Tất cả Person: ");
    	 try (Session session = ConnectionDB.cn.driver.session()){
             StatementResult result = session.run("MATCH (e:Person) RETURN e.Nhan AS Nhan, e.ThoiGianTrichRut AS Time");
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Tên: "+record.get("Nhan").asString()+" - Thoi gian trich rut: "+record.get("Time").asString());
                 
             }
         }
    }
	
	public void findPerson(int Age) {
	    	String q = "MATCH (e:Person) WHERE e.Age = {Age} RETURN e.Nhan AS Nhan";
	    	String a = String.valueOf(Age);
	    	System.out.println("Những người có tuổi "+Age+":");
	    	 try (Session session = ConnectionDB.cn.driver.session()){
	             StatementResult result = session.run(q,parameters("Age", a));
	             
	             while (result.hasNext())
	             {
	                 Record record = result.next();
	                 System.out.println(record.get("Nhan").asString());
	             }
	         }
	    }
	
	public void findPerson(String Quoctich) {
    	String q = "MATCH (e:Person) WHERE e.Quoctich = {Quoctich} RETURN e.Nhan AS Nhan, "
    			+ "e.Age AS Age, e.Mota AS Mota, e.Job AS Job, e.ThoiGianTrichRut AS Time";
    	
    	 try (Session session = ConnectionDB.cn.driver.session()){
             StatementResult result = session.run(q,parameters("Quoctich", Quoctich));
             System.out.println("Những người có quốc tịch "+Quoctich+":");
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Tên: "+record.get("Nhan").asString());
                 System.out.println("Tuổi: "+record.get("Age").asString());
                 System.out.println("Nghề nghiệp: "+record.get("Job").asString());
                 System.out.println("SĐT: "+record.get("Mota").asString());
                 System.out.println("Thời gian trích rút: "+record.get("Time").asString());
             }
         }
    }
	
	public void findPerson1(String Ten) {
    	String q = "MATCH (e:Person) WHERE e.Nhan ENDS WITH {Ten} RETURN e.Nhan AS Nhan, "
    			+ "e.Age AS Age, e.Mota AS Mota, e.Job AS Job, e.ThoiGianTrichRut AS Time";
    	System.out.println("Những người có tên "+Ten+":");
    	 try (Session session = ConnectionDB.cn.driver.session()){
             StatementResult result = session.run(q,parameters("Ten", Ten));
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Tên: "+record.get("Nhan").asString());
                 System.out.println("Tuổi: "+record.get("Age").asString());
                 System.out.println("Nghề nghiệp: "+record.get("Job").asString());
                 System.out.println("SĐT: "+record.get("Mota").asString());
                 System.out.println("Thời gian trích rút: "+record.get("Time").asString());
                 }
         }
    }
	
	public void findLink(String Org) {
    	String q = "MATCH (Or:Organization) WHERE Or.Nhan = {Org} RETURN Or.LinkTrichRut AS Link, Or.ThoiGianTrichRut AS Time";
    	
    	 try (Session session = ConnectionDB.cn.driver.session()){
             StatementResult result = session.run(q,parameters("Org", Org));
             System.out.println("Những bài viết viết về "+Org+" là:");
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Link: "+record.get("Link").asString()+" - Thoi gian trich rut: "+record.get("Time").asString());
             }
         }
    }
	
	public void findThucthePerson(String link) {
    	String q = "MATCH (per:Person) WHERE per.LinkTrichRut = {link} RETURN per.Nhan AS perNhan";
    	 try (Session session = ConnectionDB.cn.driver.session()){
             StatementResult result = session.run(q,parameters("link", link));
             System.out.println("Những thực thể Person đề cập đến bài viết trong "+link+" là:");
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Person: "+record.get("perNhan").asString());
              
             }
         }
    }
	
}
