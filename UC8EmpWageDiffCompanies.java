//calculating employee wage for different companies 
public class UC8EmpWageDiffCompanies {
	 final static int isPartTime = 1;
     final static int isFullTime = 2;
     public static void calculate(String company,int empRatePerHour,int totalDays,int totalHours){
	     int hours = 0;
	     int days = 0;
	     int empHours;
	     while(hours <=totalHours && days<totalDays){
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
	     }
	     int totalEmpWage=hours*empRatePerHour;
         System.out.println("Total Salary in  the "+company+" is: "+totalEmpWage);
     }
     public static void main(String args[]){
    	 calculate("HDFC",12,25,120);
    	 calculate("Google",25,20,110);
    	 calculate("Murphy Richards",33,29,80);
    	 calculate("Airtel",23,22,50);
     }

}
