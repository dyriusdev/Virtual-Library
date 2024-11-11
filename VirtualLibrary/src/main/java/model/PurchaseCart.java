package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseCart {
	
	private Map<String, ItemPurchase> items;
	
	public PurchaseCart() {
		items = new HashMap<String, ItemPurchase>();
	}
	
	public synchronized void add(Book book) {
		if (items.containsKey(book.getId())) {
			ItemPurchase purchase = items.get(book.getId());
			purchase.increaseAmount();
		} else {
			ItemPurchase purchase = new ItemPurchase(book);
			items.put(book.getId(), purchase);
		}
	}
	
	public synchronized void remove(Book book) {
		if (items.containsKey(book.getId())) {
			ItemPurchase purchase = items.get(book.getId());
			purchase.decreaseAmount();
			if (purchase.getAmount() <= 0) {
				items.remove(purchase);
			}
		}
	}
	
	public synchronized List<ItemPurchase> getList() {
		List<ItemPurchase> result = new ArrayList<ItemPurchase>();
		result.addAll(items.values());
		return result;
	}
	
	public synchronized int getAmountOfItems() {
		int amount = 0;
		for (ItemPurchase purchase : items.values()) {
			amount += purchase.getAmount();
		}
		return amount;
	}
	
	public synchronized double getTotal() {
		double total = 0;
		for (ItemPurchase purchase : items.values()) {
			Book book = purchase.getItem();
			total += (purchase.getAmount() * book.getPrice());
		}
		return total;
	}
	
	public void clear() {
		items.clear();
	}
}