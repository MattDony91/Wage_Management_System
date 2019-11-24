package Team;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class GUI_Login {
	private static String Distinction;
	private JFrame frame;
	private JTextField textFieldID;
	private final ButtonGroup btnGroup_Login = new ButtonGroup();
	private SalsysDAO_Login loginDAO;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					GUI_Login window = new GUI_Login();
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
	public GUI_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("±Þ¿©°ü¸®½Ã½ºÅÛ");
		frame.setBounds(100, 100, 325, 231);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblID = new JLabel("ID :");
		lblID.setBounds(35, 58, 23, 20);
		lblID.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		frame.getContentPane().add(lblID);

		JLabel lblPW = new JLabel("PW :");
		lblPW.setBounds(26, 97, 32, 20);
		lblPW.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		frame.getContentPane().add(lblPW);

		textFieldID = new JTextField();
		textFieldID.setBounds(68, 57, 122, 24);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(207, 63, 86, 54);
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String input_ID = textFieldID.getText();
				String input_PW = passwordField.getText();

				SalsysDAO_Login loginDAO = new SalsysDAO_Login();
				int cnt = loginDAO.login(Distinction, input_ID, input_PW);
				String[] list = { input_ID, input_PW, Distinction };

				if (cnt == 1) {
					if (input_ID.equals("team")) {
					
						Distinction = "1";
						GUI_Admin_Ser cd = new GUI_Admin_Ser(list);
						cd.main(list);

					} else {
						Distinction = "2";
						GUI_EMP_Ser cd = new GUI_EMP_Ser(list);
						cd.main(list);
					}
				} else {
					JOptionPane.showMessageDialog(null, "ID ¶Ç´Â PW¸¦ È®ÀÎÇÏ¼¼¿ä", "·Î±×ÀÎ¿¡ ½ÇÆÐÇÏ¼Ì½À´Ï´Ù", JOptionPane.WARNING_MESSAGE);
					frame.dispose();
					GUI_Login window = new GUI_Login();
					window.frame.setVisible(true);
				}

				frame.dispose();

			}
		});
		btnLogin.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		frame.getContentPane().add(btnLogin);

		JLabel lblLoginTitle = new JLabel("\uAE09\uC5EC\uAD00\uB9AC");
		lblLoginTitle.setBounds(110, 10, 80, 27);
		lblLoginTitle.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		frame.getContentPane().add(lblLoginTitle);

		passwordField = new JPasswordField();
		passwordField.setBounds(68, 96, 122, 24);
		frame.getContentPane().add(passwordField);
	}
}