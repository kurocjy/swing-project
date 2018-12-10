package hospital;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import java.awt.SystemColor;
import java.awt.event.MouseEvent;


public class StaffAll extends JPanel {

	public StaffAll() throws Exception {
		setLayout(null);

		JLabel label = new JLabel("직원 명단");
		label.setBackground(SystemColor.inactiveCaption);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label.setBounds(0, 0, 1058, 52);
		label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		label.setOpaque(true);
		add(label);

		TableListAll all = new TableListAll();
		all.setBounds(0, 80, 1058, 213);
		add(all);

		

			
		
		setVisible(true);
	}

}
