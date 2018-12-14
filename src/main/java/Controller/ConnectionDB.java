package Controller;

import static org.neo4j.driver.v1.Values.parameters; 

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;

import Data.Connection;


public class ConnectionDB {
	
	public final Driver driver;
	public final static ConnectionDB cn = new ConnectionDB(Connection.host,Connection.username,Connection.password);
	
   
	public ConnectionDB( String uri, String user, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }
   
    public ConnectionDB()
    {
        driver = GraphDatabase.driver( Connection.host, AuthTokens.basic( Connection.username, Connection.password ) );
    }
    
    public void close() throws Exception
    {
        driver.close();
    }
    
	
    public void execute (String s) {
    	  try (Session session = driver.session())
          {
              // Wrapping Cypher in an explicit transaction provides atomicity
              // and makes handling errors much easier.
              try (Transaction tx = session.beginTransaction())
              {
                  tx.run(s);
                  tx.success();  // Mark this write as successful.
              }
          }
    }
    
    public void Result1(int i) {
    	String q = "MATCH (e:Person) WHERE e.Age = {Age} RETURN e.Nhan AS result1";
    	String a = String.valueOf(i);
    	 try (Session session = driver.session())
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
    
	public void removeData(){
		ConnectionDB cn = new ConnectionDB();
		cn.execute("match (n) detach delete n");
		try {
			cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	public static void main(String[] args) {
		ConnectionDB con = new ConnectionDB(Connection.host,Connection.username,Connection.password);
		//cn.execute("CREATE (ee:Person { name: 'aa', from: 'Việt Nam', klout: 99 })");
		con.removeData();
		try {
			con.execute("CREATE (ee:Person { name: 'aa', from: 'Việt Nam', klout: 99 })");
			con.close();
			System.out.println("Done!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
