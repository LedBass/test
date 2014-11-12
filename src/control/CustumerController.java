package control;

import model.Customer;

public class CustumerController {

	public static Customer createFromString(String obj) {
		if (obj == null) {
			throw new IllegalArgumentException("The string cannot be null!");
		}
		
		String[] values = obj.split("ç");
		
		String cnpj = values[1];
		String name = values[2];
		String businessArea = values[3];
		
		return new Customer(cnpj, name, businessArea);
	}
}
