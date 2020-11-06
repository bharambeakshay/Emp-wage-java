/*
 * developed by :@akshaybharambe
 * 
 * */

//UC11EmployeeWageBuilder  Interface approach array

interface IComputeWage {
	public void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maximumHoursPerMonth);
	public void computeEmpWage();
}

class CompanyEmpWageCal {
	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maximumHoursPerMonth;
	public int totalWage;
	public CompanyEmpWageCal(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maximumHoursPerMonth = maximumHoursPerMonth;
	}
	public void setTotalEmpWage(int totalWage){
		this.totalWage=totalWage;
	}
	public String toString() {
		return "Total Employee Wage for "+company+" is "+totalWage;
	}
}

public class UC11EmployeeWageBuilder implements IComputeWage{
	public static final int isPartTime = 1;
	public static final int isFullTime = 2;
	private int numOfCompany;
	private CompanyEmpWageCal empWageArray[];
	public UC11EmployeeWageBuilder() {
		empWageArray=new CompanyEmpWageCal[5];
	}
	@Override //annotation==>method is overridden in child class
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {
		empWageArray[numOfCompany]=new CompanyEmpWageCal(company,empRatePerHour,numOfWorkingDays,maximumHoursPerMonth);
		numOfCompany++;
	}

	@Override
	public void computeEmpWage() {
		for(int i=0;i<numOfCompany;i++) {
			empWageArray[i].setTotalEmpWage(this.computeEmpWage(empWageArray[i]));
			System.out.println(empWageArray[i]);
		}	
		
	}
	private int computeEmpWage(CompanyEmpWageCal companyEmpWage) {
		int empHours=0, totalEmpHours=0, totalWorkingDays=0;
		 while(totalEmpHours<=companyEmpWage.maximumHoursPerMonth && totalWorkingDays<companyEmpWage.numOfWorkingDays){
             int check=(int)(Math.floor(Math.random()*10)%3);
               switch(check){
               case isPartTime:
                       empHours = 4;
                       break;
               case isFullTime:
                       empHours = 8;
                       break;
               default :
                       empHours = 0;
               }
               totalEmpHours+=empHours;
               totalWorkingDays += 1;
 }
		 return totalEmpHours * companyEmpWage.empRatePerHour;

	}
	public static void main(String args[]) {
		UC11EmployeeWageBuilder employeeWageBuilder=new UC11EmployeeWageBuilder();
		employeeWageBuilder.addCompanyEmpWage("IDBI", 18, 18, 90);
		employeeWageBuilder.addCompanyEmpWage("Yahoo", 25, 24, 100);
		employeeWageBuilder.computeEmpWage();
		
	}

	
}
