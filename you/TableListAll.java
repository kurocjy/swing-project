package hospital;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import javax.swing.ScrollPaneConstants;

public class TableListAll extends JPanel {
	JTable tables;
	JScrollPane scroll;

	public TableListAll() throws Exception {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Vector<Object> set = new Vector<>();
		Vector<String> col = new Vector<>();
		col.add("사원번호");
		col.add("이름");
		col.add("성별");
		col.add("입사년도");
		col.add("연락처");
		col.add("주소");
		col.add("사원구분");
		col.add("학력");
		col.add("급여");
		col.add("주민번호");

		StaffDAO dao = new StaffDAO();
		ArrayList<StaffDTO> list = new ArrayList<StaffDTO>();
		list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			StaffDTO dto = new StaffDTO();
			dto = list.get(i);
			Vector<Comparable> row = new Vector<Comparable>();
			row.add(dto.getNum());
			row.add(dto.getName());
			row.add(dto.getGender());
			row.add(dto.getS_date());
			row.add(dto.getTel());
			row.add(dto.getAddr());
			row.add(dto.getType());
			row.add(dto.getUniv());
			row.add(dto.getMoney());
			row.add(dto.getSsn());
			set.add(row);
		}

		tables = new JTable(set, col);
		scroll = new JScrollPane(tables);
		scroll.setPreferredSize(new Dimension(1050, 150));
		add(scroll);

		String s = "";
		tables.getValueAt(0, 0);
		tables.getValueAt(0, 0);
		s = (String)tables.getValueAt(0, 0);
		System.out.println(s);  //0행 0열의 값이 출력됨 --> 사원번호 열의 0번째 행의 값인 : 090315002가 출력
		
		System.out.println(tables.getSelectedColumn());

		this.tables.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			      JTable tables = (JTable)e.getSource();	
			      int row = tables.getSelectedRow();
			      int column = tables.getSelectedColumn();
			      // do some action if appropriate column
			      if(row==0) {
			    	  System.out.println("0번째 행 클릭!!!");
			    	  StaffInfo info = new StaffInfo(); 
			      } else if(row==1) {
			    	  System.out.println("1번째 행 클릭!!!");
			    	  StaffDAO dao = new StaffDAO();
			    	  StaffDTO dto = new StaffDTO();
			    	  try {
						dao.search((String)tables.getValueAt(1, 0));  //리턴값 dto
						System.out.println(dao.search((String)tables.getValueAt(1, 0)));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			      }
			  }
			});

//		this.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseReleased(MouseEvent e) {
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//			}
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				int selectedIndex;
//				tables = (JTable)e.getSource();
//				selectedIndex = tables.getSelectedRow();
//				System.out.println(selectedIndex);
//				System.out.println("클릭클릭");
//			}
//		});
	} // 생성자 종료

} // JPanel 클래스 종료
