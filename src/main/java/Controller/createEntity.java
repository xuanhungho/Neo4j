package Controller;

import java.util.Calendar; 

public class createEntity {

	public createEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public void createEntitys(int personCount, int OrganizatuionCount, int locationCount, int eventCount, int countryCount, int timeCount ) {
		
		long begin = Calendar.getInstance().getTimeInMillis();
		CreatePerson per = new CreatePerson();
		per.CreateNodePerson(personCount);
		
		CreateOrganization Org = new CreateOrganization();
		Org.CreateNodeOrganization(OrganizatuionCount);
		
		CreateLocation location = new CreateLocation();
		location.CreateNodeLocation(locationCount);
		
		CreateEvent event = new CreateEvent();
		event.CreateNodeEvent(eventCount);
		
		CreateCountry country = new CreateCountry();
		country.CreateNodeCountry(countryCount);
		
		CreateTime time = new CreateTime();
		time.CreateNodeTime(timeCount);
		
//		Tạo node Link bài viết và quan hệ tới các node sẵn có
		
		CreateRelationships Rela = new CreateRelationships();
		Rela.CreateRelationship();
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Chèn code qua java: " + (end - begin)+" mili giây!");

	}
}
