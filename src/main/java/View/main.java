package View;

import java.util.Calendar;

import Controller.ConnectionDB;
import Controller.CreateCountry;
import Controller.CreateEvent;
import Controller.CreateLocation;
import Controller.CreateOrganization;
import Controller.CreatePerson;
import Controller.CreateTime;
import Data.Connection;

public class main {
	public static int num = 4;
	public static void main(String[] args) {
		try {
			ConnectionDB cn = new ConnectionDB(Connection.host,Connection.username,Connection.password);
			cn.removeData();
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				}
		
		CreatePerson per = new CreatePerson();
		per.CreateNodePerson(num);
		
		CreateOrganization Org = new CreateOrganization();
		Org.CreateNodeOrganization(num);
		
		CreateLocation location = new CreateLocation();
		location.CreateNodeLocation(num);
		
		CreateEvent event = new CreateEvent();
		event.CreateNodeEvent(num);
		
		CreateCountry country = new CreateCountry();
		country.CreateNodeCountry(num);
		
		CreateTime time = new CreateTime();
		time.CreateNodeTime(num);
		
		System.out.println("Done!");
	}
}
