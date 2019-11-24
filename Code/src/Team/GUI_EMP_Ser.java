package Team;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.Font;

public class GUI_EMP_Ser {

   JFrame frame;
   private JTextField textSearchText;
   private final ButtonGroup buttonGroup = new ButtonGroup();
   private final ButtonGroup buttonGroup1 = new ButtonGroup();
   private final ButtonGroup buttonGroup2 = new ButtonGroup();
   JComboBox careerser;
   JComboBox career;
   private Salsys_addmin_DTO infoSet;
   private SalDTO salSet;



   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               GUI_EMP_Ser window = new GUI_EMP_Ser(args);
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
 * @param list 
    */
   public GUI_EMP_Ser(String[] list) {
	   initialize1(list);
   }

   /**
    * Initialize the contents of the frame.
 * @param list 
 * @wbp.parser.entryPoint
    */
  
private void initialize1(String[] list) {
	  
      SalsysDAO_Login dao = new SalsysDAO_Login();
      infoSet=dao.setInfo(list[0]);
      salSet=dao.salInfo(list[0]);
	   
	   
	   
	   
      frame = new JFrame();
      frame.setBounds(100, 100, 1280, 650);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      tabbedPane.setBounds(0, 0, 930, 632);
      frame.getContentPane().add(tabbedPane);

      JPanel Search = new JPanel();
      tabbedPane.addTab("\uAC80   \uC0C9", null, Search, null);
      Search.setLayout(null);

      // comboBox ¸¸µé±â
      JComboBox name = new JComboBox();
      name.setBounds(30, 42, 105, 25);
      name.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      Search.add(name);

      name.addItem(" ÀÌ   ¸§");
      name.addItem(" ºÎ   ¼­");
      name.addItem(" »ç   ¹ø");

      textSearchText = new JTextField();
      textSearchText.setBounds(170, 42, 350, 25);
      Search.add(textSearchText);
      textSearchText.setColumns(10);

      JButton btnSearchButton = new JButton("\uAC80   \uC0C9");
      btnSearchButton.setBounds(595, 43, 97, 23);
      btnSearchButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      Search.add(btnSearchButton);

      JLabel lblCareerKind = new JLabel("\uACBD\uB825 \uBD84\uC57C");
      lblCareerKind.setBounds(298, 139, 88, 25);
      lblCareerKind.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      Search.add(lblCareerKind);

      career = new JComboBox();
      career.setBounds(386, 139, 123, 25);
      career.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
      Search.add(career);

      career.addItem("ÇØ´ç¾øÀ½");
      career.addItem(" C¾ð¾î");
      career.addItem(" Java");
      career.addItem(" Network");
      career.addItem(" Linux");

      JLabel lblCertiKind = new JLabel("\uC790\uACA9\uC99D \uC885\uB958");
      lblCertiKind.setBounds(47, 140, 88, 20);
      lblCertiKind.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      Search.add(lblCertiKind);

      JComboBox certi = new JComboBox();
      certi.setBounds(139, 139, 110, 25);
      certi.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
      Search.add(certi);

      certi.addItem("ÇØ´ç¾øÀ½");
      certi.addItem("Á¤º¸Ã³¸®±â»ç");
      certi.addItem("¸®´ª½º¸¶½ºÅÍ");
      certi.addItem("OCJP");
      certi.addItem("OCJD");
      certi.addItem("CCNA");
      certi.addItem("CCNP");

      JLabel lblCertiSer = new JLabel("\uACBD\uB825 \uAE30\uAC04");
      lblCertiSer.setBounds(547, 138, 88, 25);
      lblCertiSer.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      Search.add(lblCertiSer);

      // ¿©±â¼­ºÎÅÍ °æ·ÂÁ¾·ù ¹× ±â°£ Ãß°¡
      careerser = new JComboBox();
      careerser.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
      careerser.setBounds(632, 140, 257, 25);
      Search.add(careerser);

      JList listResult = new JList();
      listResult.setBounds(30, 335, 814, 150);
      Search.add(listResult);

      Thread1 thread1 = new Thread1();
      Thread thread = new Thread(thread1);
      thread.start();

      JPanel Mypage = new JPanel();
      tabbedPane.addTab("\uAC1C\uC778\uC815\uBCF4", null, Mypage, null);
      Mypage.setLayout(null);

      JPanel Picture = new JPanel();
      Picture.setBounds(70, 60, 120, 160);
      Picture.setBackground(Color.WHITE);
      Mypage.add(Picture);
      SpringLayout sl_Picture = new SpringLayout();
      Picture.setLayout(sl_Picture);

      ImageIcon ic = new ImageIcon("C:\\Users\\smhrc01\\Desktop\\»çÁø\\"+list[0]+".jpg");
      JLabel Picture1 = new JLabel(ic);
      Picture1.setBounds(32, 50, 170, 180);
      Picture.add(Picture1);
      Picture.setVisible(true);
      
      
      
      
      
      
      
      JLabel lblNewLabel = new JLabel("\uC0AC \uC9C4");
      sl_Picture.putConstraint(SpringLayout.NORTH, lblNewLabel, 69, SpringLayout.NORTH, Picture);
      sl_Picture.putConstraint(SpringLayout.EAST, lblNewLabel, -47, SpringLayout.EAST, Picture);
      Picture.add(lblNewLabel);

      JPanel PI = new JPanel();
      PI.setBounds(240, 50, 612, 180);
      PI.setBackground(Color.LIGHT_GRAY);
      Mypage.add(PI);
      PI.setLayout(null);

      JLabel lblEmpName = new JLabel("\uC774       \uB984");
      lblEmpName.setBounds(40, 20, 75, 21);
      lblEmpName.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      PI.add(lblEmpName);

      JLabel lblEmpNo = new JLabel("\uC0AC       \uBC88");
      lblEmpNo.setBounds(40, 60, 75, 21);
      lblEmpNo.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      PI.add(lblEmpNo);

      JLabel lblDeptName = new JLabel("\uBD80       \uC11C");
      lblDeptName.setBounds(40, 100, 75, 21);
      lblDeptName.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      PI.add(lblDeptName);

      JLabel lblJobId = new JLabel("\uC5C5       \uBB34");
      lblJobId.setBounds(40, 140, 75, 21);
      lblJobId.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      PI.add(lblJobId);

      JLabel lblPhonNum = new JLabel("\uC804 \uD654 \uBC88 \uD638");
      lblPhonNum.setHorizontalAlignment(SwingConstants.RIGHT);
      lblPhonNum.setBounds(335, 20, 75, 21);
      PI.add(lblPhonNum);
      lblPhonNum.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

      JLabel lblEmail = new JLabel("Email");
      lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
      lblEmail.setBounds(335, 100, 75, 21);
      PI.add(lblEmail);
      lblEmail.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

      JLabel lblHireDate = new JLabel("\uC785  \uC0AC  \uC77C ");
      lblHireDate.setHorizontalAlignment(SwingConstants.RIGHT);
      lblHireDate.setBounds(335, 60, 75, 21);
      PI.add(lblHireDate);
      lblHireDate.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

      JLabel lblHireType = new JLabel("\uACE0\uC6A9\uD615\uD0DC ");
      lblHireType.setHorizontalAlignment(SwingConstants.RIGHT);
      lblHireType.setBounds(335, 140, 75, 21);
      PI.add(lblHireType);
      lblHireType.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

      
      
      
      JLabel empname = new JLabel(infoSet.getEMP_NAME());
      empname.setBounds(120, 20, 100, 25);
      PI.add(empname);

      JLabel empno = new JLabel(Integer.toString(infoSet.getEMP_NO()));
      empno.setBounds(120, 60, 100, 25);
      PI.add(empno);

      JLabel deptname = new JLabel(infoSet.getDEPT_NO());
      deptname.setBounds(120, 100, 100, 25);
      PI.add(deptname);

      JLabel jobid = new JLabel(infoSet.getSAL_CLASS());
      jobid.setBounds(120, 145, 100, 25);
      PI.add(jobid);

      JLabel phonenum = new JLabel(infoSet.getPHONE());
      phonenum.setBounds(435, 25, 100, 25);
      PI.add(phonenum);

      JLabel hiredate = new JLabel(infoSet.getHIRE_DATE());
      hiredate.setBounds(435, 60, 100, 25);
      PI.add(hiredate);

      JLabel email = new JLabel(infoSet.getEMAIL());
      email.setBounds(435, 105, 100, 25);
      PI.add(email);

      JLabel hiretype = new JLabel(infoSet.getHIRE_DATE());
      hiretype.setBounds(435, 145, 100, 25);
      PI.add(hiretype);

      JPanel panelPay = new JPanel();
      panelPay.setBackground(Color.LIGHT_GRAY);
      panelPay.setBounds(77, 335, 775, 160);
      Mypage.add(panelPay);
      panelPay.setLayout(null);

      JLabel lblCertiPay = new JLabel("\uC790\uACA9\uC99D \uC218\uB2F9");
      lblCertiPay.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      lblCertiPay.setHorizontalAlignment(SwingConstants.RIGHT);
      lblCertiPay.setBounds(15, 70, 80, 20);
      panelPay.add(lblCertiPay);

      JLabel lblCarrPay = new JLabel("\uACBD\uB825 \uC218\uB2F9");
      lblCarrPay.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      lblCarrPay.setHorizontalAlignment(SwingConstants.RIGHT);
      lblCarrPay.setBounds(15, 110, 72, 20);
      panelPay.add(lblCarrPay);

      JLabel ±âº»±Þ¿© = new JLabel("\uAE30\uBCF8 \uAE09\uC5EC");
      ±âº»±Þ¿©.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      ±âº»±Þ¿©.setHorizontalAlignment(SwingConstants.RIGHT);
      ±âº»±Þ¿©.setBounds(15, 30, 72, 20);
      panelPay.add(±âº»±Þ¿©);

      JLabel lblNewLabel_2 = new JLabel("\uC6D0");
      lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      lblNewLabel_2.setBounds(286, 30, 57, 21);
      panelPay.add(lblNewLabel_2);

      JLabel lblNewLabel_3 = new JLabel("\uC6D0");
      lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      lblNewLabel_3.setBounds(286, 70, 57, 21);
      panelPay.add(lblNewLabel_3);

      JLabel lblNewLabel_4 = new JLabel("\uC6D0");
      lblNewLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      lblNewLabel_4.setBounds(286, 110, 57, 21);
      panelPay.add(lblNewLabel_4);

      JLabel lblbasicsal = new JLabel(Integer.toString(salSet.getGetbasicPay())); 
      lblbasicsal.setBackground(Color.WHITE);
      lblbasicsal.setBounds(150, 30, 116, 21);
      panelPay.add(lblbasicsal);

      JLabel lblcerpay = new JLabel(Integer.toString(salSet.getGetcerPay()));
      lblcerpay.setBounds(150, 70, 116, 21);
      panelPay.add(lblcerpay);

      JLabel lblcarpay = new JLabel(Integer.toString(salSet.getGetcarPay()));
      lblcarpay.setBounds(150, 110, 116, 21);
      panelPay.add(lblcarpay);

      JLabel lblTotalSal = new JLabel("\uCD1D\uAE09\uC5EC");
      lblTotalSal.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      lblTotalSal.setBounds(77, 282, 57, 20);
      Mypage.add(lblTotalSal);

      JLabel lblNewLabel_1 = new JLabel("\uC6D0");
      lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      lblNewLabel_1.setBounds(265, 282, 57, 21);
      Mypage.add(lblNewLabel_1);

      JLabel totalsal = new JLabel(Integer.toString(salSet.getGetSal()));
      totalsal.setBackground(Color.WHITE);
      totalsal.setBounds(131, 282, 120, 25);
      Mypage.add(totalsal);
      frame.setTitle("±Þ¿©°ü¸®½Ã½ºÅÛ");
      frame.setBounds(100, 100, 943, 636);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

   String temp1 = "";
   String temp2 = "";

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
                  careerser.addItem(" Java 3³â ¹Ì¸¸");
                  careerser.addItem(" Java 3³â ÀÌ»ó 5³â ¹Ì¸¸");
                  careerser.addItem(" Java 5³â ÀÌ»ó 7³â ¹Ì¸¸");
                  careerser.addItem(" Java 7³â ÀÌ»ó 10³â ¹Ì¸¸");
                  careerser.addItem(" Java 10³â ÀÌ»ó 15³â ¹Ì¸¸");
                  careerser.addItem(" Java 15³â ÀÌ»ó");
               } else if (a.equals(" C¾ð¾î")) {
                  careerser.removeAllItems();
                  careerser.addItem(" C¾ð¾î 3³â ¹Ì¸¸");
                  careerser.addItem(" C¾ð¾î 3³â ÀÌ»ó 5³â ¹Ì¸¸");
                  careerser.addItem(" C¾ð¾î 5³â ÀÌ»ó 7³â ¹Ì¸¸");
                  careerser.addItem(" C¾ð¾î 7³â ÀÌ»ó 10³â ¹Ì¸¸");
                  careerser.addItem(" C¾ð¾î 10³â ÀÌ»ó 15³â ¹Ì¸¸");
                  careerser.addItem(" C¾ð¾î 15³â ÀÌ»ó");
               } else if (a.equals(" Network")) {
                  careerser.removeAllItems();
                  careerser.addItem(" Network 3³â ¹Ì¸¸");
                  careerser.addItem(" Network 3³â ÀÌ»ó 5³â ¹Ì¸¸");
                  careerser.addItem(" Network 5³â ÀÌ»ó 7³â ¹Ì¸¸");
                  careerser.addItem(" Network 7³â ÀÌ»ó 10³â ¹Ì¸¸");
                  careerser.addItem(" Network 10³â ÀÌ»ó 15³â ¹Ì¸¸");
                  careerser.addItem(" Network 15³â ÀÌ»ó");
               } else if (a.equals(" Linux")) {
                  careerser.removeAllItems();
                  careerser.addItem(" Linux 3³â ¹Ì¸¸");
                  careerser.addItem(" Linux 3³â ÀÌ»ó 5³â ¹Ì¸¸");
                  careerser.addItem(" Linux 5³â ÀÌ»ó 7³â ¹Ì¸¸");
                  careerser.addItem(" Linux 7³â ÀÌ»ó 10³â ¹Ì¸¸");
                  careerser.addItem(" Linux 10³â ÀÌ»ó 15³â ¹Ì¸¸");
                  careerser.addItem(" Linux 15³â ÀÌ»ó");
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

   // ¿©±â¼­ºÎÅÍ Mypage

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
      lblEmpName.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      PI.add(lblEmpName);

      JLabel lblEmpNo = new JLabel("\uC0AC       \uBC88");
      lblEmpNo.setBounds(40, 60, 75, 21);
      lblEmpNo.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      PI.add(lblEmpNo);

      JLabel lblDeptName = new JLabel("\uBD80       \uC11C");
      lblDeptName.setBounds(40, 100, 75, 21);
      lblDeptName.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      PI.add(lblDeptName);

      JLabel lblJobId = new JLabel("\uC5C5       \uBB34");
      lblJobId.setBounds(40, 140, 75, 21);
      lblJobId.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      PI.add(lblJobId);

      JLabel lblPhoneNum = new JLabel("\uC804 \uD654 \uBC88 \uD638");
      lblPhoneNum.setHorizontalAlignment(SwingConstants.RIGHT);
      lblPhoneNum.setBounds(335, 20, 75, 21);
      PI.add(lblPhoneNum);
      lblPhoneNum.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

      JLabel lblEmail = new JLabel("Email");
      lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
      lblEmail.setBounds(335, 100, 75, 21);
      PI.add(lblEmail);
      lblEmail.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

      JLabel lblHireDate = new JLabel("\uC785  \uC0AC  \uC77C ");
      lblHireDate.setHorizontalAlignment(SwingConstants.RIGHT);
      lblHireDate.setBounds(335, 60, 75, 21);
      PI.add(lblHireDate);
      lblHireDate.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

      JLabel lblHireType = new JLabel("\uACE0\uC6A9\uD615\uD0DC ");
      lblHireType.setHorizontalAlignment(SwingConstants.RIGHT);
      lblHireType.setBounds(335, 140, 75, 21);
      PI.add(lblHireType);
      lblHireType.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

      JTextField textFieldEmpName = new JTextField();
      textFieldEmpName.setBounds(120, 20, 116, 23);
      PI.add(textFieldEmpName);
      textFieldEmpName.setColumns(10);

      JTextField textFieldEmpNo = new JTextField();
      textFieldEmpNo.setBounds(120, 60, 116, 21);
      PI.add(textFieldEmpNo);
      textFieldEmpNo.setColumns(10);

      JTextField textFieldDeptName = new JTextField();
      textFieldDeptName.setBounds(120, 100, 116, 21);
      PI.add(textFieldDeptName);
      textFieldDeptName.setColumns(10);

      JTextField textFieldJobId = new JTextField();
      textFieldJobId.setBounds(120, 140, 116, 21);
      PI.add(textFieldJobId);
      textFieldJobId.setColumns(10);

      JTextField textField_4 = new JTextField();
      textField_4.setBounds(435, 20, 116, 21);
      PI.add(textField_4);
      textField_4.setColumns(10);

      JTextField textField_5 = new JTextField();
      textField_5.setBounds(435, 60, 116, 21);
      PI.add(textField_5);
      textField_5.setColumns(10);

      JTextField textField_6 = new JTextField();
      textField_6.setBounds(435, 100, 116, 21);
      PI.add(textField_6);
      textField_6.setColumns(10);

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
      lblCertiPay.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      lblCertiPay.setHorizontalAlignment(SwingConstants.RIGHT);
      lblCertiPay.setBounds(15, 70, 80, 20);
      panelPay.add(lblCertiPay);

      JLabel lblCarrPay = new JLabel("\uACBD\uB825 \uC218\uB2F9");
      lblCarrPay.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      lblCarrPay.setHorizontalAlignment(SwingConstants.RIGHT);
      lblCarrPay.setBounds(15, 110, 72, 20);
      panelPay.add(lblCarrPay);

      JLabel ±âº»±Þ¿© = new JLabel("\uAE30\uBCF8 \uAE09\uC5EC");
      ±âº»±Þ¿©.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      ±âº»±Þ¿©.setHorizontalAlignment(SwingConstants.RIGHT);
      ±âº»±Þ¿©.setBounds(15, 30, 72, 20);
      panelPay.add(±âº»±Þ¿©);

      JTextField textFieldBasicPay = new JTextField();
      textFieldBasicPay.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      textFieldBasicPay.setBounds(150, 30, 116, 21);
      panelPay.add(textFieldBasicPay);
      textFieldBasicPay.setColumns(10);

      JTextField textFieldCerPay = new JTextField();
      textFieldCerPay.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      textFieldCerPay.setBounds(150, 70, 116, 21);
      panelPay.add(textFieldCerPay);
      textFieldCerPay.setColumns(10);

      JTextField textFieldCarPay = new JTextField();
      textFieldCarPay.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      textFieldCarPay.setBounds(150, 110, 116, 21);
      panelPay.add(textFieldCarPay);
      textFieldCarPay.setColumns(10);

      JLabel lblNewLabel_2 = new JLabel("\uC6D0");
      lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      lblNewLabel_2.setBounds(286, 30, 57, 21);
      panelPay.add(lblNewLabel_2);

      JLabel lblNewLabel_3 = new JLabel("\uC6D0");
      lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      lblNewLabel_3.setBounds(286, 70, 57, 21);
      panelPay.add(lblNewLabel_3);

      JLabel lblNewLabel_4 = new JLabel("\uC6D0");
      lblNewLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      lblNewLabel_4.setBounds(286, 110, 57, 21);
      panelPay.add(lblNewLabel_4);

      JLabel lblTotalSal = new JLabel("\uCD1D\uAE09\uC5EC");
      lblTotalSal.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      lblTotalSal.setBounds(77, 282, 57, 20);
      panelPI.add(lblTotalSal);

      JTextField textFieldTotalPay = new JTextField();
      textFieldTotalPay.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      textFieldTotalPay.setBounds(137, 282, 116, 25);
      panelPI.add(textFieldTotalPay);
      textFieldTotalPay.setColumns(10);

      JLabel lblNewLabel_1 = new JLabel("\uC6D0");
      lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      lblNewLabel_1.setBounds(265, 282, 57, 21);
      panelPI.add(lblNewLabel_1);
      frame.setTitle("±Þ¿©°ü¸®½Ã½ºÅÛ");
      frame.setBounds(100, 100, 943, 636);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   }
}