package model;

import java.util.List;

public class Sale {
	
	private Long id;
	private List<Item> items;
	private String salesmanName;
	
	public Sale(Long id, List<Item> items, String salesmanName) {
		this.id = id;
		this.items = items;
		this.salesmanName = salesmanName;
	}

	public Long getId() {
		return id;
	}

	public List<Item> getItems() {
		return items;
	}

	public String getSalesman() {
		return salesmanName;
	}
	
	public Double totalSales() {
		Double totalSales = 0.0;
		
		for (Item item : items) {
			totalSales += item.getPrice();
		}
		
		return totalSales;
	}
}
