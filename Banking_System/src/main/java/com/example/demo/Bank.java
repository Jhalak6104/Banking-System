
package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bank 
{
	@Id
	private int id;
	private String name;
	private int amount;
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(int id, String name, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() 
	{
		return "Student [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}
}
