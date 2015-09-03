package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registrant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String idNo;
	private String course;
	private String contactNo;
	private String email;
	private String membershipType;
	private String receiptNo;
	
	protected Registrant(){}

	public Registrant(String name, String idNo, String course,
			String contactNo, String email, String membershipType,
			String receiptNo) {
		super();
		this.name = name;
		this.idNo = idNo;
		this.course = course;
		this.contactNo = contactNo;
		this.email = email;
		this.membershipType = membershipType;
		this.receiptNo = receiptNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	@Override
	public String toString() {
		return "Registrant [id=" + id + ", name=" + name + ", idNo=" + idNo
				+ ", course=" + course + ", contactNo=" + contactNo
				+ ", email=" + email + ", membershipType=" + membershipType
				+ ", receiptNo=" + receiptNo + "]";
	}

	
	
}
