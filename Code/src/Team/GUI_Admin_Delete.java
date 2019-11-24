package Team;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class GUI_Admin_Delete {

   private JFrame frame;
   private JTextField textFieldEmpNo;
   private JTextField textFieldEmpName;
   private JButton btnNewButton_1;
   DeleteDAO dao = new DeleteDAO();
  

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
            	GUI_Admin_Delete window = new GUI_Admin_Delete();
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
   public GUI_Admin_Delete() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setTitle("\uAE09\uC5EC\uAD00\uB9AC\uC2DC\uC2A4\uD15C - \uC0AC\uC6D0\uC0AD\uC81C");
      frame.setBounds(100, 100, 378, 237);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      JLabel lblEmpNo = new JLabel("\uC0AC\uC6D0\uBC88\uD638");
      lblEmpNo.setBounds(33, 36, 56, 34);
      frame.getContentPane().add(lblEmpNo);

      textFieldEmpNo = new JTextField();
      textFieldEmpNo.setBounds(114, 36, 113, 34);
      frame.getContentPane().add(textFieldEmpNo);
      textFieldEmpNo.setColumns(10);

      JLabel lblEmpName = new JLabel("\uC0AC\uC6D0\uC774\uB984");
      lblEmpName.setBounds(33, 93, 56, 34);
      frame.getContentPane().add(lblEmpName);

      textFieldEmpName = new JTextField();
      textFieldEmpName.setBounds(114, 93, 113, 34);
      frame.getContentPane().add(textFieldEmpName);
      textFieldEmpName.setColumns(10);

      JButton btnNewButton = new JButton("\uD655 \uC778");
      btnNewButton.setBounds(241, 36, 82, 54);
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            
            String emp_name = textFieldEmpName.getText();
            int emp_no = Integer.parseInt(textFieldEmpNo.getText());
            dao.setDelte(emp_name, emp_no);
            
         }
      });
      frame.getContentPane().add(btnNewButton);
      
      btnNewButton_1 = new JButton("\uCDE8 \uC18C");
      btnNewButton_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		frame.dispose();
      	}
      });
      btnNewButton_1.setBounds(241, 100, 82, 27);
      frame.getContentPane().add(btnNewButton_1);
   }

}