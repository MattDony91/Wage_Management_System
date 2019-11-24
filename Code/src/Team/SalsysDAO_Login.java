package Team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SalsysDAO_Login {
	private static int Distinction;
	private static Connection conn;
	private static String input_ID;
	private PreparedStatement pst;
	private ResultSet rs;
	GUI_Login login;
	String url = "jdbc:oracle:thin:@192.168.0.80:1521:xe";
	public String get_InputId;

	public SalsysDAO_Login() {

	}

	public Connection get_Con(int distinction) {

		String user;
		String password;

		if (distinction == 1) {
			user = "team";
			password = "1234";
		} else {
			user = "emp";
			password = "1234";
			System.out.println(user + password);
		}

		try {
			conn = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	public Connection init() {

		String user = "team";
		String password = "1234";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle code = new OrcleDriver
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("���Ἲ�� init" + "        dao39");
			} else {
				System.out.println("�������" + "        dao41");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("��μ����� �� �� �Ǿ����ϴ�." + "        dao45");
		} catch (SQLException e) {
			System.out.println("sql ������ �߻��߽��ϴ�." + "        dao47");
			e.printStackTrace();
		}

		return conn;
	}

	public int login(String distinction, String input_ID, String input_PW) {
		this.input_ID = input_ID;
		conn = init();

		String sql = "select EMP_NO,EMP_PW from team.emp";
		int num = 0;
		int cnt = 0;
		try {
			a: while (true) {

				pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					String get_Name = Integer.toString(rs.getInt(1));
					String get_Pw = rs.getString(2);
					if (input_ID.equals("team") && input_PW.equals("1234")) {
						System.out.println("team �α��� ����" + "        dao78");
						num = 1;
						connect(input_ID, input_PW);
						setCheckID("0");
						cnt++;
						break a;
					} else if (get_Name.equals(input_ID) && get_Pw.equals(input_PW)) {
						System.out.println("��� �α��� ����" + "        dao83");
						num = 2;
						setCheckID(input_ID);
						connect(get_Name, get_Pw);
						break a;
					}
				}
				break a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	public void setCheckID(String input_ID) {
		this.input_ID = input_ID;
	}

	public String getCheckID() {
		return input_ID;
	}

	private void connect(String id, String pw) {
		if (id.equals("team")) {
			id = "team";
			pw = "1234";
			System.out.println("team�� ����" + "        dao103");
		} else {
			id = "emp";
			pw = "1234";
			System.out.println("emp�� ����" + "        dao110");
		}

		try {
			// Oracle code = new OrcleDriver
			System.out.println(id + "����" + "        dao113");
			conn = DriverManager.getConnection(url, id, pw);
			if (conn != null) {
				System.out.println("conect ���Ἲ��" + "        dao117");

			} else {
				System.out.println("conect �������" + "        dao120");
			}

		} catch (SQLException e) {
			System.out.println("conect1 SQL ������ �߻��Ͽ����ϴ�" + "        dao124");
			e.printStackTrace();
		}
	}

	public Salsys_addmin_DTO setInfo(String inputID) {
		String sql = "SELECT e.EMP_NAME, e.EMP_NO, d.DEPT_Name, e.PHONE, e.HIRE_DATE,e.EMAIL,SAL_CLASS,adopt_Type FROM team.EMP e, team.dept d where d.DEPT_NO = e.DEPT_NO AND emp_no= ?";

		conn = get_Con(1);
		// inputID = input_ID;

		try {
			System.out.println(conn + "////////////////");

			pst = conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(inputID));
			System.out.println("inputID : " + Integer.parseInt(inputID));
			rs = pst.executeQuery();

			if (conn != null) {
				System.out.println("���Ἲ�� init" + "        dao142");
			} else {
				System.out.println("�������" + "        dao144");
			}

			while (rs.next()) {

				String get_Name = rs.getString(1);
				int get_EMP_NO = rs.getInt(2);
				String get_DEPT_NAME = rs.getString(3);
				String get_PHONE = rs.getString(4);
				String get_HIRE_DATE = rs.getString(5);
				String get_EMAIL = rs.getString(6);
				String get_SAL_CLASS = rs.getString(7);
				String get_adopt_Type = rs.getString(8);
				Salsys_addmin_DTO aa = new Salsys_addmin_DTO(get_Name, get_EMP_NO, get_DEPT_NAME, get_PHONE,
						get_HIRE_DATE, get_EMAIL, get_SAL_CLASS, get_adopt_Type);
				pst.close();
				return aa;

			}

		} catch (SQLException e) {
			e.printStackTrace();

			System.out.println("sql ������ �߻��߽��ϴ�." + "        dao173");
		}
		try {
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setUpdate(int EMP_NO, String EMP_NAME, String PHONE, String HIRE_DATE, String EMAIL, String DEPT_NAME,
			String SAL_CLASS, String ADOPT_TYPE) {
		String sql = "Update emp set EMP_NO = ?,EMP_NAME = ? ,PHONE = ?, HIRE_DATE = ?,EMAIL =?, SAL_CLASS = ?,ADOPT_TYPE= ? ,"
				+ "dept_no = (SELECT emp.dept_no FROM emp, dept WHERE emp.dept_no = dept.dept_no "
				+ " AND dept.dept_name LIKE ? GROUP BY emp.dept_no) where EMP_NO = ?";
		System.out.println(1);
		get_Con(1);

		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			// Salsys_addmin_DTO pidto = setInfo();

			pst.setInt(1, EMP_NO);
			pst.setString(2, EMP_NAME);

			pst.setString(3, PHONE);

			pst.setString(4, HIRE_DATE);
			pst.setString(5, EMAIL);
			pst.setString(6, SAL_CLASS);
			if (ADOPT_TYPE.equals("������")) {
				ADOPT_TYPE = "RJ";
			} else {
				ADOPT_TYPE = "TJ";
			}
			pst.setString(7, ADOPT_TYPE);
			pst.setString(8, "%" + DEPT_NAME + "%");
			pst.setInt(9, EMP_NO);

			int cnt = pst.executeUpdate();

			if (conn != null) {
				System.out.println("���Ἲ��" + "        dao209");
			} else {
				System.out.println("�������" + "        dao211");
			}

			if (cnt > 0) {
				System.out.println("�Է¼���" + "        dao215");
			} else {
				System.out.println("�Է½���" + "        dao217");
			}
			pst.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public SalDTO salInfo(String inputID) {
		String sql = "SELECT Basic_Pay+Cer_Pay+Car_Pay, Basic_Pay, Cer_Pay, Car_Pay , CER_SER from sal_mgt where emp_no = ?";
		conn = get_Con(1);

		try {

			pst = conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(inputID));
			rs = pst.executeQuery();

			if (conn != null) {
				System.out.println("���Ἲ�� init" + "        dao142");
			} else {
				System.out.println("�������" + "        dao144");
			}

			while (rs.next()) {

				int getSal = rs.getInt(1);
				int getbasicPay = rs.getInt(2);
				int getcerPay = rs.getInt(3);
				int getcarPay = rs.getInt(4);
				String getCERSER = rs.getString(5);
				SalDTO sal = new SalDTO(getSal, getbasicPay, getcerPay, getcarPay, getCERSER);

				return sal;

			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();

			System.out.println("sql ������ �߻��߽��ϴ�." + "        dao173");
		}
		try {
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setUpdate2(int EMP_NO, int comboBoxindex) {
		String cer_ser = null;
		int pay = 0;

		switch (comboBoxindex) {
		case 1:
			cer_ser = "EIP";
			pay = 50000;
			break;
		case 2:
			cer_ser = "LINM";
			pay = 100000;
			break;
		case 3:
			cer_ser = "OCJP";
			pay = 70000;
			break;
		case 4:
			cer_ser = "OCJD";
			pay = 100000;
			break;
		case 5:
			cer_ser = "CCNA";
			pay = 70000;
			break;
		case 6:
			cer_ser = "CCNP";
			pay = 100000;
			break;
		}

		if (comboBoxindex != 0) {
			int cnt = 0;
			try {
				/*
				 * String sql = "SELECT cer_pay from certi where cer_ser=?"; //conn =
				 * get_Con(1); pst = conn.prepareStatement(sql); pst.setString(1, cer_ser);
				 * ResultSet rs=pst.executeQuery(); System.out.println(cnt+"/////////////");
				 * if(rs.next()) { System.out.println("�̾ƿ��� ����"); cnt =rs.getInt(1); }
				 * System.out.println(cnt+"+++++++++++");
				 */
				String sql = "UPDATE sal_mgt set cer_ser = ?,cer_pay= ? where emp_no= ?";
				pst = conn.prepareStatement(sql);

				pst.setString(1, cer_ser);
				pst.setInt(2, pay);
				pst.setInt(3, EMP_NO);
				cnt = pst.executeUpdate();

				if (cnt > 0) {
					System.out.println("������Ʈ ����");
				} else {
					System.out.println("������Ʈ ����");
				}
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();

				System.out.println("sql ������ �߻��߽��ϴ�." + "        dao173");
			}
		}

	}

	public int clickInt(String clickName) {
		get_Con(1);

		String sql = "SELECT emp_no FROM emp WHERE emp_name = ?";
		PreparedStatement pst;
		int emp_no = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, clickName);
			System.out.println(1);
			ResultSet rs = pst.executeQuery();
			System.out.println(2);
			while (rs.next()) {
				emp_no = rs.getInt(1);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp_no;

	}

	public ArrayList<SearchResultDTO> fullCheck() {
		ArrayList<SearchResultDTO> temp = new ArrayList<>();
		PreparedStatement pst;
		String sql = "SELECT  e.EMP_NO,e.EMP_NAME,d.dept_name,e.SAL_CLASS,e.ADOPT_TYPE,e.PHONE,e.HIRE_DATE,e.EMAIL "
				+ "FROM EMP e,DEPT d WHERE e.dept_no=d.dept_no";
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				int emp_no = rs.getInt(1);
				String emp_name = rs.getString(2);
				String dept_name = rs.getString(3);
				String sal_class = rs.getString(4);
				String adopt_type = rs.getString(5);
				String phone = rs.getString(6);
				String hire_date = rs.getString(7);
				String email = rs.getString(8);

				temp.add(new SearchResultDTO(emp_no, emp_name, dept_name, sal_class, adopt_type, phone, hire_date,
						email));
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;

	}

	public ArrayList<SearchResultDTO> ser_1(int index, String search) {
		ArrayList<SearchResultDTO> temp = new ArrayList<>();
		PreparedStatement pst = null;
		String choice = null;
		int search_num = 0;
		if (index == 1) {
			choice = "emp_name";

		} else if (index == 2) {

			choice = "dept_name";
		} else if (index == 3) {
			choice = "emp_no";

			search_num = Integer.parseInt(search);
		}
		String sql = "SELECT  e.EMP_NO,e.EMP_NAME,d.dept_name,e.SAL_CLASS,e.ADOPT_TYPE,e.PHONE,e.HIRE_DATE,e.EMAIL "
				+ "FROM EMP e,DEPT d WHERE e.dept_no=d.dept_no and " + choice + " = ?";
		System.out.println(choice + "///" + search);
		try {
			pst = conn.prepareStatement(sql);

			if (index != 3) {

				pst.setString(1, search);
			} else {

				pst.setInt(1, search_num);
			}

			rs = pst.executeQuery();
			while (rs.next()) {
				int emp_no = rs.getInt(1);
				String emp_name = rs.getString(2);
				String dept_name = rs.getString(3);
				String sal_class = rs.getString(4);
				String adopt_type = rs.getString(5);
				String phone = rs.getString(6);
				String hire_date = rs.getString(7);
				String email = rs.getString(8);

				temp.add(new SearchResultDTO(emp_no, emp_name, dept_name, sal_class, adopt_type, phone, hire_date,
						email));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
}