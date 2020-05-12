package fit.se.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.bson.types.ObjectId;

@Entity
@Table(name = "people")
@NamedQueries({
	@NamedQuery(name = "getAll", query = "Select p From Person p")
})
public class Person implements Serializable {


	private static final long serialVersionUID = -7569152010615806993L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId id;
	private String name;
	private String country;

	public Person() {
	}   

	public Person(String name, String country) {
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", country=" + country + "]";
	}

	public ObjectId getId() {
		return id;
	}
}
