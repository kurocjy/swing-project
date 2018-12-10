package hospital;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StaffTable extends JPanel {
	String result;
	JTable tables;
	JScrollPane scroll;

	public StaffTable() throws Exception {

		setLayout(null);
		

		

		StaffDTO dto1 = new StaffDTO();
		String header[] = { "사원명", "사원번호", "사원구분", "연락처" };

		
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
	

		MyMouseListener mouse = new MyMouseListener();
		tables.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					System.out.println("클릭 하셨습니다.");
				} else if (e.getClickCount() == 2) {
					System.out.println("두번 클릭하셨습니다.");
				}
			}
		});

		add(scroll, BorderLayout.CENTER);
		scroll.setBounds(0, 10, 411, 175);
		setVisible(true);
	} // 생성자 종료

	public static void main(String[] args) {
		try {
			StaffTable t = new StaffTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
