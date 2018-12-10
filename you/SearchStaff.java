package hospital;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class SearchStaff extends JPanel {
	private JTextField text;
	StaffDTO dto = null;
	JTable tables;
	JScrollPane scroll;

	public SearchStaff() throws Exception {

		Container contentPane; // 콤보박스에 들어갈 내용
		String[] content = { "", "사원번호", "이름" };

		setBounds(0, 0, 437, 489); // 패널 위치
		setLayout(null);

		// 패널에다가 테이블 추가
		StaffTable stafftable = new StaffTable();   //스태프테이블: Panel(테이블이 삽입된 상태)
		stafftable.setLayout(null);
		stafftable.setBounds(12, 157, 413, 151); // 테이블 위치
		add(stafftable);

		JLabel label = new JLabel("직원 검색");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(SystemColor.inactiveCaption);
		label.setBounds(0, 0, 435, 54);
		label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label.setOpaque(true);
		add(label);

		JComboBox comboBox = new JComboBox(content);
		comboBox.setBounds(85, 109, 85, 27);
		add(comboBox);

		JLabel lblNewLabel = new JLabel("카테고리 선택");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(5, 110, 85, 22);
		add(lblNewLabel);

		text = new JTextField();
		text.setToolTipText("검색어 입력");
		text.setBounds(171, 109, 161, 27);
		add(text);
		text.setColumns(10);

		JButton b1 = new JButton("검색");
		b1.setBounds(333, 108, 75, 29);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // 검색버튼을 눌렀을때 수행할 동작
				StaffDAO dao = new StaffDAO();
				try {
					StaffDTO dto = dao.search(text.getText()); // 사용자가 입력한 검색어를 가져와 그 값을 db에 조회해서 가져오는 메서드 호출-> 그것을 어디다
																// 담아 테이블에 출력하길 원함.
//					if(text.getText().equals(dto.getName()))
					System.out.println(text.getText());
					System.out.println(dto.getName()); // 정확히 데이터가 넘어옴
					System.out.println(dto.getType());
//					Example example = new Example(dto);

				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"검색에 실패하였습니다. 정확히 입력하세요.");
				}

			}
		});
		add(b1);

		setVisible(true);

		BevelBorder border = new BevelBorder(BevelBorder.RAISED);

		setVisible(true);
	}

}
