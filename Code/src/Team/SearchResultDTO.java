package Team;

public class SearchResultDTO {

	private int emp_no;
	private String emp_name;
	private String dept_name;
	private String sal_class;
	private String adopt_type;
	private String phone;
	private String hire_date;
	private String email;
	

	SearchResultDTO(int emp_no, String emp_name, String dept_name, String sal_class, String adopt_type, String phone,
			String hire_date, String email) {
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.dept_name = dept_name;
		this.sal_class = sal_class;
		this.adopt_type = adopt_type;
		this.phone = phone;
		this.hire_date = hire_date;
		this.email = email;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getSal_class() {
		return sal_class;
	}

	public void setSal_class(String sal_class) {
		this.sal_class = sal_class;
	}

	public String getAdopt_type() {
		return adopt_type;
	}

	public void setAdopt_type(String adopt_type) {
		this.adopt_type = adopt_type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
