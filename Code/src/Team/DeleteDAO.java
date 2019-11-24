package Team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JOptionPane;

public class DeleteDAO {
	Connection conn;
	String url = "jdbc:oracle:thin@192.168.0.80:1521:xe:";
	String id = "";
	String pw = "";
	private PreparedStatement pst = null;
	private Salsys_addmin_DTO aa;

	DeleteDAO() {
		init();
	}

	// 접속
	private void init() {

		try {
			String url = "jdbc:oracle:thin:@192.168.0.80:1521:xe";
			String user = "team";
			String password = "1234";

			Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle code = new OrcleDriver
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("연결성공 init");
			} else {
				System.out.println("연결실패");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("경로설정이 잘 못 되었습니다.");
		} catch (SQLException e) {
			System.out.println("sql 에러가 발생했습니다.");
		}

	}

	// 사원이름과 번호가 같을 때 삭제
	public void setDelte(String emp_name, int emp_no) {

		int cnt = 0;
		SalsysDAO_Login saldao = new SalsysDAO_Login();

		try {
			aa = saldao.setInfo(Integer.toString(emp_no));

			if (emp_name.equals(aa.getEMP_NAME()) && emp_no == aa.getEMP_NO()) {
				String real_del = JOptionPane.showInputDialog("정말 삭제하시겠습니까?","관리자PW입력");
				if (Integer.parseInt(real_del) == 1234) {

					String sql = "delete sal_mgt where emp_no = ?";
					pst = conn.prepareStatement(sql);

					pst.setInt(1, emp_no);

					cnt = pst.executeUpdate();

					sql = "delete emp where emp_name = ? and emp_no = ?";
					pst = conn.prepareStatement(sql);

					pst.setString(1, emp_name);
					pst.setInt(2, emp_no);

					cnt = pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다", "확인", JOptionPane.INFORMATION_MESSAGE);
					if (cnt > 0) {
						System.out.println("삭제성공");
					} else {
						System.out.println("삭제실패");
					}
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호를 확인하세요", "확인", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "사원번호 또는 이름이 일치하지않습니다.", "다시 확인하세요!", JOptionPane.WARNING_MESSAGE);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "사원번호 또는 이름이 일치하지않습니다.", "다시 확인하세요!", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}

	}
}