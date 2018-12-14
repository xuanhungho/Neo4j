package Deployment;

import static org.neo4j.driver.v1.Values.parameters;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import Controller.ConnectionDB;

public class TruyVanNangCao {

	public void findPerson(String Ho) {
    	String q = "MATCH (e:Person) WHERE e.Nhan ENDS WITH {Ho} OR e.Nhan STARTS WITH {Ho} OR e.Age = {Ho} OR e.Quoctich = {Ho} "
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
}
