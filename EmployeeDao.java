import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class EmployeeDao {
	
	public Integer addEmployee(Employee e ) throws SQLException {
		//establish connection
		Connection con=null;
		int rows=0;
		
		try {
			//Class.forName("jdbc:oracle.OracleDriver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb","root","root");
			System.out.println("Connection established");
			Statement s=con.createStatement();
			String sql="insert into employee values("+e.getEmpId()+",'"+e.getEmpName()+"',"+e.getSalary()+",'"+e.getCity()+"')";
			rows=s.executeUpdate(sql);
			
		}
		catch(SQLException  se) {
			throw se;
		}
		finally {
			if(con!=null)
			try {
				con.close();
				
			}
			catch(Exception e1) {
				e1.printStackTrace();
				
			}
		}
		return rows;
		
		
	}
	

	public Integer updateEmployee(Integer eid, Integer sal) throws SQLException {
		Connection conn=null;
		int rows=0;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb","root","root");
			System.out.println("Connection established");
			String sql="update employee set salary=salary+"+sal+" where empId="+eid;
			PreparedStatement ps=conn.prepareStatement(sql);
			rows=ps.executeUpdate();
			
		}
		catch(SQLException  se) {
			throw se;
		}
		finally {
			if(conn!=null)
			try {
				conn.close();
				
			}
			catch(Exception e1) {
				e1.printStackTrace();
				
			}
		}
		
		return rows;
	}

		
		
	

	public List<Employee>  getEmployee(Employee emp)throws ClassNotFoundException,SQLException  {
		List<Employee> empList=new ArrayList<Employee>();
		
		Connection conn=null;
		int rows=0;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb","root","root");
			System.out.println("Connection established");
			Statement s=conn.createStatement();
			String sql="select empId,empName,salary,city from employee";
			ResultSet rs=s.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("empId:"+rs.getInt(1)+",empName:"+rs.getString("empName")+",empSalary:"+rs.getInt(3)+",empCity:"+rs.getString("city"));
			
			
			empList.add(emp);
		
		}
		}
		
		catch(SQLException  se) {
			throw se;
		}
		finally {
			if(conn!=null)
			try {
				conn.close();
				
			}
			catch(Exception e1) {
				e1.printStackTrace();
				
			}
		}
		return empList;
		
	}


	public Integer deleteEmployee(Integer eid)throws ClassNotFoundException,SQLException {
		Connection conn=null;
		int rows=0;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb","root","root");
			System.out.println("Connection established");
			String sql="delete from employee where empId="+eid;
			PreparedStatement ps=conn.prepareStatement(sql);
			rows=ps.executeUpdate();
			
		}
		catch(SQLException  se) {
			throw se;
		}
		finally {
			if(conn!=null)
			try {
				conn.close();
				
			}
			catch(Exception e1) {
				e1.printStackTrace();
				
			}
		}
		
		return rows;
	}

}
