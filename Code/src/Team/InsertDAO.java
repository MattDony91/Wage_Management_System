package Team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDAO {
   Connection conn;
   String url = "jdbc:oracle:thin@192.168.0.80:1521:xe:";
   String id = "";
   String pw = "";
   private PreparedStatement pst = null;

   InsertDAO() {
      init();
   }

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

   public void setInsert(int emp_no, String emp_name, String emp_regno, 
		   String phone, String adopttype, String salclass, String empgrade, String email,
         String addr, int dept_no, int emp_pw, String hire_date,String career,String certi) {
      int cnt = 0;
      try {

         String sql = "insert into emp values(?,?,?,?,?,?,?,?,?,?,?,?)";
         pst = conn.prepareStatement(sql);

         pst.setInt(1, emp_no);
         pst.setString(2, emp_name);
         pst.setString(3, emp_regno);
         pst.setString(4, phone);
         pst.setString(5, adopttype);
         pst.setString(6, salclass);
         pst.setString(7, empgrade);
         pst.setString(8, email);
         pst.setString(9, addr);
         pst.setInt(10, dept_no);
         pst.setInt(11, emp_pw);
         pst.setString(12, hire_date);
        

         cnt = pst.executeUpdate();
         
         sql = "INSERT INTO sal_mgt(emp_no, basic_pay) select e.emp_no, s.basic_pay from emp e, sal_sys s where e.sal_class = s.sal_class and emp_no = ?";
         pst = conn.prepareStatement(sql);
         
         pst.setInt(1, emp_no);
         cnt = pst.executeUpdate();
         
         sql = "UPDATE sal_mgt SET cer_ser = ? where emp_no = ?";
         
         pst = conn.prepareStatement(sql);
         pst.setString(1,certi);
         pst.setInt(2, emp_no);
         
         cnt =pst.executeUpdate();
         
         sql = "UPDATE sal_mgt SET cer_pay = (SELECT certi.cer_pay FROM certi, sal_mgt WHERE certi.cer_ser = sal_mgt.cer_ser AND emp_no = ?) WHERE emp_no =?";
         
         pst = conn.prepareStatement(sql);
         pst.setInt(1,emp_no);
         pst.setInt(2, emp_no);
         
         cnt =pst.executeUpdate();	
         
         sql = "UPDATE sal_mgt SET car_ser = ? WHERE emp_no = ?";
         
         pst = conn.prepareStatement(sql);
         pst.setString(1,career);
         pst.setInt(2, emp_no);
         
         cnt =pst.executeUpdate();
         
         sql = "UPDATE sal_mgt SET car_pay = (SELECT carrier.car_pay FROM carrier, sal_mgt WHERE carrier.car_ser = sal_mgt.car_ser AND emp_no = ?) WHERE emp_no =?";
         
         pst = conn.prepareStatement(sql);
         pst.setInt(1,emp_no);
         pst.setInt(2, emp_no);
         
         cnt =pst.executeUpdate();	
         
         
         
         
         
         
         
         if (cnt > 0) {
            System.out.println("입력성공");
         } else {
            System.out.println("입력실패");
         }

         pst.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}