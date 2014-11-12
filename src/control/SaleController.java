package control;

import java.util.List;

import model.Item;
import model.Sale;

public class SaleController {
	
	public static Sale	createFromString(String obj) {
		String[] values = obj.split("ç");
		
		ItemController creator = new ItemController();
		Long id = Long.parseLong(values[1]);
		List<Item> items = creator.createItemsListFromString(values[2]);
		String salesmanName = values[3];
		
		return new Sale(id, items, salesmanName);
	}
}
