package Screen;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class SplashScreen extends JFrame{
	
	private JPanel contentPane;
	public static JProgressBar progressBar;
	public static JLabel lblNewLabel_1;
	
	public SplashScreen() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(640, 0, 1280, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon loadingIcon = new ImageIcon(this.getClass().getResource("/Loading.gif"));
		lblNewLabel.setIcon(loadingIcon);
		lblNewLabel.setBounds(333, 134, 684, 695);
		contentPane.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(Color.BLACK);
		progressBar.setForeground(Color.WHITE);
		progressBar.setBounds(226, 973, 791, 23);
		progressBar.setBorderPainted(false);
		contentPane.add(progressBar);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(604, 937, 46, 14);
		contentPane.add(lblNewLabel_1);
	}

}
