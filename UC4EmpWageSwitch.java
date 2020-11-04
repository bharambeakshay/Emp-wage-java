//calculation of empwage using switch
public class UC4EmpWageSwitch{
	public static void main(String aargs[]){
        SwitchCaseWage wage = new SwitchCaseWage();
        wage.calculate();
	}
}

class SwitchCaseWage{
	final static int isPartTime=1;
    final static int isFullTime=2;
    int salary = 0;
    int empRatePerHour = 20;
    int empHours = 0;
    public void calculate(){
        int check=(int)(Math.floor(Math.random()*10)%3);
        switch(check){
        	case isPartTime :
        		empHours = 4;
                break;
            case isFullTime :
                empHours = 8;
                break;
            default :
                empHours=0;
        }
        salary=empRatePerHour*empHours;
        System.out.println("Employee Salary for the day is " +salary);
    }
}

