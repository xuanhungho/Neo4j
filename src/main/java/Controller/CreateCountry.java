package Controller;

import java.util.Date;
import java.util.Random;

import Data.DataExample;
import Model.Country;

public class CreateCountry{
	
	DataExample data = new DataExample();
	
	public Country randomCountry() {
		Country Country = new Country();
		Country.setNhan(randomNhan());
		Country.setMota(randomMoTa());
		Country.setLink(randomLink());
		Country.setDate(randomThoiGian());
		Country.setDinhdanh(randomDinhDanh());
		return Country;
	}

	public String randomNhan() {
		String nhan = null ;
		nhan = data.quoctich[new Random().nextInt(data.event.length)];
		return nhan;
	}

	public String randomMoTa() {
		String des = null;
		des = data.quoctich[new Random().nextInt(data.quoctich.length)];
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
		String nhan = null ;
		nhan = data.quoctich[new Random().nextInt(data.quoctich.length)];
		return nhan;
	}
	
	public String randomDiaDiem() {
		String nhan = null ;
		nhan = data.quoctich[new Random().nextInt(data.event.length)];
		return nhan;
	}
	
}
