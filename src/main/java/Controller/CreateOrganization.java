package Controller;

import java.util.Date; 
import java.util.Random;

import Data.DataExample;
import Model.Organization;

public class CreateOrganization {
	public Organization randomOrganization() {
		Organization Organization = new Organization();
		Organization.setNhan(randomNhan());
		Organization.setMota(randomDescription());
		Organization.setLink(randomLink());
		Organization.setDate(randomThoiGian());
		Organization.setDinhdanh(randomDinhDanh());
		Organization.setTruSo(randomTruSo());
		return Organization;
	}

	DataExample data = new DataExample();

	public String randomNhan() {
		String nhan = null ;
		nhan = data.nameOrganization[new Random().nextInt(data.nameOrganization.length)];
		return nhan;
	}

	public String randomDescription() {
		String des = null;
		des = data.descriptionOrganization[new
		                Random().nextInt(data.descriptionOrganization.length)];
		return des;
	}

	public String randomLink() {
		String link ;
		link = data.link[new Random().nextInt(data.link.length)];
		return link;
	}

	public String randomTruSo() {
		String truso;
		truso = data.location[new Random().nextInt(data.location.length)];
		return truso;
	}
	
	public Date randomThoiGian() {
		Date date = new Date();
		return date;
	}
	public String randomDinhDanh() {
		String id;
		id = data.nameOrganization[new Random().nextInt(data.nameOrganization.length)];
		return id;
	}
}
