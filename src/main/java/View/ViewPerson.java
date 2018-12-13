package View;

import Controller.CreatePerson;

public class ViewPerson {
	CreatePerson person;
	public ViewPerson() {
		// TODO Auto-generated constructor stub
		person  = new CreatePerson();
		
		System.out.println("Thuc the Person: Ten: "+person.randomNhan()+"; Dinh danh: "+person.randomDinhDanh(1)
		+"; Tuoi: "+person.randomAge()+"; Quoc tich: "+person.randomQuocTich()+"; Ngay: "+person.randomThoiGian()
		+"; Mota: "+person.randomMoTa()+"; Link: "+person.randomLink());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ViewPerson();
		
	}

}
