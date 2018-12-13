package Controller;

import java.util.Date; 
import java.util.Random;

import Data.DataExample;
import Model.Event;

public class CreateEvent{
	
	DataExample data = new DataExample();
	
	public Event randomEvent() {
		Event Event = new Event();
		Event.setNhan(randomNhan());
		Event.setMota(randomMoTa());
		Event.setLink(randomLink());
		Event.setDate(randomThoiGian());
		Event.setDiadiem(randomDiaDiem());
		Event.setDinhdanh(randomDinhDanh());
		Event.setDaidientochuc(randomDaiDien());
		Event.setTime(randomTime());
		return Event;
	}

	public String randomNhan() {
		String nhan = null ;
		nhan = data.event[new Random().nextInt(data.event.length)];
		return nhan;
	}

	public String randomMoTa() {
		String des = null;
		des = data.event[new Random().nextInt(data.event.length)];
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
		nhan = data.event[new Random().nextInt(data.event.length)];
		return nhan;
	}
	
	public String randomDiaDiem() {
		String nhan = null ;
		nhan = data.location[new Random().nextInt(data.location.length)];
		return nhan;
	}
	
	public String randomDaiDien() {
		String nhan = null ;
		nhan = data.firstName[new Random().nextInt(data.firstName.length)]+" "+
				data.midName[new Random().nextInt(data.midName.length)]+" "+
				data.lastName[new Random().nextInt(data.lastName.length)];
		return nhan;
	}

	public Date randomTime() {
		Date date = new Date();
		return date;
	}
}
