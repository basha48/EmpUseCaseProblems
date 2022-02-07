package com.employee.wages;

public class EmpWageBuilderArray {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	private int noOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;
	
	public EmpWageBuilderArray() {
		companyEmpWageArray = new CompanyEmpWage[5];
	}
	
	private void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHrsPerMonth) {
		companyEmpWageArray[noOfCompany] = new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHrsPerMonth);
		noOfCompany++;
	}
	
	private void computeEmpWage() {
		for(int i = 0;i < noOfCompany; i++) {
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
		}
		
	}

	private int computeEmpWage(CompanyEmpWage companyEmpWage) {
		
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
		
		System.out.println("Totalwage for  " + companyEmpWage.company + " is " +TotalWage );
		
		return (totalEmpHrs * companyEmpWage.empRatePerHour);
		
		
	}
	
	public static void main(String [] args) {
		EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();
		empWageBuilder.addCompanyEmpWage("Demart", 20, 15, 10);
		empWageBuilder.addCompanyEmpWage("Relance",10,4, 20);
		empWageBuilder.computeEmpWage();
		
	}
	
	
}
