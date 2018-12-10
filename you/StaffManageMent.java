package hospital;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class StaffManageMent extends JPanel {
	
	public StaffManageMent() {
		setLayout(null);
		setSize(1300, 800);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(12, 10, 768, 510);
		panel.setLayout(null);
		panel.setSize(1183, 783);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("직원 정보");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		
		
		
		
	}
}
