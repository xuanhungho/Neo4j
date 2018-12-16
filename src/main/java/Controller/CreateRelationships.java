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
					"AND per.LinkTrichRut = event.LinkTrichRut AND per.ThoiGianTrichRut=event.ThoiGianTrichRut\r\n"
					+ "WITH DISTINCT per, event CREATE (per)-[:THAM_GIA]->(event)");
			
			ConnectionDB.cn.execute("MATCH (per:Person),(event:Event) WHERE per.Nhan = event.DaiDien\r\n" + 
					"AND per.LinkTrichRut = event.LinkTrichRut CREATE (per)-[:DAI_DIEN]->(event)");
			
			ConnectionDB.cn.execute("MATCH (per:Person),(country:Country) WHERE per.Quoctich = country.Nhan\r\n" + 
					"AND per.LinkTrichRut = country.LinkTrichRut WITH DISTINCT per, country CREATE (per)-[:QUOC_TICH]->(country)");
			
			ConnectionDB.cn.execute("MATCH (per:Person),(loca:Location),(time:Time) WHERE per.Quoctich <> loca.Nhan\r\n" + 
					"AND per.LinkTrichRut = loca.LinkTrichRut  "
					+ "AND time.LinkTrichRut = loca.LinkTrichRut"
					+ " AND per.LinkTrichRut = time.LinkTrichRut WITH DISTINCT per, loca "
					+ "CREATE (per)-[:DEN_THAM]->(loca)");
			
			ConnectionDB.cn.execute("MATCH (per:Person),(loca:Location),(time:Time) WHERE per.Quoctich <> loca.Nhan\r\n" + 
					"AND per.LinkTrichRut = loca.LinkTrichRut  "
					+ "AND time.LinkTrichRut = loca.LinkTrichRut"
					+ " AND per.LinkTrichRut = time.LinkTrichRut WITH DISTINCT loca,time "
					+ "CREATE (loca)-[:DEN_THAM_VAO]->(time)");
		
			ConnectionDB.cn.execute("MATCH (event:Event),(loca:Location),(time:Time) WHERE event.DiaDiem = loca.Nhan\r\n" + 
					"AND event.LinkTrichRut = loca.LinkTrichRut AND loca.LinkTrichRut = time.LinkTrichRut "
					+" AND event.LinkTrichRut = time.LinkTrichRut"
					+ " WITH DISTINCT event, loca CREATE (event)-[:DIEN_RA_TAI]->(loca)");
			
			ConnectionDB.cn.execute("MATCH (event:Event),(loca:Location),(time:Time) WHERE event.DiaDiem = loca.Nhan\r\n" + 
					"AND event.LinkTrichRut = loca.LinkTrichRut AND loca.LinkTrichRut = time.LinkTrichRut "
					+" AND event.LinkTrichRut = time.LinkTrichRut"
					+ " WITH DISTINCT loca, time CREATE (loca)-[:DIEN_RA_VAO]->(time)");
			
//			ConnectionDB.cn.execute("MATCH (event:Event),(time:Time) WHERE event.LinkTrichRut = time.LinkTrichRut\r\n" + 
//					"WITH DISTINCT event, time CREATE (event)-[:THOI_GIAN]->(time)");
			
			ConnectionDB.cn.execute("MATCH (org:Organization),(loca:Location) WHERE org.TruSo = loca.Nhan\r\n" + 
					"AND org.LinkTrichRut = loca.LinkTrichRut WITH DISTINCT org, loca CREATE UNIQUE (org)-[:TRU_SO]->(loca)");
			
			ConnectionDB.cn.execute("MATCH (loca:Location),(country:Country) WHERE loca.QuocGia = country.Nhan\r\n" + 
					"AND loca.LinkTrichRut = country.LinkTrichRut WITH DISTINCT loca, country CREATE (loca)-[:THUOC]->(country)");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
	}
}
