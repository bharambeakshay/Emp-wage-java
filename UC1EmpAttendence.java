class EmployeeAttendance{
        final static int present=1;
public void checkAttendance(){
        int check=(int)(Math.floor(Math.random()*10)%2);
        if(present==check)
        	System.out.println("Present");
        else
        	System.out.println("Absent");
		}
}

public class UC1EmpAttendence{
public static void main(String args[]){
        EmployeeAttendance attendance=new EmployeeAttendance();
        attendance.checkAttendance();
		}
}
		