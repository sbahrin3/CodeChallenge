package my.data.app;

import java.util.List;

import my.data.entity.Country;
import my.data.entity.Persistence;

/**
 * 
 * @author shamsulbahrin
 * @since 13 Oct 2022
 */
public class Test {

	public static void main(String[] args) {
		
		Persistence db = Persistence.db();
		
		
		List<Country> countries = db.list("select c from Country c");
		countries.forEach(c -> {
			c.getStates().forEach(s -> {
				s.getDistricts().forEach(d -> {
					System.out.println(c.getName() + ", " + s.getName() + ", " + d.getName());
				});
			});
		});
		
	}

}
