package model;

public class ItemPurchase {
	
	private final Book item;
	private int amount;
	
	public ItemPurchase(Book product) {
		item = product;
		amount = 1;
	}
	
	public void increaseAmount() { amount++; }
	
	public void decreaseAmount() { amount--; }
	
	public void setAmount(int value) { amount = value; }
	
	public Book getItem() { return item; }
	
	public int getAmount() {
		return amount;
	}
}