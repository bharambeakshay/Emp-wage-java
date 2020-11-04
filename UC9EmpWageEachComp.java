//UC9 ability to save total wage to each company
class WageForMonth{
        final int isPartTime=1;
        final int isFullTime=2;
        private int empRatePerHour;
        private int totalDays;
        private int totalHours;
        private String company;
        private int totalSalary;
        WageForMonth(String company,int empRatePerHour,int totalDays,int totalHours){
        	this.company = company;
	        this.empRatePerHour = empRatePerHour;
	        this.totalDays = totalDays;
	        this.totalHours = totalHours;
        }
        public void calculate(){
	        int hours = 0;
	        int days = 0;
	        int salary = 0;
	        int empHours;
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
	                salary = empRatePerHour * empHours;
	                totalSalary = totalSalary + salary;
	        }
        }
    public String toString(){
	        return "Total Employee wage for " + company +" is " + (totalSalary);
	}
}
public class UC9EmpWageEachComp{
	public static void main(String args[]){
		WageForMonth HDFC=new WageForMonth("HDFC",22,25,88);
			HDFC.calculate();
			System.out.println(HDFC);
		WageForMonth Google=new WageForMonth("Google",19,22,100);
        	Google.calculate();
        	System.out.println(Google);
	}
}
