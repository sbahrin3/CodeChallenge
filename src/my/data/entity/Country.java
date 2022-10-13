package my.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Shamsul Bahrin
 *
 */

@Entity
@Table(name="country")
public class Country {
	
	@Id @Column(length=50)
	private String id;
	@Column(length=100)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="country")
	private List<State> states;
	
	public Country() {
		this.id = UIDGenerator.getUID();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	
	

}
