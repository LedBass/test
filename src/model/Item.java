package model;

public class Item {
	private Long id;
	private Integer quantity;
	private Double price;
	
	public Item(Long id, Integer quantity, Double price) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Item(String stringFromFile) {
		String[] values = stringFromFile.split("-");
		
		this.id = Long.parseLong(values[0]);
		this.quantity = Integer.parseInt(values[1]);
		this.price = Double.parseDouble(values[2]);
	}

	public Long getId() {
		return id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}
}
