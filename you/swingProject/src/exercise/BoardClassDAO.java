package exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hospital.StaffDTO;

public class BoardClassDAO {
	
	Connection con;
	BoardClassDTO dto;

	public Connection dbInfo() throws Exception { // Connection 정보를 리턴시키는 메서드
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/hospital?useUnicode=true&characterEncoding=UTF-8";
		String user = "root";
		String password = "1234";

		con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	public BoardClassDTO insert(BoardClassDTO dto) throws Exception { 
		Connection c = dbInfo();
//		dto = new BoardClassDTO();
		String sql = "insert into board values(?,?,?)";  //칼럼순서: title,content,num 
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1,dto.getTitle());
		ps.setString(2, dto.getContent());
		ps.setString(3, dto.getNum());
		
		ps.executeUpdate();
		dbInfo().close();
		
		return dto;
	} //insert 메서드 종료

	public ArrayList <BoardClassDTO> selectAll() throws Exception{
		Connection c2 = dbInfo();
		String sql = "select * from board";
		PreparedStatement ps = c2.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		BoardClassDTO dto2 = null;
		ArrayList<BoardClassDTO> list = new ArrayList<>();
		while (rs.next()) {
			dto2 = new BoardClassDTO();
			String title = rs.getString("title");
			String content = rs.getString("content");
			String num = rs.getString("num");
		
		    dto2.setTitle(title);
		    dto2.setContent(content);
		    dto2.setNum(num);
			list.add(dto2);
	}
	return list;
	}
	
	
} //클래스 종료
