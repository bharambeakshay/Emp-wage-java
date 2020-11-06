/*
 * developed by :@akshaybharambe
 * 
 * */
//Store the total wage along with daily wage

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

interface IComputeWageOfEmployee {  //If we use public then we have declare this interface in another file
	public void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maximumHoursPerMonth);
	public void computeEmpWage();
}

class CompanyEmployeeWage {  //If we use public then we have declare this class in another file
	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maximumHoursPerMonth;
	public int totalWage;
	public CompanyEmployeeWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {
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

public class UC13EmpWageBuilder implements IComputeWageOfEmployee{
	public static final int isPartTime=1;
	public static final int isFullTime=2;
	private ArrayList<CompanyEmployeeWage> empList;
	private LinkedList<Integer>dailyWage;
	public UC13EmpWageBuilder() {
		empList = new ArrayList<>();
		dailyWage = new LinkedList<>();
	}
	@Override
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {
		CompanyEmployeeWage empWage=new CompanyEmployeeWage(company,empRatePerHour,numOfWorkingDays,maximumHoursPerMonth);
		empList.add(empWage);
	}

	@Override
	public void computeEmpWage() {
		for(int i=0;i<empList.size();i++) {
			empList.get(i).setTotalEmpWage(this.computeEmpWage(empList.get(i)));
			System.out.println(empList.get(i));
		}	
		
	}
	HashMap<String,LinkedList> companyDailyWage=new HashMap<>();
	private  int computeEmpWage(CompanyEmployeeWage companyEmpWage) {
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
               totalWorkingDays +=1;
               dailyWage.add(empHours*companyEmpWage.empRatePerHour);
               
               }
		 companyDailyWage.put(companyEmpWage.company, dailyWage);
		 System.out.println("Daily Wage for the "+companyEmpWage.company+" is :"+dailyWage);
		 dailyWage.clear();
		  return (totalEmpHours*companyEmpWage.empRatePerHour);
		 
	}
	
	public static void main(String args[]) {
		UC13EmpWageBuilder employeeWageBuilder=new UC13EmpWageBuilder();
		employeeWageBuilder.addCompanyEmpWage("IDBI", 18, 18, 90);
		employeeWageBuilder.addCompanyEmpWage("Yahoo", 25, 24, 100);
		employeeWageBuilder.computeEmpWage();
	}
	
}

