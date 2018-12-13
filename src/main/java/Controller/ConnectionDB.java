package Controller;

import static org.neo4j.driver.v1.Values.parameters;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import Data.Connection;
/**
 * Kết nối cơ sở dữ liệu
 * @author tt
 *
 */

public class ConnectionDB {
	
	private final Driver driver;

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
    
    public StatementResult execute(String s){
    	
    	StatementResult rs= null;
    	try ( Session session = driver.session() ){
    		rs=session.run(s);
    	}
    	return rs;
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
		ConnectionDB cn = new ConnectionDB(Connection.host,Connection.username,Connection.password);
		//cn.execute("CREATE (ee:Person { name: 'aa', from: 'Việt Nam', klout: 99 })");
		cn.removeData();
		try {
			cn.execute("CREATE (hung001:Person { "
					+ "title: 'hung001', "
					+ "Nhan: 'ung', "
					+ "Mota: 'DepZai', "
					+ "ThoiGian: '10-11-2011', "
					+ "Age: '12', "
					+ "Job: 'DEv', "
					+ "Quoctich: 'VietNam'})");
			cn.close();
			System.out.println("Done!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
