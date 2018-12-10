package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;

import com.mysql.jdbc.PreparedStatement;

public class TableTest extends JFrame {
	public TableTest() {
	}
	

	public Vector getMemberList(){
	       
        Vector data = new Vector();  //Jtable에 값을 쉽게 넣는 방법 1. 2차원배열   2. Vector 에 vector추가
       
           
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try{
        	String url = "jdbc:mysql://localhost:3306/hospital";
    		String user = "root";
    		String password = "1234";
            con = DriverManager.getConnection(url, user, password);
            String sql = "select * from staff_of_hospital order by name asc";
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
            	String num = rs.getString("num");
    			String name = rs.getString("name");
    			String gender = rs.getString("gender");
    			String s_date = rs.getString("s_date");
    			String tel = rs.getString("tel");
    			String addr = rs.getString("addr");
    			String type = rs.getString("type");
    			String univ = rs.getString("univ");
    			int money = rs.getInt("money");
    			String ssn = rs.getString("ssn");
               
                Vector row = new Vector();
                row.add(num);
                row.add(name);
                row.add(gender);
                row.add(s_date);
                row.add(tel);
                row.add(addr);
                row.add(type);
                row.add(univ);
                row.add(money);
                row.add(ssn);
               
                data.add(row);             
            }//while
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }//getMemberList()

}
