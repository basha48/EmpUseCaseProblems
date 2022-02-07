package com.employee.wages;

public class EmployeeWages {
	
	private   int wagePerHr ;
	private   int noOfWoringDays ;
	private   int maxHrsMonths ;
	private   String company ;
	
	private static int PART_TIME_PRESENT =2;
	private static int PART_TIME_WORK_HR =4;
	private static int FULL_TIME_PRESENT =1;
	private static int FULL_TIME_WORK_HR =8;
	private static int SALARY_PER_HR =20;
	
	public void welcomeMessage() {
		System.out.println("welcome to employee wage computation prgram");
	}
	
	public void getAttendance() {
		
		int checkStatus = (int) (Math.floor(Math.random() * 10) %  2);
		if(checkStatus == 0)
			System.out.println("emp is absent");
		else
			System.out.println("emp is present");
		
	}
	
	public void getPartTime() {
		
		int workHr;
		int dailyWage;
		double emp = Math.floor(Math.random() * 10) %  3;
		if (emp == 	FULL_TIME_PRESENT) {
		System.out.println("Employee is present");
		workHr = FULL_TIME_WORK_HR;
		}
		else if (emp == PART_TIME_PRESENT) {
			System.out.println("Employee is part timer");
			workHr = PART_TIME_WORK_HR;
		}
		else{
		System.out.println("Employee is absent");
		workHr = 0;
		}
		
		dailyWage= (SALARY_PER_HR * workHr);
		System.out.println("salary will be" + dailyWage);
		
	}
	
		
		public  void usingSwitchCase() {
			
			int workHr = 0;
			int emp = (int) Math.floor(Math.random() * 10) %  3;
			switch(emp) { 
				case 1:
					System.out.println("Employee is present");
					workHr = FULL_TIME_WORK_HR;
					break;
				case 2:
					System.out.println("Employee is parttimer");
					workHr = PART_TIME_WORK_HR;
					break;
				case 3:
					System.out.println("Employee is absent");
					workHr = 0;
					break;
				default:
					System.out.println("contition doesnot exit");
			}
			
			int dailyWage = (SALARY_PER_HR * workHr);
			System.out.println("salary will be");
			System.out.println(dailyWage);
	}
		
		public void getWagePerMonth() {
			
			int empHr = 0;
			int total = 0;
			int days = 0;
			int workHr = 0;
			
			while( days<20 ) {
				
			int emp = (int) Math.floor(Math.random() * 10) %  3;
			switch(emp) { 
				case 1:
					System.out.println("Employee is present");
					empHr = 8;
					break;
				case 2:
					System.out.println("Employee is PartTime ");
					empHr = 4;
					break;
				case 3:
					System.out.println("Employee is Absent");
					empHr = 0;
					break;
				default:
					System.out.println("contition doesnot exit");
			}
			int dailyWage = (SALARY_PER_HR * empHr);
			total = (total + dailyWage);
			days = (days + 1);
			workHr = (workHr + empHr);
			}
			System.out.println("totalsalary will be :" + total);
		
			System.out.println("total working hours will be:" + workHr);
			
		}
		
		
		public void maxHrsReached() {
			
			int empHr = 0;
			int total = 0;
			int days = 0;
			int workHr = 0;
			
			while(days < 21 && workHr < 100)
			{
			int emp = (int) Math.floor(Math.random() * 10) %  3;
			switch(emp) { 
				case 1:
					System.out.println("Employee is present");
					empHr = 8;
					break;
				case 2:
					System.out.println("Employee is parttimer");
					empHr = 4;
					break;
				case 3:
					System.out.println("Employee is absent");
					empHr = 0;
					break;
				default:
					System.out.println("contition doesnot exit");
			}
			
				int dailyWage = (SALARY_PER_HR * empHr);
			total = (total + dailyWage);
			days = (days+1);
			workHr = (workHr + empHr);
			}
			
			System.out.println("totalsalary will be: " + total);
			System.out.println(total);
			System.out.println("total working days will be: " + days);
			System.out.println("total working hours will be: " + workHr);
		}
	
		public void getCompanyWage(String company,int wagePerHr,int noOfWoringDays,int maxHrsMonths) {
			
			this.company = company;
			this.wagePerHr = wagePerHr;
			this.noOfWoringDays = noOfWoringDays;
			this.maxHrsMonths = maxHrsMonths;

			int empHr = 0;
			int total = 0;
			int days = 0;
			int workHr = 0;
			
			while(days < noOfWoringDays && workHr < maxHrsMonths)
			{
			int emp = (int) Math.floor(Math.random() * 10) %  3;
			
			switch(emp) { 
				case 1:
					empHr = 8;
					break;
				case 2:
					empHr = 4;
					break;
				case 3:
					empHr = 0;
					break;
				default:
			}
			
			int dailyWage = (wagePerHr * empHr);
			total = (total + dailyWage);
			days = (days+1);
			workHr = (workHr + empHr);
			}
			
			System.out.println("total salary for " + company + "is :" + total);
			System.out.println("total working days will be: " + days);
			System.out.println("total working hours will be: " + workHr);
		}
	
}
