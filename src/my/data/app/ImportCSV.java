package my.data.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import my.data.entity.Country;
import my.data.entity.District;
import my.data.entity.Persistence;
import my.data.entity.State;

/**
 * 
 * 
 * @author shamsulbahrin
 * @since 13 Oct 2022
 */
public class ImportCSV {
	
	static Persistence db = Persistence.db();
	
	public static void main(String[] args) throws Exception {
		
		File f = new File("countries.csv");     
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);  
		String line;  
		while( (line = br.readLine() ) != null ) {  
			String[] s = line.split(",");
			Country country = db.get("select c from Country c where c.name = '" + s[0] + "'");
			if ( country == null ) {
				country = new Country();
				country.setName(s[0]);
				db.save(country);
			}
			State state = db.get("select s from State s where s.name = '" + s[1] + "'");
			if ( state == null ) {
				state = new State();
				state.setName(s[1]);
				state.setCountry(country);
				db.save(state);
			}
			District district = db.get("select d from District d where d.name = '" + s[2] + "' and d.state.id = '" + state.getId() + "'");
			if ( district == null ) {
				district = new District();
				district.setState(state);
				district.setName(s[2]);
				db.save(district);
			}
			System.out.println(country.getName() + ", " + state.getName() + ", " + district.getName());
			
		}
		fr.close();
	}

}
