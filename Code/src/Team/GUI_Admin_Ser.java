package Team;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class GUI_Admin_Ser {

	JFrame frame;
	private JTextField textSearchText;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	JComboBox careerser;
	JComboBox career;
	JComboBox condition;
	JScrollPane scrollPane = new JScrollPane();
	SalsysDAO_Login dao = new SalsysDAO_Login();

	// Mypage 변수
	private JLabel label_basicPay;
	private JLabel lbl_Cerpay;
	private JLabel total_Sal;
	private JLabel label_Carpay;
	private JTextField textFieldEmpName;
	private JTextField textFieldEmpNo;
	private JTextField textFieldDeptName;
	private JTextField textFieldJobId;
	private JTextField txtXxx;
	private JTextField txtHiredate;
	private JTextField txtEmail;
	private String name;
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	private JComboBox comboBox1;
	private JComboBox comboBoxcerti;

	private Salsys_addmin_DTO SDTO_login;
	private SalsysDAO_Login SDAO_login = new SalsysDAO_Login();
	private JLabel picture_add = new JLabel("New label");

	private Salsys_addmin_DTO bb;
	/*
	 * private String empName; private int empNo; private String deptName; private
	 * String jobId; private String phone; private String hireDate; private String
	 * eMail;
	 */
	private int basicPay;
	private int carPay;
	private int totalSal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Admin_Ser window = new GUI_Admin_Ser(args);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application. * @param list
	 * 
	 * @wbp.parser.entryPoint
	 */
	public GUI_Admin_Ser(String[] list) {
		initialize1(list);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param list
	 */
	private void initialize1(String[] list) {

		frame = new JFrame();
		frame.setBounds(100, 100, 960, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 930, 632);
		frame.getContentPane().add(tabbedPane);

		JPanel Search = new JPanel();
		Search.setBackground(UIManager.getColor("CheckBox.light"));
		tabbedPane.addTab("\uAC80   \uC0C9", null, Search, null);
		Search.setLayout(null);

		// comboBox 만들기
		condition = new JComboBox();
		condition.setBounds(47, 40, 105, 25);
		condition.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Search.add(condition);

		condition.addItem("검색조건");
		condition.addItem(" 이   름");
		condition.addItem(" 부   서");
		condition.addItem(" 사   번");

		textSearchText = new JTextField("");
		textSearchText.setBounds(170, 42, 350, 25);
		Search.add(textSearchText);
		textSearchText.setColumns(10);

		JButton btnSearchButton = new JButton("\uAC80   \uC0C9");
		btnSearchButton.addActionListener(new ActionListener() {
			private ArrayList<SearchResultDTO> temp;

			public void actionPerformed(ActionEvent e) {
				// 이름,부서,사원번호 검색
				String[] head_list = { "사원번호", "사원이름", "부서이름", "직책", "고용형태", "전호번호", "입사일자", "E-MAIL" };
				temp = SDAO_login.ser_1(condition.getSelectedIndex(), textSearchText.getText());
				String[][] list_ex = new String[temp.size()][head_list.length];
				ArrayList<Object> list = new ArrayList<Object>();
				ArrayList<Object> rowdata = new ArrayList<Object>();

				for (int i = 0; i < temp.size(); i++) {
					list_ex[i][0] = Integer.toString(SDAO_login
							.ser_1(condition.getSelectedIndex(), textSearchText.getText()).get(i).getEmp_no());
					list_ex[i][1] = SDAO_login.ser_1(condition.getSelectedIndex(), textSearchText.getText()).get(i)
							.getEmp_name();
					list_ex[i][2] = SDAO_login.ser_1(condition.getSelectedIndex(), textSearchText.getText()).get(i)
							.getDept_name();
					list_ex[i][3] = SDAO_login.ser_1(condition.getSelectedIndex(), textSearchText.getText()).get(i)
							.getSal_class();
					list_ex[i][4] = SDAO_login.ser_1(condition.getSelectedIndex(), textSearchText.getText()).get(i)
							.getAdopt_type();
					list_ex[i][5] = SDAO_login.ser_1(condition.getSelectedIndex(), textSearchText.getText()).get(i)
							.getPhone();
					list_ex[i][6] = SDAO_login.ser_1(condition.getSelectedIndex(), textSearchText.getText()).get(i)
							.getHire_date();
					list_ex[i][7] = SDAO_login.ser_1(condition.getSelectedIndex(), textSearchText.getText()).get(i)
							.getEmail();

				}

				table = new JTable(list_ex, head_list);
				scrollPane.setViewportView(table);

				table.addMouseListener(new MouseListener() {
					private SalDTO bb2;

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					// 어나먼스 클래스
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = GUI_Admin_Ser.table.getSelectedRow(); // 선택되어진 row구하기
						if (row != -1) { // 셀이 선택되어진 상태인경우
							String clickName = (String) GUI_Admin_Ser.table.getValueAt(row, 1);
							SalsysDAO_Login dao = new SalsysDAO_Login();
							int emp_no = dao.clickInt(clickName);

							System.out.println(emp_no);
							System.out.println(clickName);

							bb = dao.setInfo(Integer.toString(emp_no));
							textFieldEmpName.setText(bb.getEMP_NAME());
							textFieldEmpNo.setText(Integer.toString(bb.getEMP_NO()));
							textFieldDeptName.setText(bb.getDEPT_NO());
							textFieldJobId.setText(bb.getSAL_CLASS());
							txtXxx.setText(bb.getPHONE());
							txtHiredate.setText(bb.getHIRE_DATE());
							txtEmail.setText(bb.getEMAIL());

							bb2 = dao.salInfo(Integer.toString(emp_no));
							label_basicPay.setText(Integer.toString(bb2.getGetbasicPay()));
							lbl_Cerpay.setText(Integer.toString(bb2.getGetcerPay()));
							label_Carpay.setText(Integer.toString(bb2.getGetcarPay()));
							total_Sal.setText(Integer.toString(bb2.getGetSal()));

							ImageIcon ic = new ImageIcon("C:\\Users\\smhrc01\\Desktop\\사진\\" + emp_no + ".jpg");

							picture_add.setIcon(ic);
							picture_add.setVisible(true);

							System.out.println("bb : " + bb.getADOPT_TYPE());

							if (bb.getADOPT_TYPE().contains("TJ")) {
								System.out.println("비정규직");
								comboBox1.setSelectedIndex(1);
							} else {
								System.out.println("정규직");
								comboBox1.setSelectedIndex(0);
							}

							if (bb2.getGetCERSER().contains("NONE")) {
								comboBoxcerti.setSelectedIndex(0);
							} else if (bb2.getGetCERSER().contains("EIP")) {
								comboBoxcerti.setSelectedIndex(1);
							} else if (bb2.getGetCERSER().contains("LINM")) {
								comboBoxcerti.setSelectedIndex(2);
							} else if (bb2.getGetCERSER().contains("OCJP")) {
								comboBoxcerti.setSelectedIndex(3);
							} else if (bb2.getGetCERSER().contains("OCJD")) {
								comboBoxcerti.setSelectedIndex(4);
							} else if (bb2.getGetCERSER().contains("CCNA")) {
								comboBoxcerti.setSelectedIndex(5);
							} else if (bb2.getGetCERSER().contains("CCNP")) {
								comboBoxcerti.setSelectedIndex(6);
							}

						}
					}
				});
			}

		});

		btnSearchButton.setBounds(555, 41, 97, 24);
		btnSearchButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Search.add(btnSearchButton);

		JLabel lblCareerKind = new JLabel("\uACBD\uB825 \uBD84\uC57C");
		lblCareerKind.setBounds(298, 116, 88, 25);
		lblCareerKind.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Search.add(lblCareerKind);

		career = new JComboBox();
		career.setBounds(386, 116, 123, 25);
		career.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Search.add(career);

		career.addItem(" 해당없음");
		career.addItem(" C언어");
		career.addItem(" Java");
		career.addItem(" Network");
		career.addItem(" Linux");

		JLabel lblCertiKind = new JLabel("\uC790\uACA9\uC99D \uC885\uB958");
		lblCertiKind.setBounds(47, 118, 88, 20);
		lblCertiKind.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Search.add(lblCertiKind);

		JComboBox certi = new JComboBox();
		certi.setBounds(139, 116, 110, 25);
		certi.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Search.add(certi);

		certi.addItem("해당없음");
		certi.addItem("정보처리기사");
		certi.addItem("리눅스마스터");
		certi.addItem("OCJP");
		certi.addItem("OCJD");
		certi.addItem("CCNA");
		certi.addItem("CCNP");

		JLabel lblCertiSer = new JLabel("\uACBD\uB825 \uAE30\uAC04");
		lblCertiSer.setBounds(547, 115, 88, 25);
		lblCertiSer.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Search.add(lblCertiSer);

		// 여기서부터 경력종류 및 기간 추가
		careerser = new JComboBox();
		careerser.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		careerser.setBounds(632, 117, 257, 25);
		Search.add(careerser);

		JLabel iblLabelHiretype = new JLabel("\uACE0\uC6A9\uD615\uD0DC");
		iblLabelHiretype.setBounds(350, 188, 76, 25);
		iblLabelHiretype.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Search.add(iblLabelHiretype);

		JComboBox hiretype = new JComboBox();
		hiretype.setBounds(438, 187, 105, 25);
		hiretype.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Search.add(hiretype);
		hiretype.addItem(" 정규직");
		hiretype.addItem(" 비정규직");

		JLabel lblLowest = new JLabel("\uCD5C\uC800 \uC5F0\uBD09");
		lblLowest.setBounds(47, 188, 88, 20);
		lblLowest.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Search.add(lblLowest);

		JLabel lblHighest = new JLabel("\uCD5C\uACE0 \uC5F0\uBD09");
		lblHighest.setBounds(47, 219, 88, 20);
		lblHighest.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Search.add(lblHighest);

		textLowest = new JTextField();
		textLowest.setBounds(139, 188, 116, 25);
		Search.add(textLowest);
		textLowest.setColumns(10);

		textHighest = new JTextField();
		textHighest.setBounds(139, 219, 116, 25);
		Search.add(textHighest);
		textHighest.setColumns(10);

		JButton btnNewButton = new JButton("\uAC80   \uC0C9");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 선택검색

			}
		});
		btnNewButton.setBounds(784, 218, 105, 27);
		Search.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(30, 99, 881, 178);
		Search.add(panel);

		JLabel label = new JLabel("\uAC80\uC0C9\uACB0\uACFC");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label.setBounds(30, 290, 110, 34);
		Search.add(label);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		scrollPane.setBounds(30, 332, 881, 210);
		Search.add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);

		JButton btnNewButton_2 = new JButton("\uC804 \uCCB4 \uC870 \uD68C");
		btnNewButton_2.addActionListener(new ActionListener() {
			private ArrayList<SearchResultDTO> temp;

			public void actionPerformed(ActionEvent e) {
				// 이름,부서,사원번호 검색
				String[] head_list = { "사원번호", "사원이름", "부서이름", "직책", "고용형태", "전호번호", "입사일자", "E-MAIL" };
				temp = SDAO_login.fullCheck();
				String[][] list_ex = new String[temp.size()][head_list.length];
				ArrayList<Object> list = new ArrayList<Object>();
				ArrayList<Object> rowdata = new ArrayList<Object>();

				for (int i = 0; i < temp.size(); i++) {
					list_ex[i][0] = Integer.toString(SDAO_login.fullCheck().get(i).getEmp_no());
					list_ex[i][1] = SDAO_login.fullCheck().get(i).getEmp_name();
					list_ex[i][2] = SDAO_login.fullCheck().get(i).getDept_name();
					list_ex[i][3] = SDAO_login.fullCheck().get(i).getSal_class();
					list_ex[i][4] = SDAO_login.fullCheck().get(i).getAdopt_type();
					list_ex[i][5] = SDAO_login.fullCheck().get(i).getPhone();
					list_ex[i][6] = SDAO_login.fullCheck().get(i).getHire_date();
					list_ex[i][7] = SDAO_login.fullCheck().get(i).getEmail();

				}

				table = new JTable(list_ex, head_list);
				scrollPane.setViewportView(table);

				table.addMouseListener(new MouseListener() {
					private SalDTO bb2;

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					// 어나먼스 클래스
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = GUI_Admin_Ser.table.getSelectedRow(); // 선택되어진 row구하기
						if (row != -1) { // 셀이 선택되어진 상태인경우
							String clickName = (String) GUI_Admin_Ser.table.getValueAt(row, 1);
							SalsysDAO_Login dao = new SalsysDAO_Login();
							int emp_no = dao.clickInt(clickName);

							System.out.println(emp_no);
							System.out.println(clickName);

							bb = dao.setInfo(Integer.toString(emp_no));
							textFieldEmpName.setText(bb.getEMP_NAME());
							textFieldEmpNo.setText(Integer.toString(bb.getEMP_NO()));
							textFieldDeptName.setText(bb.getDEPT_NO());
							textFieldJobId.setText(bb.getSAL_CLASS());
							txtXxx.setText(bb.getPHONE());
							txtHiredate.setText(bb.getHIRE_DATE());
							txtEmail.setText(bb.getEMAIL());

							bb2 = dao.salInfo(Integer.toString(emp_no));
							label_basicPay.setText(Integer.toString(bb2.getGetbasicPay()));
							lbl_Cerpay.setText(Integer.toString(bb2.getGetcerPay()));
							label_Carpay.setText(Integer.toString(bb2.getGetcarPay()));
							total_Sal.setText(Integer.toString(bb2.getGetSal()));

							ImageIcon ic = new ImageIcon("C:\\Users\\smhrc01\\Desktop\\사진\\" + emp_no + ".jpg");

							picture_add.setIcon(ic);
							picture_add.setVisible(true);

							System.out.println("bb : " + bb.getADOPT_TYPE());

							if (bb.getADOPT_TYPE().contains("TJ")) {
								System.out.println("비정규직");
								comboBox1.setSelectedIndex(1);
							} else {
								System.out.println("정규직");
								comboBox1.setSelectedIndex(0);
							}

							if (bb2.getGetCERSER().contains("NONE")) {
								comboBoxcerti.setSelectedIndex(0);
							} else if (bb2.getGetCERSER().contains("EIP")) {
								comboBoxcerti.setSelectedIndex(1);
							} else if (bb2.getGetCERSER().contains("LINM")) {
								comboBoxcerti.setSelectedIndex(2);
							} else if (bb2.getGetCERSER().contains("OCJP")) {
								comboBoxcerti.setSelectedIndex(3);
							} else if (bb2.getGetCERSER().contains("OCJD")) {
								comboBoxcerti.setSelectedIndex(4);
							} else if (bb2.getGetCERSER().contains("CCNA")) {
								comboBoxcerti.setSelectedIndex(5);
							} else if (bb2.getGetCERSER().contains("CCNP")) {
								comboBoxcerti.setSelectedIndex(6);
							}

						}
					}
				});

			}
		});
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton_2.setBounds(770, 41, 141, 27);
		Search.add(btnNewButton_2);

		Thread1 thread1 = new Thread1();
		Thread thread = new Thread(thread1);
		thread.start();
		JPanel Mypage = new JPanel();
		tabbedPane.addTab("\uAC1C\uC778\uC815\uBCF4", null, Mypage, null);
		Mypage.setLayout(null);

		picture_add = new JLabel("");
		picture_add.setBounds(77, 50, 149, 180);
		Mypage.add(picture_add);

		JPanel PI = new JPanel();
		PI.setBounds(240, 50, 612, 180);
		PI.setBackground(Color.LIGHT_GRAY);
		Mypage.add(PI);
		PI.setLayout(null);

		JLabel lblEmpName = new JLabel("\uC774       \uB984");
		lblEmpName.setBounds(40, 20, 75, 21);
		lblEmpName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		PI.add(lblEmpName);

		JLabel lblEmpNo = new JLabel("\uC0AC       \uBC88");
		lblEmpNo.setBounds(40, 60, 75, 21);
		lblEmpNo.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		PI.add(lblEmpNo);

		JLabel lblDeptName = new JLabel("\uBD80       \uC11C");
		lblDeptName.setBounds(40, 100, 75, 21);
		lblDeptName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		PI.add(lblDeptName);

		JLabel lblJobId = new JLabel("\uC9C1       \uCC45");
		lblJobId.setBounds(40, 140, 75, 21);
		lblJobId.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		PI.add(lblJobId);

		JLabel lblPhonNum = new JLabel("\uC804 \uD654 \uBC88 \uD638");
		lblPhonNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhonNum.setBounds(335, 20, 75, 21);
		PI.add(lblPhonNum);
		lblPhonNum.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(335, 100, 75, 21);
		PI.add(lblEmail);
		lblEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		JLabel lblHireDate = new JLabel("\uC785  \uC0AC  \uC77C ");
		lblHireDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHireDate.setBounds(335, 60, 75, 21);
		PI.add(lblHireDate);
		lblHireDate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		JLabel lblHireType = new JLabel("\uACE0\uC6A9\uD615\uD0DC ");
		lblHireType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHireType.setBounds(335, 140, 75, 21);
		PI.add(lblHireType);
		lblHireType.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		textFieldEmpName = new JTextField();
		textFieldEmpName.setBounds(120, 20, 116, 23);
		PI.add(textFieldEmpName);
		textFieldEmpName.setColumns(10);

		textFieldEmpNo = new JTextField();

		textFieldEmpNo.setBounds(120, 60, 116, 21);
		PI.add(textFieldEmpNo);
		textFieldEmpNo.setColumns(10);

		textFieldDeptName = new JTextField();

		textFieldDeptName.setBounds(120, 100, 116, 21);
		PI.add(textFieldDeptName);
		textFieldDeptName.setColumns(10);

		textFieldJobId = new JTextField();
		textFieldJobId.setBounds(120, 140, 116, 21);
		PI.add(textFieldJobId);
		textFieldJobId.setColumns(10);

		txtXxx = new JTextField();

		txtXxx.setBounds(435, 20, 116, 21);
		PI.add(txtXxx);
		txtXxx.setColumns(10);

		txtHiredate = new JTextField();

		txtHiredate.setBounds(435, 60, 116, 21);
		PI.add(txtHiredate);
		txtHiredate.setColumns(10);

		txtEmail = new JTextField();

		txtEmail.setBounds(435, 100, 116, 21);
		PI.add(txtEmail);
		txtEmail.setColumns(10);

		comboBox1 = new JComboBox();
		comboBox1.setBounds(435, 140, 116, 21);
		PI.add(comboBox1);
		comboBox1.addItem("정규직");
		comboBox1.addItem("비정규직");

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(755, 15, 97, 27);
		Mypage.add(btnUpdate);

		JPanel panelPay = new JPanel();
		panelPay.setBackground(Color.LIGHT_GRAY);
		panelPay.setBounds(77, 335, 775, 160);
		Mypage.add(panelPay);
		panelPay.setLayout(null);

		JLabel lblCertiPay = new JLabel("\uC790\uACA9\uC99D");
		lblCertiPay.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblCertiPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCertiPay.setBounds(389, 30, 80, 20);
		panelPay.add(lblCertiPay);

		JLabel lblCarPay = new JLabel("\uACBD\uB825 \uC218\uB2F9");
		lblCarPay.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblCarPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarPay.setBounds(15, 110, 72, 20);
		panelPay.add(lblCarPay);

		JLabel lblBasicPay = new JLabel("\uAE30\uBCF8 \uAE09\uC5EC");
		lblBasicPay.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblBasicPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBasicPay.setBounds(15, 30, 72, 20);
		panelPay.add(lblBasicPay);

		JLabel lblNewLabel_2 = new JLabel("\uC6D0");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(286, 30, 57, 21);
		panelPay.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("\uC6D0");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(286, 110, 57, 21);
		panelPay.add(lblNewLabel_4);

		comboBoxcerti = new JComboBox();
		comboBoxcerti.setBounds(507, 30, 243, 20);
		panelPay.add(comboBoxcerti);
		comboBoxcerti.addItem("해당사항없음");
		comboBoxcerti.addItem("정보처리기사(5만)");
		comboBoxcerti.addItem("리눅스마스터(10만)");
		comboBoxcerti.addItem("자바기초_OCJP(7만)");
		comboBoxcerti.addItem("자바고급/활용_OCJD(10만)");
		comboBoxcerti.addItem("네트워크활용_CCNA(7만)");
		comboBoxcerti.addItem("네트워크고급_CCNP(10만)");

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int EMP_NO = Integer.parseInt(textFieldEmpNo.getText());
				String EMP_NAME = textFieldEmpName.getText();
				String EMP_REGNO = textFieldJobId.getText();
				String PHONE = txtXxx.getText();
				String HIRE_DATE = txtHiredate.getText();
				String EMAIL = txtEmail.getText();
				String DEPT_NAME = textFieldDeptName.getText(); // 나중에 부서로 수정
				String SAL_CLASS = textFieldJobId.getText();
				String ADOPT_TYPE = (String) comboBox1.getSelectedItem();
				int comboBoxindex = comboBoxcerti.getSelectedIndex();
				SDAO_login.setUpdate2(EMP_NO, comboBoxindex);
				SDAO_login.setUpdate(EMP_NO, EMP_NAME, PHONE, HIRE_DATE, EMAIL, DEPT_NAME, SAL_CLASS, ADOPT_TYPE);

			}
		});

		label_basicPay = new JLabel(Integer.toString(basicPay));
		label_basicPay.setBounds(113, 33, 159, 18);
		panelPay.add(label_basicPay);

		label_Carpay = new JLabel(Integer.toString(carPay));
		label_Carpay.setBounds(113, 113, 159, 18);
		panelPay.add(label_Carpay);

		lblCerPay = new JLabel("\uC790\uACA9\uC99D\uC218\uB2F9");
		lblCerPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCerPay.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblCerPay.setBounds(-5, 70, 92, 20);
		panelPay.add(lblCerPay);

		lbl_Cerpay = new JLabel((String) null);
		lbl_Cerpay.setBounds(113, 70, 159, 18);
		panelPay.add(lbl_Cerpay);

		JLabel label_3 = new JLabel("\uC6D0");
		label_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		label_3.setBounds(286, 73, 57, 21);
		panelPay.add(label_3);

		JLabel lblTotalSal = new JLabel("\uCD1D\uAE09\uC5EC");
		lblTotalSal.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblTotalSal.setBounds(77, 282, 57, 20);
		Mypage.add(lblTotalSal);

		JLabel lblNewLabel_1 = new JLabel("\uC6D0");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(265, 282, 57, 21);
		Mypage.add(lblNewLabel_1);

		total_Sal = new JLabel(Integer.toString(totalSal));
		total_Sal.setBounds(148, 285, 103, 18);
		Mypage.add(total_Sal);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DeleteDAO del = new DeleteDAO();
				GUI_Admin_Delete del_admin = new GUI_Admin_Delete();
				del_admin.main(null);

			}
		});
		btnDelete.setBounds(636, 15, 105, 27);
		Mypage.add(btnDelete);

		JButton btnNewButton_1 = new JButton("INSERT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				GUI_Admin_Insert gui_insert = new GUI_Admin_Insert();
				gui_insert.main(null);

			}
		});
		btnNewButton_1.setBounds(517, 15, 105, 27);
		Mypage.add(btnNewButton_1);

		frame.setTitle("급여관리시스템");
		frame.setBounds(100, 100, 943, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	String temp1 = "";
	String temp2 = "";
	private JTextField textLowest;
	private JTextField textHighest;
	static JTable table;
	private JLabel lblCerPay;

	class Thread1 implements Runnable {

		@Override
		public void run() {
			while (true) {
				String a = career.getSelectedItem() + "";
				temp1 = a;
				boolean check = false;
				if (!temp1.equals(temp2)) {
					check = true;
				}
				temp2 = a;
				if (check) {
					if (a.equals(" Java")) {
						careerser.removeAllItems();
						careerser.addItem(" Java 3년 미만");
						careerser.addItem(" Java 3년 이상 5년 미만");
						careerser.addItem(" Java 5년 이상 7년 미만");
						careerser.addItem(" Java 7년 이상 10년 미만");
						careerser.addItem(" Java 10년 이상");
					} else if (a.equals(" C언어")) {
						careerser.removeAllItems();
						careerser.addItem(" C언어 3년 미만");
						careerser.addItem(" C언어 3년 이상 5년 미만");
						careerser.addItem(" C언어 5년 이상 7년 미만");
						careerser.addItem(" C언어 7년 이상 10년 미만");
						careerser.addItem(" C언어 10년 이상");
					} else if (a.equals(" Network")) {
						careerser.removeAllItems();
						careerser.addItem(" Network 3년 미만");
						careerser.addItem(" Network 3년 이상 5년 미만");
						careerser.addItem(" Network 5년 이상 7년 미만");
						careerser.addItem(" Network 7년 이상 10년 미만");
						careerser.addItem(" Network 10년 이상");
					} else if (a.equals(" Linux")) {
						careerser.removeAllItems();
						careerser.addItem(" Linux 3년 미만");
						careerser.addItem(" Linux 3년 이상 5년 미만");
						careerser.addItem(" Linux 5년 이상 7년 미만");
						careerser.addItem(" Linux 7년 이상 10년 미만");
						careerser.addItem(" Linux 10년 이상");
					}
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	// 여기서부터 Mypage

	private void initialize() {
		frame = new JFrame();
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, 682, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, 1264, SpringLayout.WEST, frame.getContentPane());
		tabbedPane.setToolTipText("a,b,c");
		frame.getContentPane().add(tabbedPane);

		JPanel panelSearch = new JPanel();
		tabbedPane.addTab("\uAC80\uC0C9", null, panelSearch, null);

		JPanel panelPI = new JPanel();
		tabbedPane.addTab("\uAC1C\uC778\uC815\uBCF4", null, panelPI, null);
		tabbedPane.setBackgroundAt(1, Color.GRAY);
		panelPI.setLayout(null);

		JPanel Picture = new JPanel();
		Picture.setBounds(70, 60, 120, 160);
		Picture.setBackground(Color.WHITE);
		panelPI.add(Picture);
		SpringLayout sl_Picture = new SpringLayout();
		Picture.setLayout(sl_Picture);

		JLabel lblNewLabel = new JLabel("\uC0AC \uC9C4");
		sl_Picture.putConstraint(SpringLayout.NORTH, lblNewLabel, 69, SpringLayout.NORTH, Picture);
		sl_Picture.putConstraint(SpringLayout.EAST, lblNewLabel, -47, SpringLayout.EAST, Picture);
		Picture.add(lblNewLabel);

		JPanel PI = new JPanel();
		PI.setBounds(240, 50, 612, 180);
		PI.setBackground(Color.LIGHT_GRAY);
		panelPI.add(PI);
		PI.setLayout(null);

		JLabel lblEmpName = new JLabel("\uC774       \uB984");
		lblEmpName.setBounds(40, 20, 75, 21);
		lblEmpName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		PI.add(lblEmpName);

		JLabel lblEmpNo = new JLabel("\uC0AC       \uBC88");
		lblEmpNo.setBounds(40, 60, 75, 21);
		lblEmpNo.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		PI.add(lblEmpNo);

		JLabel lblDeptName = new JLabel("\uBD80       \uC11C");
		lblDeptName.setBounds(40, 100, 75, 21);
		lblDeptName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		PI.add(lblDeptName);

		JLabel lblJobId = new JLabel("\uC5C5       \uBB34");
		lblJobId.setBounds(40, 140, 75, 21);
		lblJobId.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		PI.add(lblJobId);

		JLabel lblPhoneNum = new JLabel("\uC804 \uD654 \uBC88 \uD638");
		lblPhoneNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNum.setBounds(335, 20, 75, 21);
		PI.add(lblPhoneNum);
		lblPhoneNum.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(335, 100, 75, 21);
		PI.add(lblEmail);
		lblEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		JLabel lblHireDate = new JLabel("\uC785  \uC0AC  \uC77C ");
		lblHireDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHireDate.setBounds(335, 60, 75, 21);
		PI.add(lblHireDate);
		lblHireDate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		JLabel lblHireType = new JLabel("\uACE0\uC6A9\uD615\uD0DC ");
		lblHireType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHireType.setBounds(335, 140, 75, 21);
		PI.add(lblHireType);
		lblHireType.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		textFieldEmpName = new JTextField();
		textFieldEmpName.setBounds(120, 20, 116, 23);
		PI.add(textFieldEmpName);
		textFieldEmpName.setColumns(10);

		textFieldEmpNo = new JTextField();
		textFieldEmpNo.setBounds(120, 60, 116, 21);
		PI.add(textFieldEmpNo);
		textFieldEmpNo.setColumns(10);

		textFieldDeptName = new JTextField();
		textFieldDeptName.setBounds(120, 100, 116, 21);
		PI.add(textFieldDeptName);
		textFieldDeptName.setColumns(10);

		textFieldJobId = new JTextField();
		textFieldJobId.setBounds(120, 140, 116, 21);
		PI.add(textFieldJobId);
		textFieldJobId.setColumns(10);

		txtXxx = new JTextField();
		txtXxx.setBounds(435, 20, 116, 21);
		PI.add(txtXxx);
		txtXxx.setColumns(10);

		txtHiredate = new JTextField();
		txtHiredate.setBounds(435, 60, 116, 21);
		PI.add(txtHiredate);
		txtHiredate.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(435, 100, 116, 21);
		PI.add(txtEmail);
		txtEmail.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uC815\uADDC\uC9C1");
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setBounds(435, 140, 70, 23);
		PI.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uBE44\uC815\uADDC\uC9C1");
		rdbtnNewRadioButton_1.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_1.setBounds(500, 140, 80, 23);
		PI.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_1);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(755, 17, 97, 23);
		panelPI.add(btnUpdate);

		JPanel panelPay = new JPanel();
		panelPay.setBackground(Color.LIGHT_GRAY);
		panelPay.setBounds(77, 335, 775, 160);
		panelPI.add(panelPay);
		panelPay.setLayout(null);

		JLabel lblCertiPay = new JLabel("\uC790\uACA9\uC99D \uC218\uB2F9");
		lblCertiPay.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblCertiPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCertiPay.setBounds(15, 70, 80, 20);
		panelPay.add(lblCertiPay);

		JLabel lblCarrPay = new JLabel("\uACBD\uB825 \uC218\uB2F9");
		lblCarrPay.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblCarrPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarrPay.setBounds(15, 110, 72, 20);
		panelPay.add(lblCarrPay);

		JLabel 기본급여 = new JLabel("\uAE30\uBCF8 \uAE09\uC5EC");
		기본급여.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		기본급여.setHorizontalAlignment(SwingConstants.RIGHT);
		기본급여.setBounds(15, 30, 72, 20);
		panelPay.add(기본급여);

		JLabel lblNewLabel_2 = new JLabel("\uC6D0");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(286, 30, 57, 21);
		panelPay.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uC6D0");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(286, 70, 57, 21);
		panelPay.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uC6D0");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(286, 110, 57, 21);
		panelPay.add(lblNewLabel_4);

		JLabel lblTotalSal = new JLabel("\uCD1D\uAE09\uC5EC");
		lblTotalSal.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblTotalSal.setBounds(77, 282, 57, 20);
		panelPI.add(lblTotalSal);

		JLabel lblNewLabel_1 = new JLabel("\uC6D0");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(265, 282, 57, 21);
		panelPI.add(lblNewLabel_1);
		frame.setTitle("급여관리시스템");
		frame.setBounds(100, 100, 943, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}