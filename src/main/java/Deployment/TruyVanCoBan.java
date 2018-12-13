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
	
	public void findPerson(String Age) {
	    	String q = "MATCH (e:Person) WHERE e.Age = {Age} OR e.Nhan STARTS WITH {Age} "
	    			+ "OR e.Quoctich = {Age} RETURN e.Nhan AS result1";
	    	String a = String.valueOf(Age);
	    	 try (Session session = ConnectionDB.cn.driver.session())
	         {
	             // Auto-commit transactions are a quick and easy way to wrap a read.
	             StatementResult result = session.run(q,parameters("Age", a));
	             // Each Cypher execution returns a stream of records.
	             while (result.hasNext())
	             {
	                 Record record = result.next();
	                 // Values can be extracted from a record by index or name.
	                 System.out.println(record.get("result1").asString());
	             }
	         }
	    }
	
}
