package Deployment;

import static org.neo4j.driver.v1.Values.parameters;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import Controller.ConnectionDB;
import Model.Person;

public class TruyVanCoBan {

	public TruyVanCoBan() {
		// TODO Auto-generated constructor stub
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
    	String q = "MATCH (e:Person) WHERE e.Quoctich = {Quoctich} RETURN e.Nhan AS Nhan, e.Age AS Age, e.Mota AS Mota, e.Job AS Job";
    	
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
             }
         }
    }
	
	public void findPerson1(String Ho) {
    	String q = "MATCH (e:Person) WHERE e.Nhan INCLUDES {Ho} RETURN e.Nhan AS Nhan, e.Age AS Age, e.Mota AS Mota, e.Job AS Job";
    	System.out.println("Những người có họ "+Ho+":");
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
	
}
