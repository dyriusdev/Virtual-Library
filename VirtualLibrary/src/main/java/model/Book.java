package model;

public class Book {
	
	private String id, title, author, description;
	private int year, amount;
	private double price;
	
	public Book() {}
	
	
	
	public void setId(String value) { id = value; }
	
	public String getId() { return id; }
	
	public void setTitle(String value) { title = value; }
	
	public String getTitle() { return title; }
	
	public void setAuthor(String value) { author = value; }
	
	public String getAuthor() { return author; }
	
	public void setDescription(String value) { description = value; }
	
	public String getDescription() { return description; }
	
	public void setYear(int value) { year = value; }
	
	public int getYear() { return year; }
	
	public void setAmount(int value) { amount = value; }
	
	public int getAmount() { return amount; }
	
	public void setPrice(double value) { price = value; }
	
	public double getPrice() { return price; }
}