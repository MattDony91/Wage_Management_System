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

	// ����
	private void init() {

		try {
			String url = "jdbc:oracle:thin:@192.168.0.80:1521:xe";
			String user = "team";
			String password = "1234";

			Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle code = new OrcleDriver
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("���Ἲ�� init");
			} else {
				System.out.println("�������");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("��μ����� �� �� �Ǿ����ϴ�.");
		} catch (SQLException e) {
			System.out.println("sql ������ �߻��߽��ϴ�.");
		}

	}

	// ����̸��� ��ȣ�� ���� �� ����
	public void setDelte(String emp_name, int emp_no) {

		int cnt = 0;
		SalsysDAO_Login saldao = new SalsysDAO_Login();

		try {
			aa = saldao.setInfo(Integer.toString(emp_no));

			if (emp_name.equals(aa.getEMP_NAME()) && emp_no == aa.getEMP_NO()) {
				String real_del = JOptionPane.showInputDialog("���� �����Ͻðڽ��ϱ�?","������PW�Է�");
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
					JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�", "Ȯ��", JOptionPane.INFORMATION_MESSAGE);
					if (cnt > 0) {
						System.out.println("��������");
					} else {
						System.out.println("��������");
					}
				}else {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ȯ���ϼ���", "Ȯ��", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "�����ȣ �Ǵ� �̸��� ��ġ�����ʽ��ϴ�.", "�ٽ� Ȯ���ϼ���!", JOptionPane.WARNING_MESSAGE);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�����ȣ �Ǵ� �̸��� ��ġ�����ʽ��ϴ�.", "�ٽ� Ȯ���ϼ���!", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}

	}
}