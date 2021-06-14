package Screen;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Welcome extends JFrame{
	
	//initialize MousePosition for making dragging panel 
	int mouseXPos;
	int mouseYPos;
	
	//initialize x,y,and border thickness of window.
	int xWindow = 1280; 
	int yWindow = 720;
	int borderWindowThickness = 1;
	
	//initialize buttonSpace Variables
	int buttonSpace = 50;
	
	//initialize x,y of contentPanel
	int xContentPanel = borderWindowThickness;
	int yContentPanel = 50;
	
	//initialize Button variables
	int ButtonWidth = 300;
	int ButtonHeight = 100;
	int xButton = (xWindow/2)-(ButtonWidth/2);
	
	//initialize songButton variables;
	int ySongButton =  (yWindow/2) - 200;
	int xSongButton = (xWindow/2)-(ButtonWidth/2);		
	
	//initialize artistButton and albumButton variables;
	int yArtistButton = ySongButton + ButtonHeight + buttonSpace;
	int yAlbumButton = ySongButton + 2*ButtonHeight + 2*buttonSpace;
	
	private JPanel topPane;
//	JMenuBar menuBar;
//	JMenu playlists, songs, album, artists;
	
	public Welcome() {
		
		//create Welcome Window
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(640, 0, xWindow, yWindow);
		topPane = new JPanel();
		topPane.setBackground(Color.LIGHT_GRAY);
		topPane.setBorder(BorderFactory.createLineBorder(Color.BLACK,borderWindowThickness));
		setContentPane(topPane);
		topPane.setLayout(null);
		
		//create contentpanel over welcomepanel (start from y = 50) 
		JPanel ContentPanel = new JPanel();
		ContentPanel.setBounds(1, 50, xWindow-2*borderWindowThickness, yWindow - yContentPanel);
		topPane.add(ContentPanel);
		ContentPanel.setLayout(null);
		
		//song button
		JButton songButton = new JButton("SONGS");
		songButton.setBounds(xSongButton, ySongButton, ButtonWidth, ButtonHeight);
		songButton.setFocusable(false);
		songButton.setFont(new Font("Serif", Font.PLAIN, 30));
		ContentPanel.add(songButton);
		//action go to song page
		songButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Song song = new Song();
				song.setVisible(true);
				dispose();
			}
		});
		
		//Artistbutton
		JButton artistButton = new JButton("ARTISTS");
		artistButton.setBounds(xButton, yArtistButton, ButtonWidth, ButtonHeight);
		artistButton.setFocusable(false);
		artistButton.setFont(new Font("Serif", Font.PLAIN, 30));
		ContentPanel.add(artistButton);
		//action go to artist page 
		artistButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Artist artist = new Artist();
				artist.setVisible(true);
				dispose();
			}
		});
		
		//Albumbutton
		JButton albumButton = new JButton("ALBUMS");
		albumButton.setBounds(xButton, yAlbumButton, ButtonWidth, ButtonHeight);
		albumButton.setFocusable(false);
		albumButton.setFont(new Font("Serif", Font.PLAIN, 30));
		ContentPanel.add(albumButton);
		albumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Album album = new Album();
				album.setVisible(true);
				dispose();
			}
		});
		
		
		//create CloseButton with Jlabel
		JLabel closeButton = new JLabel("x");
		closeButton.setHorizontalAlignment(SwingConstants.CENTER);
		closeButton.setOpaque(true);
		closeButton.setBackground(Color.LIGHT_GRAY);
		closeButton.setForeground(Color.RED);
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 28));
		closeButton.setBounds(xWindow - 52 - (borderWindowThickness*borderWindowThickness+2)+borderWindowThickness, borderWindowThickness, 50+borderWindowThickness+2, 50-borderWindowThickness);
		
		//add function to closeButton
		closeButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				System.exit(0);
			}
			public void mouseEntered(MouseEvent e) 
			{
				closeButton.setBackground(Color.DARK_GRAY);
			}
			public void mouseExited(MouseEvent e)
			{
				closeButton.setBackground(Color.LIGHT_GRAY);
			}
		});
		topPane.add(closeButton);
		
		//Add Name to title bar
		JLabel title = new JLabel("VOK MUSIC");
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Serif", Font.BOLD, 18));
		title.setBounds(55, 18, 135, 14);
		topPane.add(title);
		
		//add logo to title bar
		JLabel vokLogoTitle = new JLabel("");
		vokLogoTitle.setIcon(new ImageIcon(this.getClass().getResource("/vokLogo40x40.png")));
		vokLogoTitle.setBounds(10, 5, 40, 40);
		topPane.add(vokLogoTitle);
		
		//doing dragging function for welcome window
		JLabel dragLabel = new JLabel("");
		dragLabel.setBounds(0, 0, 1280, 50);
		//get mouseposition where it is pressed.
		dragLabel.addMouseListener(new MouseAdapter() 
		{
			public void mousePressed(MouseEvent e) 
			{
				mouseXPos = e.getX();
				mouseYPos = e.getY();
			}
		});
		//drag from the mouse position where it is pressed
		dragLabel.addMouseMotionListener(new MouseMotionAdapter() 
		{
			public void mouseDragged(MouseEvent e) 
			{
				int coorX = e.getXOnScreen();
				int coorY = e.getYOnScreen();
				setLocation(coorX-mouseXPos,coorY-mouseYPos);
			}

		});
		topPane.add(dragLabel);

		//Add menu bar
//		menuBar = new JMenuBar();
//		playlists = new JMenu("Playlists");
//		songs = new JMenu("Songs");
//		album = new JMenu("Album");
//		artists = new JMenu("Artists");
//		this.setJMenuBar(menuBar);
//		menuBar.add(playlists);
//		menuBar.add(songs);
//		menuBar.add(album);
//		menuBar.add(artists);
		
		

}
}
