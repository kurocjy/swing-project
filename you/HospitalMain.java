package hospital;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class HospitalMain extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	public HospitalMain() throws Exception {

		Image icon = Toolkit.getDefaultToolkit().getImage("012.png");
		setIconImage(icon);
		setTitle("병원 관리 프로그램");
		setSize(1078, 780);

		// 탭설정
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		// 진료관리
		JPanel treat = new JPanel();
		tabbedPane.addTab("진료관리", treat);

		JPanel patient = new JPanel();
		tabbedPane.addTab("환자관리", patient);

		JPanel employee = new JPanel(); // 직원관리 패널
		employee.setLayout(null);
		tabbedPane.addTab("직원관리", employee);

		SearchStaff staff = new SearchStaff();
		staff.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		staff.setSize(434, 382);
		staff.setLocation(621, 0);
		employee.add(staff); // 직원관리 패널에다가 직원검색 패널을 삽입

		Register rg = new Register();
		rg.setBounds(0, 0, 416, 382);
		employee.add(rg);
		
		StaffAll all = new StaffAll();
		all.setBounds(0, 427, 1100, 279);
		employee.add(all);

		setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		HospitalMain hm = new HospitalMain();
		

	} // main종료

} // 클래스 종료
