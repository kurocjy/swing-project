package hospital;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {
	
	@Override
    public void mouseClicked(MouseEvent e) {
    if (e.getButton() == 1) { } //클릭
    if (e.getClickCount() == 2) { } // 더블클릭
    if (e.getButton() == 3) { } // 오른쪽 클릭
  
}

}
