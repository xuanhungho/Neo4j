package View;
import java.util.Calendar; 

import Controller.ConnectionDB;
import Controller.Create;
import Controller.CreatePerson;
import Data.Connection;
import Model.Person;
import Data.DataExample;

public class main {

	public static void main(String[] args) {

		DataExample data = new DataExample();
		CreatePerson a = new CreatePerson();
	try {
		ConnectionDB con = new ConnectionDB(Connection.host,Connection.username,Connection.password);
		con.removeData();
		for (int i=0;i<data.link.length;i++) {
			con.execute("CREATE(Link"+i+":Link{Link: '"+data.link[i]+"'})");
			con.execute(" RETURN a ");
			con.execute("MATCH (b:Link) WHERE b.Link = a.Link RETURN b ");
			con.execute("CREATE(a)-[:XUAT_HIEN_TRONG]->(b)");
			}
		try {
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		a.CreateNodePerson(20);
	}
}
cvdmsokvnewokngvfeoikwnm
