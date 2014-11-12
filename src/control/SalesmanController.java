package control;

import model.Salesman;

public class SalesmanController {

	public static Salesman createFromString(String obj) {
		String[] values = obj.split("ç");
		
		String cpf = values[1];
		String name = values[2];
		Double salary = Double.parseDouble(values[3]);
		
		return new Salesman(cpf, name, salary);
	}
}
