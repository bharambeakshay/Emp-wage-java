//Calculating monthly wages using for loop

public class UC5MonthlyWage{
public static void main(String args[]){
	wageForMonth wage = new wageForMonth();
        wage.calculate();
	}
}

class wageForMonth{
	final static int isPartTime=1;
    final static int isFullTime=2;
    int salary = 0;
    final int empRatePerHour = 20;
    int empHours = 0;
    final int numberOfWorkingDays = 20;
    int totalSalary = 0;         
    public void calculate(){
    	for(int day = 1; day<=numberOfWorkingDays; day++){
    		int check=(int)(Math.floor(Math.random()*10)%3);
            switch(check){
                case isPartTime:
                        empHours = 4;
                        break;
                case isFullTime :
                        empHours = 8;
                        break;
                default :
                        empHours = 0;
            }
            salary = empRatePerHour * empHours;
            totalSalary += salary;  //salary for 20 days
    	}
                System.out.println("Total wage for 20 days: " +totalSalary);
    }
}

