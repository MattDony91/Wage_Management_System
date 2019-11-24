package Team;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI_Admin_Insert {

	private JFrame frame;
	private JTextField textFieldEmpName;
	private JTextField textFieldEmpRegNo;
	private JTextField textFieldPhone;
	private JTextField textFieldEmpNo;
	private JTextField textFieldAddr;
	private JTextField textFieldHireDate;
	private JLabel lblEmpGrad;
	private JTextField textFieldEMail;
	private JLabel lblHireDate;
	private JLabel lblAddr;
	private JLabel lblDeptNo;
	private JTextField textFieldDeptNo;
	private JLabel lblEMail;
	private JTextField textFieldEmpPw;
	private JLabel lblPw;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox_1;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JComboBox ComboBox_salclass;
	private JLabel lblNewLabel_3;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Admin_Insert window = new GUI_Admin_Insert();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Admin_Insert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("급여관리시스템 - 사원추가");
		frame.setBounds(100, 100, 514, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label_Name = new JLabel("*\uC0AC\uC6D0\uC774\uB984");
		label_Name.setBounds(14, 28, 65, 15);
		frame.getContentPane().add(label_Name);

		JLabel label_RegNo = new JLabel("*\uC8FC\uBBFC\uBC88\uD638");
		label_RegNo.setBounds(234, 28, 65, 15);
		frame.getContentPane().add(label_RegNo);

		JLabel label_Tel = new JLabel("*\uC804\uD654\uBC88\uD638");
		label_Tel.setBounds(14, 81, 65, 15);
		frame.getContentPane().add(label_Tel);

		lblHireDate = new JLabel("*\uC785\uC0AC\uC77C\uC790");
		lblHireDate.setBounds(234, 79, 65, 18);
		frame.getContentPane().add(lblHireDate);

		JLabel label_Type = new JLabel("*\uCC44\uC6A9\uD615\uD0DC");
		label_Type.setBounds(14, 136, 65, 18);
		frame.getContentPane().add(label_Type);

		lblEmpGrad = new JLabel("\uCD5C\uC885\uD559\uB825");
		lblEmpGrad.setBounds(242, 136, 57, 18);
		frame.getContentPane().add(lblEmpGrad);

		lblEMail = new JLabel("\uBA54     \uC77C");
		lblEMail.setBounds(22, 187, 57, 18);
		frame.getContentPane().add(lblEMail);

		JLabel label_Class = new JLabel("*\uD638    \uBD09");
		label_Class.setBounds(242, 187, 57, 18);
		frame.getContentPane().add(label_Class);

		lblAddr = new JLabel("\uC8FC     \uC18C");
		lblAddr.setBounds(22, 238, 57, 18);
		frame.getContentPane().add(lblAddr);

		JLabel label_EmpNo = new JLabel("*\uC0AC\uC6D0\uBC88\uD638");
		label_EmpNo.setBounds(14, 296, 65, 15);
		frame.getContentPane().add(label_EmpNo);

		lblPw = new JLabel("*\uC0AC\uC6D0PW");
		lblPw.setBounds(234, 294, 65, 18);
		frame.getContentPane().add(lblPw);

		lblDeptNo = new JLabel("*\uBD80\uC11C\uBC88\uD638");
		lblDeptNo.setBounds(14, 348, 68, 18);
		frame.getContentPane().add(lblDeptNo);

		textFieldEmpName = new JTextField();
		textFieldEmpName.setBounds(93, 24, 116, 21);
		frame.getContentPane().add(textFieldEmpName);
		textFieldEmpName.setColumns(10);

		textFieldEmpRegNo = new JTextField();
		textFieldEmpRegNo.setColumns(10);
		textFieldEmpRegNo.setBounds(313, 24, 116, 21);
		frame.getContentPane().add(textFieldEmpRegNo);

		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(93, 77, 116, 21);
		frame.getContentPane().add(textFieldPhone);
		textFieldPhone.setColumns(10);

		textFieldHireDate = new JTextField();
		textFieldHireDate.setForeground(Color.BLACK);
		textFieldHireDate.setBounds(313, 76, 116, 24);
		frame.getContentPane().add(textFieldHireDate);
		textFieldHireDate.setColumns(10);

		textFieldEMail = new JTextField();
		textFieldEMail.setBounds(93, 184, 116, 24);
		frame.getContentPane().add(textFieldEMail);
		textFieldEMail.setColumns(10);

		textFieldAddr = new JTextField();
		textFieldAddr.setBounds(93, 235, 336, 24);
		frame.getContentPane().add(textFieldAddr);
		textFieldAddr.setColumns(10);

		textFieldEmpNo = new JTextField();
		textFieldEmpNo.setBounds(93, 292, 116, 21);
		frame.getContentPane().add(textFieldEmpNo);
		textFieldEmpNo.setColumns(10);

		textFieldEmpPw = new JTextField();
		textFieldEmpPw.setBounds(313, 291, 116, 24);
		frame.getContentPane().add(textFieldEmpPw);
		textFieldEmpPw.setColumns(10);

		textFieldDeptNo = new JTextField();
		textFieldDeptNo.setBounds(93, 345, 116, 24);
		frame.getContentPane().add(textFieldDeptNo);
		textFieldDeptNo.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(92, 135, 116, 21);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("RJ");
		comboBox.addItem("TJ");

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(311, 135, 116, 21);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addItem("CG");
		comboBox_1.addItem("HG");

		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t7, t8, t6, t9 = null;

				int t1 = Integer.parseInt(textFieldEmpNo.getText());
				String t2 = textFieldEmpName.getText();
				String t3 = textFieldEmpRegNo.getText();
				String t4 = textFieldPhone.getText();
				String t5 = (String) comboBox.getSelectedItem();
				t6 = (String) ComboBox_salclass.getSelectedItem();
				t7 = (String) comboBox_1.getSelectedItem();
				t8 = textFieldEMail.getText();
				t9 = textFieldAddr.getText();
				int t10 = Integer.parseInt(textFieldDeptNo.getText()); // 나중에 부서로 수정
				int t11 = Integer.parseInt(textFieldEmpPw.getText());
				String t12 = textFieldHireDate.getText();
				String career = (String)comboBox_2.getSelectedItem();
				String certi = (String)comboBox_3.getSelectedItem();
				
				
				InsertDAO dao = new InsertDAO();
				
				
				
				dao.setInsert(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12,career,certi);

				frame.dispose();
			}
		});
		btnNewButton.setBounds(14, 454, 105, 27);
		frame.getContentPane().add(btnNewButton);

		lblNewLabel = new JLabel("* \uD544\uC218\uC785\uB825\uD56D\uBAA9");
		lblNewLabel.setBounds(363, 454, 116, 18);
		frame.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("2000-01-01");
		lblNewLabel_1.setBounds(337, 103, 92, 18);
		frame.getContentPane().add(lblNewLabel_1);

		btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(140, 454, 105, 27);
		frame.getContentPane().add(btnNewButton_1);

		lblNewLabel_2 = new JLabel("\uACBD      \uB825");
		lblNewLabel_2.setBounds(237, 348, 62, 18);
		frame.getContentPane().add(lblNewLabel_2);

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(313, 345, 116, 24);
		frame.getContentPane().add(comboBox_2);

		ComboBox_salclass = new JComboBox();
		ComboBox_salclass.setBounds(313, 184, 116, 24);
		frame.getContentPane().add(ComboBox_salclass);

		lblNewLabel_3 = new JLabel("\uC790  \uACA9  \uC99D");
		lblNewLabel_3.setBounds(17, 400, 62, 18);
		frame.getContentPane().add(lblNewLabel_3);

		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(93, 397, 336, 24);
		frame.getContentPane().add(comboBox_3);

		String[] list3 = { "NONE", "EIP", "LINM", "OCJP", "OCJD", "CCNA", "CCNP" };
		for (int i = 0; i < list3.length; i++) {
			comboBox_3.addItem(list3[i]);
		}

		String[] list2 = { "신입1", "대리1", "과장1", "차장1", "부장1" };
		for (int i = 0; i < list2.length; i++) {
			ComboBox_salclass.addItem(list2[i]);
		}

		String[] list = { "NONE", "N03", "N05", "N07", "N10", "L03", "L05", "L07", "L10", "J03", "J05", "J07", "J10",
				"C03", "C05", "C07", "C10" };

		for (int i = 0; i < list.length; i++) {
			comboBox_2.addItem(list[i]);
		
		}
	}
}