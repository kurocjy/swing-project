package hospital;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableEx {
	JTable tables;
	JScrollPane scroll;

	public TableEx() throws Exception {
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

		tables = new JTable(dataset, column);
		scroll = new JScrollPane(tables);
		SearchStaff ss = new SearchStaff();
		ss.add(scroll);

	}// 생성자 종료

	public static void main(String[] args) throws Exception {
		TableEx ex = new TableEx();
	}

}
