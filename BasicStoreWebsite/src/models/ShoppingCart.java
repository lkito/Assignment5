package models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	List<Item> items;
	
	public ShoppingCart() {
		items = new ArrayList<Item>();
	}

	public void addItem(Item it) {
		items.add(it);
	}
	
	public void removeItem(String id) {
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getId().equals(id)) {
				items.remove(i);
				break;
			}
		}
	}
	
	public boolean containsItem(String id) {
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
}
