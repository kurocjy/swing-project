package hospital;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class StaffList extends JPanel {
	JTable tables;
	JScrollPane scroll;
	
	public StaffList() throws Exception {
		
		
		
		
		
		JLabel label = new JLabel("직원 명단");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		setLayout(null);
		
		label.setOpaque(true);
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		label.setBackground(SystemColor.inactiveCaption);
		label.setBounds(0, 0, 442, 54);
		add(label);

		Vector<Object> dataset = new Vector<>();
		Vector<String> column = new Vector<>();
		column.add("사원명");
		column.add("사원번호");
		column.add("사원구분");
		column.add("연락처");
		StaffDAO dao = new StaffDAO();
		ArrayList<StaffDTO> list = new ArrayList<StaffDTO>();
		list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			StaffDTO dto = new StaffDTO();
			dto = list.get(i);
			Vector<Comparable> row = new Vector<Comparable>();
			row.add(dto.getName());
			row.add(dto.getNum());
			row.add(dto.getType());
			row.add(dto.getTel());
			dataset.add(row);
		}
		
		tables = new JTable(dataset,column);
		scroll = new JScrollPane(tables);
		SearchStaff ss = new SearchStaff();
		ss.add(scroll);
		
		setBounds(50,50,442, 446);
		setVisible(true);

	}//생성자 종료
		
	
		
	}
	
	


