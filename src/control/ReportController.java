package control;

import java.util.List;

import file.io.DatFileWritter;
import model.Customer;
import model.Sale;
import model.Salesman;

public class ReportController {
	
	public void createReport(List<Customer> customers, 
			List<Salesman> salesmans, List<Sale> sales, String fileName) {
		
		Integer amountOfCustomers = customers.size();
		Integer amountOfSalesman = salesmans.size();
		
		Long mostExpansiveSale = getMostExpansiveSale(sales);
		
		String worstSalesman = getWorstSalesman(salesmans, sales);
		
		DatFileWritter fileWritter = new DatFileWritter();
		
		fileWritter.writeToReportFile(amountOfCustomers, amountOfSalesman, mostExpansiveSale, worstSalesman, fileName);
		
	}
	
	private Long getMostExpansiveSale(List<Sale> sales) {
		Double expansiveSale = 0.0;
		Long expesiveSaleId = null;
		
		for (Sale sale : sales) {
			if (sale.totalSales() > expansiveSale) {
				expansiveSale = sale.totalSales();
				expesiveSaleId = sale.getId();
			}
		}
		
		return expesiveSaleId;
	}
	
	private String getWorstSalesman(List<Salesman> salesmans, List<Sale> sales) {
		
		Double cheaperSale = 0.0;
		String worstSalesman = "";
		
		for (Salesman salesman : salesmans) {
			Double totalSales = 0.0;
			for (Sale sale : sales) {
				if (salesman.getName().equalsIgnoreCase(sale.getSalesman())) {
					totalSales += sale.totalSales();
					if (totalSales < cheaperSale || cheaperSale == 0.0) {
						cheaperSale = totalSales;
						worstSalesman = salesman.getName();
					}
				}
			}
		}
		
		return worstSalesman;
	}
}
