package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Library {
	
	private List<Book> stock;
	
	public Library() {
		stock = new ArrayList<Book>();
		popular();
	}
	
	private void popular() {
		
	}
	
	public List<Book> getBooks() { return stock; }
	
	public Book getBook(String id) throws Exception {
		Book find = null;
		
		for (Book book : stock) {
			if (book.getId().equals(id)) {
				find = book;
				break;
			}
		}
		
		if (find == null) {
			throw new Exception("Cant find book : " + id);
		}
		
		return find;
	}
	
	public void purchaseBooks(PurchaseCart cart) throws Exception {
		Collection<ItemPurchase> items = cart.getList();
		Iterator<ItemPurchase> iterator = items.iterator();
		
		while (iterator.hasNext()) {
			ItemPurchase purchase = iterator.next();
			Book book = purchase.getItem();
			String id = book.getId();
			int amount = purchase.getAmount();
			purchaseBook(id, amount);
		}
	}
	
	public void purchaseBook(String id, int amountPurchased) throws Exception {
		Book selectedBook;
		
		try {
			selectedBook = getBook(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		int amountInStock = selectedBook.getAmount();
		
		if (amountInStock - amountInStock >= 0) {
			int newAmount = amountInStock - amountInStock;
			selectedBook.setAmount(newAmount);
		} else {
			throw new Exception("Book " + id + " not in sufficient stock");
		}
	}
}