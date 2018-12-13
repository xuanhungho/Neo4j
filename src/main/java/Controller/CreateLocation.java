package Controller;

import java.util.Date; 
import java.util.Random;

import Data.DataExample;
import Model.Location;

public class CreateLocation{
	public Location randomLocaiton() {
		Location Location = new Location();
		Location.setNhan(randomNhan());
		Location.setMota(randomDescription());
		Location.setLink(randomLink());
		Location.setDate(randomThoiGian());
		Location.setDinhdanh(randomDinhDanh());
		Location.setQuocGia(randomQuocGia());
		return Location;
	}

	DataExample data = new DataExample();

	public String randomNhan() {
		String nhan = null ;
		nhan = data.location[new Random().nextInt(data.location.length)];
		return nhan;
	}

	public String randomDescription() {
		String des = null;
		des = data.desquoctich[new Random().nextInt(data.desquoctich.length)];
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
	public String randomDinhDanh() {
		String id;
		id = data.quoctich[new Random().nextInt(data.quoctich.length)];
		return id;
	}
	public String randomQuocGia() {
		String des = null;
		des = data.desquoctich[new Random().nextInt(data.desquoctich.length)];
		return des;
	}

}
