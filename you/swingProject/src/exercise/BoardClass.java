package exercise;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class BoardClass extends JFrame {
	private JTextField t_title;
	private JTextField t_num;
	private JLabel title;
	private JLabel content;
	private JLabel num;
	ArrayList<BoardClassDTO> dto2;
	String s;
	
	public BoardClass() {
		setTitle("직원용 게시판");
		Image icon = Toolkit.getDefaultToolkit().getImage("012.png");
		setIconImage(icon);
		setSize(394, 564);
		getContentPane().setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(Color.WHITE);
		editorPane.setBounds(12, 311, 354, 204);
		getContentPane().add(editorPane);
		
		JLabel title = new JLabel("제목");
		title.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		title.setBounds(12, 31, 57, 15);
		getContentPane().add(title);
		
		t_title = new JTextField();
		t_title.setBounds(78, 28, 143, 21);
		getContentPane().add(t_title);
		t_title.setColumns(10);
		
		JLabel content = new JLabel("내용");
		content.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		content.setBounds(162, 286, 57, 15);
		getContentPane().add(content);
		
		JLabel num = new JLabel("작성자");
		num.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		num.setBounds(12, 59, 57, 15);
		getContentPane().add(num);
		
		t_num = new JTextField();
		t_num.setBounds(78, 59, 143, 21);
		getContentPane().add(t_num);
		t_num.setColumns(10);
		
		JButton register = new JButton("등록");  //등록 버튼
		register.setBounds(247, 39, 97, 23);
		getContentPane().add(register);
		
		JLabel video = new JLabel("");  //영상이 올라갈 라벨 변수 video
		video.setBounds(0, 84, 378, 192);
		getContentPane().add(video);
		
		
		
		
		
		register.addActionListener(new ActionListener() {  //등록 버튼 클릭시 수행할 내용
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BoardClassDTO dto = new BoardClassDTO();
				BoardClassDAO dao = new BoardClassDAO();
				dto.setTitle(t_title.getText());
				dto.setContent(editorPane.getText());
				dto.setNum(t_num.getText());
				//db에 저장되어 있는 사원번호와 글작성자의 사원번호가 일치하면(=등록된 직원이 맞다면) 글 작성 완료 메세지 출력!
				//이 조건을 코딩하려면 selectAll()을 통해 전체 직원정보를 ArrayList에 담아 확인해야함.
				//for문을 통해 list.num 이런식으로 해서 비교 해봐야함
				try {
//					dao.insert(dto);
					
					ArrayList<BoardClassDTO> list = dao.selectAll();  //리턴값 list(dto2);
					
					for (int i = 0; i < list.size(); i++) {
						
						if(t_num.getText().equals(list.get(i).getNum())) {
						JOptionPane.showMessageDialog(null,"정상 등록되었습니다.");	
//						String s = list.get(i).getNum();  //리스트에 저장된 dto의 사원번호값을 String s에 할당
//						System.out.println(i+"번지에 있습니다.");
						} else {
							JOptionPane.showMessageDialog(null,"가입된 직원만 이용이 가능합니다.");
						}
					} //for문 종료
					if(t_num.getText()==s) {  //글작성자의 사원번호와 db에 저장된 사원번호가 맞다면
						
					}
					

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BoardClass();
	}
}
