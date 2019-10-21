import java.awt.Color;

import javax.swing.JFrame;

public class ProjectColor extends JFrame{
	private static final long serialVersionUID = 1L;

	public ProjectColor() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 500);
		getContentPane().setBackground(Color.black);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		ProjectColor color = new ProjectColor();
		color.setVisible(true);
	}
	
}
