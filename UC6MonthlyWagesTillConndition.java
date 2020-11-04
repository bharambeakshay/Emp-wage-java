//find the wages till 100 hours and 20 days
public class UC6MonthlyWagesTillConndition {
	public static void main(String args[]) {
        WageDayHour wage = new WageDayHour();
        wage.calculate();
	}

}

class WageDayHour {
	final int isPartTime = 1;
	final int isFullTime = 2;
    final int empRatePerHour = 20;
    final int totalDays = 20;
    final int totalHours = 100;
    public void calculate(){
        int hours = 0;
        int days = 0;
        int salary = 0;
        int empHours;
        int totalSalary = 0;
        while(hours<=totalHours && days<totalDays){
              int check = (int)(Math.floor(Math.random()*10)%3);
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
                hours += empHours;
                days += 1;
                salary = empRatePerHour*empHours;
                totalSalary = totalSalary+salary;
        }
        System.out.println("Total Salary based on 20 days and 100 Hours of work is " +totalSalary);
    }
}
