package file.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class DatFileWritter {
	
	public void writeToReportFile(Integer amountOfCustomers, Integer amountOfSalesman,
			Long mostExpansiveSale, String worstSalesman, String fileName) {
		
		String fileOutput = fileName.replace(".", ".done.");
		
		fileOutput = fileName.replace("/in/", "/out/");
		
		try {
			File file = new File(fileOutput);
			PrintWriter printWriter = new PrintWriter(file);
			
			printWriter.print("The amount of customer is: " + amountOfCustomers + '\n');
			printWriter.print("The amount of Salesman is: " + amountOfSalesman + '\n');
			printWriter.print("The id of the most expansive sale is: " + mostExpansiveSale + '\n');
			printWriter.print("The worst salesman ever is: " + worstSalesman + '\n');
			
			printWriter.close();
			
		} catch (IOException e) {
			System.out.println("Error while writing to the file " + fileOutput + ", error: " + e.getMessage());
		}
	}
}
