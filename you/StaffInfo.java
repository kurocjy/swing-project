package hospital;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;

public class StaffInfo extends JFrame {
	private JTextField num;       //사원번호
	private JTextField name;
	private JTextField gender;
	private JTextField ssn;       //주민번호
	private JTextField tel;
	private JTextField type;
	private JTextField date;      //입사날짜
	private JTextField univ;
	private JTextField addr;
	private JTextField money;

	public StaffInfo() {
//		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setSize(409, 500);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("직원 정보");
		label.setBackground(SystemColor.inactiveCaption);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		label.setOpaque(true);
		label.setBounds(0, 0, 393, 61);
		label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("사원번호");
		lblNewLabel.setBounds(30, 91, 79, 15);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		num = new JTextField();
		num.setBounds(101, 87, 285, 21);
		getContentPane().add(num);
		num.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("사원명");
		lblNewLabel_1.setBounds(30, 116, 79, 15);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		name = new JTextField();
		name.setBounds(101, 112, 122, 21);
		getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("성별");
		lblNewLabel_2.setBounds(235, 116, 34, 15);
		getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		gender = new JTextField();
		gender.setBounds(270, 112, 116, 21);
		getContentPane().add(gender);
		gender.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("주민등록번호");
		lblNewLabel_3.setBounds(18, 141, 91, 15);
		getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		ssn = new JTextField();   //주민번호
		ssn.setBounds(101, 137, 122, 21);
		getContentPane().add(ssn);
		ssn.setToolTipText("ex) 000000-0000000");
		ssn.setColumns(10);
		
		JLabel label1 = new JLabel("연락처");
		label1.setBounds(235, 141, 57, 15);
		getContentPane().add(label1);
		label1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		tel = new JTextField();    //연락처
		tel.setBounds(270, 137, 116, 21);
		getContentPane().add(tel);
		tel.setToolTipText("ex) 010-0000-0000");
		tel.setColumns(10);
		
		JLabel label_1 = new JLabel("사원구분");   
		label_1.setBounds(30, 163, 68, 15);
		getContentPane().add(label_1);
		label_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		type = new JTextField();
		type.setBounds(101, 159, 122, 21);
		getContentPane().add(type);
		type.setColumns(10);
		
		JLabel label_2 = new JLabel("입사일자");
		label_2.setBounds(224, 163, 68, 15);
		getContentPane().add(label_2);
		label_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		date = new JTextField();     //입사일자
		date.setBounds(270, 159, 116, 21);
		getContentPane().add(date);
		date.setToolTipText("ex) 2018-11-29");
		date.setColumns(10);
		
		JLabel label_3 = new JLabel("학력");
		label_3.setBounds(40, 188, 34, 15);
		getContentPane().add(label_3);
		label_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		univ = new JTextField();
		univ.setBounds(101, 184, 285, 21);
		getContentPane().add(univ);
		univ.setColumns(10);
		
		JLabel label_4 = new JLabel("주소");
		label_4.setBounds(40, 213, 34, 15);
		getContentPane().add(label_4);
		label_4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		JLabel label_5 = new JLabel("급여");
		label_5.setBounds(40, 238, 34, 15);
		getContentPane().add(label_5);
		label_5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		addr = new JTextField();   //주소
		addr.setBounds(101, 209, 285, 21);
		getContentPane().add(addr);
		addr.setColumns(10);
		
		money = new JTextField();   //급여
		money.setBounds(101, 234, 285, 21);
		getContentPane().add(money);
		money.setColumns(10);
		
		JButton rg = new JButton("정보 수정");
		rg.setBounds(58, 275, 285, 32);
		getContentPane().add(rg);
		
		
		
		
		
		setVisible(true);
	}
}
