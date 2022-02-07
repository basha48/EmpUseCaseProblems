package com.employee.wages;

public interface IComputeEmpWage {

	public void addcompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHrsPerMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
	
}

