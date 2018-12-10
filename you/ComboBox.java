package hospital;



import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboBox extends JFrame {
	Container contentPane;	
	String[] content = {"","사원번호","이름"};
	
	public ComboBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		JComboBox combo = new JComboBox(content);
		
		combo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			JComboBox c = (JComboBox) e.getSource();
				
			}
		});
		contentPane.add(combo);
		setSize(500,600);
		setVisible(true);
		
	} //생성자 종료

	public static void main(String[] args) {
		ComboBox cb = new ComboBox();
	}
}
