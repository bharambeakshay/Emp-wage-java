/*
 * developed by :@akshaybharambe
 * 
 * */

//Ability to manage emp wage of multiple companies using array

class CompanyEmpWage {
	
	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maximumHoursPerMonth;
	public int totalWage;

	public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maximumHoursPerMonth = maximumHoursPerMonth;
	}
	// parameterised method 
	public void setTotalEmpWage(int totalWage){
		this.totalWage = totalWage;
	}
	// toString helps to return in string format
	public String toString() {
		return "Total Employee Wage for "+company+" is "+totalWage;
	}

}



public class UC10EmpWageBuilder{
	public static final int isPartTime=1;
	public static final int isFullTime=2;
	private int numOfCompany; 
	private CompanyEmpWage empWageArray[]; // class-objectArray 
	
	public UC10EmpWageBuilder() {  //classArray-object created in constructor
		empWageArray=new CompanyEmpWage[5];
	}
	
	private void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maximumHoursPerMonth) {
		empWageArray[numOfCompany]=new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maximumHoursPerMonth);
		numOfCompany++;
	}
	//method for increasing array index and assigning values.
	private void computeEmpWage() {
		for(int i=0;i<numOfCompany;i++) {
			empWageArray[i].setTotalEmpWage(this.computeEmpWage(empWageArray[i]));
			System.out.println(empWageArray[i]);
			//System.out.println("hello");
		}
	}
	
	private int computeEmpWage(CompanyEmpWage companyEmpWage) {
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
               totalEmpHours += empHours;
               totalWorkingDays += 1;
 }
		 return totalEmpHours * companyEmpWage.empRatePerHour;

	}
	
	public static void main(String args[]) {
		UC10EmpWageBuilder employeeWageBuilder=new UC10EmpWageBuilder();//41-44
		employeeWageBuilder.addCompanyEmpWage("IDBI", 18, 18, 90);
		employeeWageBuilder.addCompanyEmpWage("Yahoo", 25, 24, 100);
		employeeWageBuilder.computeEmpWage();
		
	}
}