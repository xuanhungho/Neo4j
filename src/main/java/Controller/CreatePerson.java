package Controller;

import java.util.Calendar; 
import java.util.Date; 
import java.util.Random;
import Data.DataExample;
import Model.Person;

public class CreatePerson{
	
	private String Tempid;
	DataExample data = new DataExample();
	
	public String lastName() {
		String lastName = null ;
		lastName = data.lastName[new Random().nextInt(data.lastName.length)];
		this.Tempid = lastName;
		return lastName;
	}
	
	public String randomDinhDanh(int id) {
		String nhan = null ;
		nhan = this.Tempid + id;
		return nhan;
	}

	public String randomMoTa() {
		String des = null;
		des = data.descriptionPerson[new
		                Random().nextInt(data.descriptionPerson.length)];
		return des;
	}
	
	public String randomLink() {
		String link ;
		link = data.link[new Random().nextInt(data.link.length)];
		return link;
	}
	
	
	public Date randomThoiGian() {
		Date date = new Date();
		return date;
	}
	
	public String randomNhan() {
		String id;
		id = data.firstName[new Random().nextInt(data.firstName.length)]+" "+
				data.midName[new Random().nextInt(data.midName.length)]+" "+lastName();
		return id;
	}
	
	public int randomAge() {
		
		return new Random().nextInt(90);
	}

	public String randomJob() {
		String job;
		job = data.job[new Random().nextInt(data.job.length)];
		return job;
	}

	public String randomQuocTich() {
		String qt;
		qt = data.quoctich[new Random().nextInt(data.quoctich.length)];
		return qt;
	}
	
//	public Person randomPerson(int id) {
//		Person Person = new Person();
//		Person.setNhan(randomDinhDanh(id));
//		Person.setMota(randomMoTa());
//		Person.setLink(randomLink());
//		Person.setDate(randomThoiGian());
//		Person.setAge(randomAge());
//		Person.setDinhdanh(randomNhan());
//		Person.setJob(randomJob());
//		Person.setQuoctich(randomQuocTich());
//		return Person;
//	}

	public void CreateNodePerson(int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		Person Person = new Person();

		try {
			for(int i=0; i<num; i++) {	
				Person.setNhan(randomNhan());
				Person.setDinhdanh(randomDinhDanh(i));
				Person.setMota(randomMoTa());
				Person.setLink(randomLink());
				Person.setDate(randomThoiGian());
				Person.setAge(randomAge());
				Person.setJob(randomJob());
				Person.setQuoctich(randomQuocTich());

		ConnectionDB.cn.execute("CREATE ("+Person.getDinhdanh()+":Person { "
					+ "DinhDanh: '"+Person.getDinhdanh()+"', "
					+ "Nhan: '"+Person.getNhan()+"', "
					+ "Mota: '"+Person.getMota()+"', "
					+ "LinkTrichRut: '"+Person.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Person.getDate()+"', "
					+ "Age: '"+Person.getAge()+"', "
					+ "Job: '"+Person.getJob()+"', "
					+ "Quoctich: '"+Person.getQuoctich()+"'})");
		System.out.println("Da them "+Person.getDinhdanh()+"!");
		}	
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thời gian thực hiện: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

}
