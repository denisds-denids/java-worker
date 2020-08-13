package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	
	private List<HourContract> contract = new ArrayList<>();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getDepartment() {
		return department.getName();
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContract() {
		return contract;
	}
	
	public void addContract(HourContract contract) {
		this.contract.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		this.contract.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HourContract con : contract) {
			cal.setTime(con.getDate());
			int con_year = cal.get(Calendar.YEAR);
			int con_month = 1 + cal.get(Calendar.MONTH);
			
			if(month ==  con_month && year == con_year) {
				sum += con.totalValue();
			}			
		}
		
		return sum;
	}
	
}
