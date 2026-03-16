package org.example.OneToMany;
import javax.persistence.*;
@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="person_seq")
	@SequenceGenerator(name="person_seq", sequenceName="person_sequence", initialValue=101, allocationSize=1)
	private int personId;
	private String personName;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="passport_id")
	private Passport passport;
	public Person() {
		
	}
	public Person(String personName, Passport passport) {
		this.personName=personName;
		this.passport=passport;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String toString() {
		return "PersonId: "+personId+"PersonNAme: "+personName+"PassportId: "+passport.getPassportId()+"PassortNumber: "+passport.getPassportNumber()+"country: "+passport.getCountry();
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}

}
