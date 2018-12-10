package hospital;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class StaffDAO {

	static String addr = "D:\\yoo\\book\\src\\manager";
	Connection con;

	public Connection dbInfo() throws Exception { // Connection 정보를 리턴시키는 메서드
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/hospital?useUnicode=true&characterEncoding=UTF-8";
		String user = "root";
		String password = "1234";

		con = DriverManager.getConnection(url, user, password);
		return con;
	}

	// 커넥션 연결 메서드
	public boolean connection() {
		boolean result = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hospital?useUnicode=true&characterEncoding=UTF-8";
			String user = "root";
			String password = "1234";
			con = DriverManager.getConnection(url, user, password);
			result = true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}

	public void insert(StaffDTO dto) throws Exception { // db에다 데이터 삽입
		if (connection()) { // connection()이 true이면 실행
			dbInfo();
			System.out.println(dto.getName());
			String sql = "insert into staff values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = dbInfo().prepareStatement(sql);
			ps.setString(1, dto.getNum()); // 사원번호
			ps.setString(2, dto.getName()); // 이름
			ps.setString(3, dto.getGender()); // 성별
			ps.setString(4, dto.getS_date()); // 입사일자(date로 db에 저장)
			ps.setString(5, dto.getTel()); // 연락처
			ps.setString(6, dto.getAddr()); // 주소
			ps.setString(7, dto.getType()); // 직급
			ps.setString(8, dto.getUniv()); // 학력
			ps.setInt(9, dto.getMoney()); // 급여
			ps.setString(10, dto.getSsn()); // 주민번호

			ps.executeUpdate();
			dbInfo().close();
			ps.close();
		}
	} // insert메서드 종료

	public ArrayList<StaffDTO> selectAll() throws Exception { // 전체조회 메서드
		// 1.드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");

		// 2.db연결
		String url = "jdbc:mysql://localhost:3306/hospital?useUnicode=true&characterEncoding=UTF-8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// 3.sql문 객체화
		String sql = "select * from staff";
		PreparedStatement ps = con.prepareStatement(sql);

		// 4.SQL문 실행 요청
		ResultSet rs = ps.executeQuery();
		StaffDTO dto = null;
		ArrayList<StaffDTO> list = new ArrayList<>();
		while (rs.next()) {
			dto = new StaffDTO();
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

			dto.setNum(num);
			dto.setName(name);
			dto.setGender(gender);
			dto.setS_date(s_date);
			dto.setTel(tel);
			dto.setAddr(addr);
			dto.setType(type);
			dto.setUniv(univ);
			dto.setMoney(money);
			dto.setSsn(ssn);

			list.add(dto); // while문이 반복될때마다 새로운 주소값을 가진 dto에 id,pw,content,company의 멤버변수를 가리키는 주소값이 저장
		} // while문 종료

		return list;

	} // selectAll()종료

	public StaffDTO search(String num) throws Exception { // 사원번호를 통한 검색
		StaffDTO dto = null;
		System.out.println(connection());
		if (connection()) {
			ResultSet rs = null;
			String sql = "select * from staff where num=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, num);

			rs = ps.executeQuery();

			if (rs.next()) {
				dto = new StaffDTO();
				dto.setNum(rs.getString("num"));

				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setS_date(rs.getString("s_date"));
				dto.setTel(rs.getString("tel"));
				dto.setAddr(rs.getString("addr"));
				dto.setType(rs.getString("type"));
				dto.setUniv(rs.getString("univ"));
				dto.setMoney(rs.getInt("money"));
				dto.setSsn(rs.getString("ssn"));

			}

		} // if문 종료
		return dto;
	}// search()종료

	public StaffDTO search2(String name) throws Exception { // 이름을 이용한 검색
		StaffDTO dto = null;
		System.out.println(connection());
		if (connection()) {
			ResultSet rs = null;
			String sql = "select * from staff_of_hospital where name=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);

			rs = ps.executeQuery();

			if (rs.next()) {
				dto = new StaffDTO();
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setS_date(rs.getString("s_date"));
				dto.setTel(rs.getString("tel"));
				dto.setAddr(rs.getString("addr"));
				dto.setType(rs.getString("type"));
				dto.setUniv(rs.getString("univ"));
				dto.setMoney(rs.getInt("money"));
				dto.setSsn(rs.getString("ssn"));

			}

		} // if문 종료
		return dto;
	}// 메서드종료

	public StaffDTO revise() throws Exception, Exception {
		StaffDTO dto = new StaffDTO();
		if (connection()) {
			String sql = "update staff_of_hospital set num=?, name=?, gender=?, s_date=?, tel=?, addr=?, type=?, univ=?, money=?, ssn=?";
			PreparedStatement ps = dbInfo().prepareStatement(sql);
			ps.setString(1, dto.getNum());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getGender());
			ps.setString(4, dto.getS_date());
			ps.setString(5, dto.getTel());
			ps.setString(6, dto.getAddr());
			ps.setString(7, dto.getType());
			ps.setString(8, dto.getUniv());
			ps.setInt(9, dto.getMoney());
			ps.setString(10, dto.getSsn());

			ps.executeUpdate();

		} // if문 종료

		return dto;
	}

	public void save(StaffDTO dto) throws IOException {
//		StaffDTO dto = new StaffDTO();
		Writer file = new FileWriter(dto.getName() + ".txt");
		File f = new File(dto.getName() + ".txt");
		System.out.println("------------------");
		System.out.println("------------------");

		file.write(dto.getNum() + "\r\n");
		file.write(dto.getName() + "\r\n");
		file.write(dto.getGender() + "\r\n");
		file.write(dto.getS_date() + "\r\n");
		file.write(dto.getTel() + "\r\n");
		file.write(dto.getAddr() + "\r\n");
		file.write(dto.getType() + "\r\n");
		file.write(dto.getUniv() + "\r\n");
		file.write(dto.getMoney() + "\r\n");
		file.write(dto.getSsn() + "\r\n");

		file.flush();
		file.close();

	} // save메서드 종료

	public StaffDTO read(String num) throws Exception {  //dto의 있는 값들을 읽어오는 메서드
		StaffDTO dto = new StaffDTO();
		File f = new File(dto.getName() + ".txt");
		Scanner sc = new Scanner(f);
		dto.setNum(sc.nextLine());
		dto.setName(sc.nextLine());
		dto.setGender(sc.nextLine());
		dto.setS_date(sc.nextLine());
		dto.setTel(sc.nextLine());
		dto.setAddr(sc.nextLine());
		dto.setType(sc.nextLine());
		dto.setUniv(sc.nextLine());
		dto.setMoney(sc.nextInt());
		dto.setSsn(sc.next());
		sc.close();
		return dto;
	}
	
	public void updateRevise(String num,String name, String gender, String s_date, String tel, String addr, String type, String univ, String ssn) throws Exception {
		StaffDTO dto = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hospital";
			String user = "root";
			String password = "1234";
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "update staff set num=?, name=?, gender=?, s_date=?, tel=?, addr=?, type=?, univ=?,  where num=?";
			ps = con.prepareStatement(sql);
			
		
//			ps.setString(1, pw);
//			ps.setString(2, name);
//			ps.setString(3, birth);
//			ps.setString(4, gender);
//			ps.setString(5, tel);
//			ps.setString(6, id);
			
			
			ps.executeUpdate();
			
		
			
	}

	

	public static void main(String[] args) {
		StaffDAO dao = new StaffDAO();
//		dao.search(num)
	}
}
