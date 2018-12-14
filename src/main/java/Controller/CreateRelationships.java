package Controller;
 
public class CreateRelationships {

	public CreateRelationships() {
	}
	
	public void CreateRelationship() {
		try {		
//			ConnectionDB.cn.execute("MATCH (per:Person),(event:Event) WHERE per.Nhan <> event.DaiDien\r\n" + 
//					"AND per.LinkTrichRut = event.LinkTrichRut AND per.Age > '20' AND per.Age < '50' WITH DISTINCT per, event CREATE (per)-[:THAM_GIA]->(event) ");
//			
			ConnectionDB.cn.execute("MATCH (per:Person),(event:Event) WHERE per.Nhan <> event.DaiDien\r\n" + 
					"AND per.LinkTrichRut = event.LinkTrichRut WITH DISTINCT per, event CREATE (per)-[:THAM_GIA]->(event) ");
			
			
			ConnectionDB.cn.execute("MATCH (per:Person),(event:Event) WHERE per.Nhan = event.DaiDien\r\n" + 
					"AND per.LinkTrichRut = event.LinkTrichRut CREATE (per)-[:TO_CHUC]->(event)");
			
			ConnectionDB.cn.execute("MATCH (per:Person),(country:Country) WHERE per.Quoctich = country.Nhan\r\n" + 
					"AND per.LinkTrichRut = country.LinkTrichRut WITH DISTINCT per, country CREATE (per)-[:QUOC_TICH]->(country)");
			
			ConnectionDB.cn.execute("MATCH (per:Person),(country:Country) WHERE per.Quoctich <> country.Nhan\r\n" + 
					"AND per.LinkTrichRut = country.LinkTrichRut AND per.Age > '85' WITH DISTINCT per, country CREATE (per)-[:DEN_THAM]->(country)");
			
			ConnectionDB.cn.execute("MATCH (event:Event),(loca:Location) WHERE event.DiaDiem = loca.Nhan\r\n" + 
					"AND event.LinkTrichRut = loca.LinkTrichRut WITH DISTINCT event, loca CREATE (event)-[:DIEN_RA_TAI]->(loca)");
			
			ConnectionDB.cn.execute("MATCH (event:Event),(time:Time) WHERE event.LinkTrichRut = time.LinkTrichRut\r\n" + 
					"WITH DISTINCT event, time CREATE (event)-[:THOI_GIAN]->(time)");
			
			ConnectionDB.cn.execute("MATCH (org:Organization),(loca:Location) WHERE org.TruSo = loca.Nhan\r\n" + 
					"AND org.LinkTrichRut = loca.LinkTrichRut WITH DISTINCT org, loca CREATE UNIQUE (org)-[:TRU_SO]->(loca)");
			
			ConnectionDB.cn.execute("MATCH (loca:Location),(country:Country) WHERE loca.QuocGia = country.Nhan\r\n" + 
					"AND loca.LinkTrichRut = country.LinkTrichRut WITH DISTINCT loca, country CREATE (loca)-[:THUOC]->(country)");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
	}
}
