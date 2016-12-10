package mx.utng.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Provider {
	@Id @GeneratedValue
	private Long id;
	private String firstname;
	private String lastname;
	private int telephone;
	
	public Provider(String firstname, String lastname, int telephone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephone = telephone;
	}
	
	public Provider(){
		this("","",0);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
	

	

}
