package file.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Sale;
import model.Salesman;
import control.CustumerController;
import control.ReportController;
import control.SaleController;
import control.SalesmanController;

public class DatFileReader {
	
	private String fileName;
	private List<Customer> customers = new ArrayList<Customer>();
	private List<Salesman> salesmans = new ArrayList<Salesman>();
	private List<Sale> sales = new ArrayList<Sale>();
	
	public DatFileReader(String fileName) {
		this.fileName = fileName;
	}
	
	public void readFile() {
		try {
			FileReader reader = new FileReader(fileName);			
			BufferedReader bf = new BufferedReader(reader);
			String line;
			
			while ((line = bf.readLine()) != null) {
				createObjectsFromString(line);
			}
			
			bf.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error while creating a reader for the file " +
					fileName + "error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error while reading the file " +
					fileName + "error: " + e.getMessage());
		}
		
		ReportController controller = new ReportController();
		
		controller.createReport(customers, salesmans, sales, fileName);
	}
	
	private void createObjectsFromString(String obj) {
		
		if (obj.startsWith("001")) {
			Salesman salesman = SalesmanController.createFromString(obj);
			salesmans.add(salesman);
			
		} else if (obj.startsWith("002")) {
			Customer customer = CustumerController.createFromString(obj);
			customers.add(customer);
			
		} else if (obj.startsWith("003")) {
			Sale sale = SaleController.createFromString(obj);
			sales.add(sale);
			
		} else {
			System.out.println("Object unrecognized!");
		}
	}
}
