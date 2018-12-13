package Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Create {

	public Create() {
		// TODO Auto-generated constructor stub
	}
	public void CreateNumberPerson(int k){
		CreatePerson a = new CreatePerson();
		try {
				File f = new File("C:/Users/Xuan Hung/Desktop/test.txt");
				FileWriter fw = new FileWriter(f);
				for (int i=0;i<k;i++) {
					fw.write(a.randomNhan()+"\r\n");
					}
				fw.close(); 
		} catch (IOException ex) {
			System.out.println("Lỗi ghi file: " + ex);
			}
		System.out.println("Đã ghi "+ k +" tên!");
	}
}
