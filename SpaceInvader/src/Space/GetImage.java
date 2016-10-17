//JACK XU
package Space;

import java.awt.*; 
import javax.swing.*;

public class GetImage extends JPanel {
	Image photo;

	//Gets image for the background for GUI
	public GetImage() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		photo = kit.getImage("meffect.jpg");
	}

	public void paintComponent(Graphics comp) {
		Graphics2D comp2D = (Graphics2D) comp;
		comp2D.drawImage(photo, 0, 0, 600, 800, this);
	}

}
