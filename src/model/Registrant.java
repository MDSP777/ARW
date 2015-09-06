package model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Registrant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String surname;
	private String firstName;
	private String middleName;
	private String idNo;
	private String course;
	private String contactNo;
	private String email;
	@OneToOne
	private RegistrationType membershipType;
	private String receiptNo;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRegistered;
	
	protected Registrant(){}

	public Registrant(String surname, String firstName, String middleName, String idNo, String course,
			String contactNo, String email, RegistrationType membershipType,
			String receiptNo) {
		super();
		this.surname = surname;
		this.firstName = firstName;
		this.middleName = middleName;
		this.idNo = idNo;
		this.course = course;
		this.contactNo = contactNo;
		this.email = email;
		this.membershipType = membershipType;
		this.receiptNo = receiptNo;
		this.dateRegistered = Calendar.getInstance().getTime();
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RegistrationType getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(RegistrationType membershipType) {
		this.membershipType = membershipType;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	@Override
	public String toString() {
		return "Registrant [id=" + id + ", surname=" + surname + ", firstName="
				+ firstName + ", middleName=" + middleName + ", idNo=" + idNo
				+ ", course=" + course + ", contactNo=" + contactNo
				+ ", email=" + email + ", membershipType=" + membershipType
				+ ", receiptNo=" + receiptNo + ", dateRegistered="
				+ dateRegistered + "]";
	}

	public String getMembershipTypeName() {
		return membershipType.getTypeName();
	}

	public boolean hasIdenticalNameWith(Registrant other) {
		if(firstName.equals(other.firstName) 
			&& surname.equals(other.surname)
			&& middleName.equals(other.middleName)){
			return true;
		}
		return false;
	}
	
		
}
