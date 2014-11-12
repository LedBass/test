package control;

import java.util.ArrayList;
import java.util.List;

import model.Item;

public class ItemController {

	public Item createFromString(String obj) {
		String[] values = obj.split("-");
		
		Long id = Long.parseLong(values[0]);
		Integer quantity = Integer.parseInt(values[1]);
		Double price = Double.parseDouble(values[2]);
		
		return new Item(id, quantity, price);
	}
	
	public List<Item> createItemsListFromString(String obj) {
		obj = obj.replace('[', ' ');
		obj = obj.replace(']', ' ').trim();
		
		String[] itemInString = obj.split(",");
		List<Item> items = new ArrayList<Item>();
		
		for (String string : itemInString) {
			Item item = createFromString(string);
			items.add(item);
		}
		
		return items;
	}
}
