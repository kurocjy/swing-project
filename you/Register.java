package hospital;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JScrollBar;
import java.awt.SystemColor;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class Register extends JPanel implements ActionListener {  //직원등록 클래스
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

	public Register() {   //직원등록 메서드
		
		
		
//		getContentPane().setLayout(null);
		
		
		
		
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		setBounds(0, 0, 414, 544);
		BevelBorder border = new BevelBorder(BevelBorder.RAISED);
		JLabel lblNewLabel = new JLabel("사원번호");
		lblNewLabel.setBounds(30, 91, 79, 15);
		add(lblNewLabel);
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		num = new JTextField();
		num.setBounds(101, 87, 285, 21);
		add(num);
		num.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("사원명");
		lblNewLabel_1.setBounds(30, 116, 79, 15);
		add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		name = new JTextField();
		name.setBounds(101, 112, 122, 21);
		add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("성별");
		lblNewLabel_2.setBounds(235, 116, 34, 15);
		add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		gender = new JTextField();
		gender.setBounds(270, 112, 116, 21);
		add(gender);
		gender.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("주민등록번호");
		lblNewLabel_3.setBounds(18, 141, 91, 15);
		add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		ssn = new JTextField();   //주민번호
		ssn.setBounds(101, 137, 122, 21);
		add(ssn);
		ssn.setToolTipText("ex) 000000-0000000");
		ssn.setColumns(10);
		
		JLabel label = new JLabel("연락처");
		label.setBounds(235, 141, 57, 15);
		add(label);
		label.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		tel = new JTextField();    //연락처
		tel.setBounds(270, 137, 116, 21);
		add(tel);
		tel.setToolTipText("ex) 010-0000-0000");
		tel.setColumns(10);
		
		JLabel label_1 = new JLabel("사원구분");   
		label_1.setBounds(30, 163, 68, 15);
		add(label_1);
		label_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		type = new JTextField();
		type.setBounds(101, 159, 122, 21);
		add(type);
		type.setColumns(10);
		
		JLabel label_2 = new JLabel("입사일자");
		label_2.setBounds(224, 163, 68, 15);
		add(label_2);
		label_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		date = new JTextField();     //입사일자
		date.setBounds(270, 159, 116, 21);
		add(date);
		date.setToolTipText("ex) 2018-11-29");
		date.setColumns(10);
		
		JLabel label_3 = new JLabel("학력");
		label_3.setBounds(40, 188, 34, 15);
		add(label_3);
		label_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		univ = new JTextField();
		univ.setBounds(101, 184, 285, 21);
		add(univ);
		univ.setColumns(10);
		
		JLabel label_4 = new JLabel("주소");
		label_4.setBounds(40, 213, 34, 15);
		add(label_4);
		label_4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		JLabel label_5 = new JLabel("급여");
		label_5.setBounds(40, 238, 34, 15);
		add(label_5);
		label_5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 11));
		
		addr = new JTextField();   //주소
		addr.setBounds(101, 209, 285, 21);
		add(addr);
		addr.setColumns(10);
		
		money = new JTextField();   //급여
		money.setBounds(101, 234, 285, 21);
		add(money);
		money.setColumns(10);
		
		JButton rg = new JButton("직원 등록");
		rg.setBounds(101, 278, 285, 32);
		add(rg);
		
		JLabel label_6 = new JLabel("                        직원 등록");
		label_6.setOpaque(true);
		label_6.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		label_6.setBackground(SystemColor.inactiveCaption);
		label_6.setBounds(0, 0, 415, 54);
		add(label_6);
		rg.addActionListener(new ActionListener() {  //직원등록 버튼을 눌렀을때 수행할 동작
			public void actionPerformed(ActionEvent e) {
				
				StaffDAO dao = new StaffDAO();
				StaffDTO dto = new StaffDTO();
				//인서트 메서드를 실행시켜줘야함.
				
				dto.setNum(num.getText());
				dto.setName(name.getText());
				dto.setGender(gender.getText());
				dto.setS_date(date.getText());
				dto.setTel(tel.getText());
				dto.setAddr(addr.getText());
				dto.setType(type.getText());
				dto.setUniv(univ.getText());
				int m = Integer.parseInt(money.getText());  //관리자가 입력한 급여를 가져와서 int로 변환
				dto.setSsn(ssn.getText());
				ArrayList<StaffDTO> list = new ArrayList<>();
				list.add(dto);
				

				try {
					dao.insert(dto);
					StaffTable s = new StaffTable();
					dao.save(dto);
					JOptionPane.showMessageDialog(null,"정상적으로 등록되었습니다.");
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		setVisible(true);
		

		
	} //직원등록 메서드 종료
	


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
	}
}
