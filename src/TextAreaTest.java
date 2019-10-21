import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TextAreaTest extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;

	JTextArea terminal;
	static final String newline = System.getProperty("line.separator");

	public TextAreaTest() {
		setBounds(0, 0, 500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);

		terminal = new JTextArea();
		terminal.addKeyListener(this);
		add(terminal, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		TextAreaTest test = new TextAreaTest();
		test.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		command(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		command(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		command(e);
	}

	private void command(KeyEvent e) {
		int keyStatus = e.getID();
		String text = terminal.getText();
		if (keyStatus == KeyEvent.KEY_PRESSED) {
			int key = e.getKeyCode();
			int modKey = e.getModifiersEx();
			if (key == KeyEvent.VK_ENTER) {
				String command = text.substring(text.lastIndexOf(newline) > 0 ? text.lastIndexOf(newline) + newline.length() : 0);
				sendLine(command);
			}
			if(modKey == KeyEvent.CTRL_DOWN_MASK) {
				if (key == KeyEvent.VK_D) {
					sendLine("exit");
				}
			}
		}
	}

	private void sendLine(String line) {
		if(line.equals("exit"))
			closeTerminal();
	}

	private void closeTerminal() {
		setVisible(false); //you can't see me!
		dispose(); //Destroy the JFrame object
	}

}
