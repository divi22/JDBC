import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Starter {
	static void showMenu() {

		System.out.println("1-add employee");
		System.out.println("2-get employee details");
		System.out.println("3-update employee");
		System.out.println("4-delete employee");
		System.out.println("5-Exit");
		
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		Employee emp=new Employee();
		EmployeeDao dao=new EmployeeDao();
		
		while(true) {
			showMenu();
			System.out.println("Enter choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Add new employee");
				System.out.println("Enter employee id:");
				Integer eid=sc.nextInt();
				System.out.println("Enter employee name:");
				String name=sc.next();
				System.out.println("Enter salary:");
				Integer sal=sc.nextInt();
				System.out.println("Enter city:");
				String city=sc.next();
				
				emp.setEmpId(eid);
				emp.setEmpName(name);
				emp.setSalary(sal);
				emp.setCity(city);
				
				  
			    EmployeeDao eo=new EmployeeDao();
			    Integer rows=eo.addEmployee(emp);
			    System.out.println(rows+" row(s) inserted successfully");
			    
			    break;
			case 2:
				System.out.println("Display employee details");
				List<Employee> elist=new ArrayList<Employee >();
				elist=dao.getEmployee(emp);
				break;
			case 3:
				System.out.println("Update employee salary");
				System.out.println("Enter employee id:");
				 eid=sc.nextInt();
				System.out.println("\n Enter employee new salary" );
				sal=sc.nextInt();
				rows=dao.updateEmployee(eid,sal);
				  System.out.println(rows+"row(s) inserted successfully");
				break;
			case 4:
				System.out.println("Delete employee details");
				System.out.println("Enter employee id:");
				eid=sc.nextInt();
				rows=dao.deleteEmployee(eid);
				 System.out.println(rows+"row(s) inserted successfully\n");
				break;
			case 5:
				sc.close();
				System.exit(0);
				break;
				
				
				
			}
				
				
			}
		}
		

	}


