package practice_POJO_SerDes;

public class EmployeeDetails {

	//step 1: declare all the variables globally
	String name;
	int phone;
	String EmpId;
	String Email;
	boolean isEmployed;
	
	//step 2:create a constructor to initialize the variables
	public EmployeeDetails(String name, int phone, String empId, String email, boolean isEmployed) {
		
		this.name = name;
		this.phone = phone;
		this.EmpId = empId;
		this.Email = email;
		this.isEmployed = isEmployed;
	}
	public EmployeeDetails()
	{
		
	}
	
	//step 3: provide getters and setters method
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmpId() {
		return EmpId;
	}

	public void setEmpId(String empId) {
		EmpId = empId;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public boolean isEmployed() {
		return isEmployed;
	}

	public void setEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
	}
	
}
