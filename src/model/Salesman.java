package model;

public class Salesman {

	private String cpf;
	private String name;
	private Double salary;
	private Double totalSales;
	
	public Salesman(String cpf, String name, Double salary) {
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}

	public String getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}

	public Double getSalary() {
		return salary;
	}
	
	public Double getTotalSales() {
		return totalSales;
	}
	
	public void setTotalSales(Double totalSales) {
		this.totalSales = totalSales;		
	}
}
