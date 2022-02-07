package com.employee.wages;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class EmpWageBuilder implements IComputeEmpWage {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	private int noOfCompany = 0;

	private LinkedList<CompanyEmpWage> CompanyEmpWageList;
	private Map<String,CompanyEmpWage> CompanyToEmpWageMap;
	
	public EmpWageBuilder() {
		CompanyEmpWageList = new LinkedList<>();
		CompanyToEmpWageMap = new HashMap<>();
	}
	
	
	@Override
	public void addcompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsPerMonth) {
		CompanyEmpWage  companyEmpWage	= new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHrsPerMonth);
		companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
		CompanyEmpWageList.add(companyEmpWage);
		CompanyToEmpWageMap.put(company,companyEmpWage);
	}

	@Override
	public void computeEmpWage() {
		for(int i = 0;i < CompanyEmpWageList.size(); i++) {
			CompanyEmpWage  companyWage = CompanyEmpWageList.get(i);
			companyWage.setTotalEmpWage(this.computeEmpWage(companyWage));
			System.out.println(companyWage);
		}
	}
	@Override
	public int getTotalWage(String company) {
		// TODO Auto-generated method stub
		return CompanyToEmpWageMap.get(company).totalEmpWage;
	}
	
	public int computeEmpWage(CompanyEmpWage companyEmpWage) {
		
		int empHrs = 0,totalEmpHrs = 0,totalWorkingDays = 0;
		
		while(totalEmpHrs <=companyEmpWage.maxHrsPerMonth && totalWorkingDays <=companyEmpWage.numOfWorkingDays) {
		
			totalWorkingDays++;
			
			int empCheck = (int) Math.floor(Math.random() * 10 ) % 3;
			switch(empCheck) {
			case IS_PART_TIME:
				empHrs = 4;
				break;
			case IS_FULL_TIME:
				empHrs = 8;
				break;
			default :
				empHrs = 8;
				break;
			}
			totalEmpHrs+= empHrs;
			System.out.println("Days " + totalWorkingDays + " Emp Hrs " + empHrs  );
			
		}
		int TotalWage = totalEmpHrs * companyEmpWage.empRatePerHour;
		
		System.out.println("Totalwage for  " + companyEmpWage.company + " is " + TotalWage );
		
		return (totalEmpHrs * companyEmpWage.empRatePerHour);
		
		
	}
	public static void main(String[] args) {
		IComputeEmpWage empWageBuilder = new EmpWageBuilder();
		empWageBuilder.addcompanyEmpWage("Dmart", 20, 2,10);
		empWageBuilder.addcompanyEmpWage("Relance", 10, 4,20);
		//empWageBuilder.computeEmpWage();
		//System.out.println("Total Wage for Dmart Company is " + empWageBuilder.getTotalWage("Dmart"));
	}

}
