package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
* Taylor Layton - tglayton
* CIS171 22149
* Sep 13, 2023
* Windows 10 
*/
@Entity
@Table(name="force_users")
public class ForceUser {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="LIGHTSABER_COLOR")
	private String lightsaberColor;
	@Column(name="AFFILIATION")
	private String affiliation; 

	public ForceUser() {
		super();
	}

	public ForceUser(String name, String lightsaberColor, String affiliation) {
		this.name = name;
		this.lightsaberColor = lightsaberColor;
		this.affiliation = affiliation;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLightsaberColor() {
		return lightsaberColor;
	}

	public void setLightsaberColor(String lightsaberColor) {
		this.lightsaberColor = lightsaberColor;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String returnForceUserDetails() {
		return this.name + ": " + this.lightsaberColor + " (" + this.affiliation + ")";
	}
}