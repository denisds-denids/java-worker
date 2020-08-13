package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;


public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		Department departmentName = new Department();
		departmentName = new Department(sc.nextLine());
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double workerBaseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, departmentName);
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		double valuePerHour;
		int duration;
		for(int i = 0 ; i<n ; i++) {
			HourContract hourContract = new HourContract();
			
			System.out.printf("\nEnter contract #%d data:\n", i+1);
			System.out.printf("Date (DD/MM/YYYY): ");
			sc.nextLine();
			Date contractData = sdf.parse(sc.nextLine());
			System.out.print("Value per hour: ");
			valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			duration = sc.nextInt();
			hourContract = new HourContract(contractData, valuePerHour, duration);
			worker.addContract(hourContract);
		}
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
		System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
		sc.nextLine();
		Date incomeData = sdf2.parse(sc.nextLine());
		Calendar cal = Calendar.getInstance();
		cal.setTime(incomeData);
		int month = 1 + cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		
		System.out.println("Name: "+ worker.getName());
		System.out.println("Department: " + worker.getDepartment());
		System.out.print("Income for " + sdf2.format(incomeData));
		System.out.printf(": %.2f", worker.income(year, month));
		
		
		
		
		
		
		
		
		sc.close();

	}

}
