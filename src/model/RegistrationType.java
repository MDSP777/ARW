package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RegistrationType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String typeName;
	private double amount;
	
	protected RegistrationType(){}
	
	public RegistrationType(String typeName, double amount) {
		super();
		this.typeName = typeName;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "RegistrationType [id=" + id + ", typeName=" + typeName
				+ ", amount=" + amount + "]";
	}
	
	
}
