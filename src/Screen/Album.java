package Screen;

import java.awt.Color;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Screen.Artist.beMyLoverButtonHandler;
import Screen.Artist.boNhauPhiaSauButtonHandler;
import Screen.Artist.loveYouNeedYouButtonHandler;
import Screen.Artist.luVYouCusButtonHandler;
import Screen.Artist.musicSong;


public class Album extends JFrame {
	private JPanel topPane;
	int xWindow = 1280, yWindow = 720; 
	int borderWindowThickness = 1;
	
	int xContentPanel = borderWindowThickness;
	int yContentPanel = 50;
	
	int AlbumButtonWidth = 650; 
	int  AlbumButtonHeight = 50; 
	int xAlbumButtonStandard = (xWindow/2) - (AlbumButtonWidth/2);
	int xAlbumButton = (xWindow/2) - (AlbumButtonWidth/2);
	int xAlbumButtonOutBound = 5000;
	
	int yVOKEPLoveSongButton = 50;
	
	int xSongButtonOutBound = 5000; 
	int ySongButtonOutBound = 5000;
	int xSongButton = (xWindow/2) - (AlbumButtonWidth/2);
	int xSongStandardButton = (xWindow/2) - (AlbumButtonWidth/2);
	
	int yBoNhauPhiaSauChillButton = 50;
	int ybeMyLoverButton = 150; 
	int yLoveYouNeedYouButton =250; 
	int yluVYouButton = 350;
	
	int mouseXPos, mouseYPos;
	
	String checKWanCusChill; 
	checKWanCusChillButtonHandler checkHandler = new checKWanCusChillButtonHandler();
	
	String boNhauPhiaSau; 
	boNhauPhiaSauButtonHandler boNhauPhiaSauHandler = new boNhauPhiaSauButtonHandler(); 
	String beMylover; 
	beMyLoverButtonHandler beMyLoverHandler = new beMyLoverButtonHandler(); 
	String loveYouNeedYou; 
	loveYouNeedYouButtonHandler loveYouNeedYouHandler = new loveYouNeedYouButtonHandler(); 
	String luVYouCus; 
	luVYouCusButtonHandler luVYouCusHandler = new luVYouCusButtonHandler();

	
	musicSong musicSong = new musicSong();
	musicSong currentSong = new musicSong();

	
public Album() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(640, 0, xWindow, yWindow);
		topPane = new JPanel();
		topPane.setBackground(Color.LIGHT_GRAY);
		topPane.setBorder(BorderFactory.createLineBorder(Color.BLACK,borderWindowThickness));
		setContentPane(topPane);
		topPane.setLayout(null);
		
		JPanel ContentPanel = new JPanel();
		ContentPanel.setBounds(1, 50, xWindow-2*borderWindowThickness, yWindow - yContentPanel);
		topPane.add(ContentPanel);
		ContentPanel.setLayout(null);
		
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
		
		JButton EPVOKLoveSong = new JButton ("EP: VOK Love Song 2016");
		EPVOKLoveSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		EPVOKLoveSong.setBounds(xAlbumButton, yVOKEPLoveSongButton, AlbumButtonWidth, AlbumButtonHeight);
		EPVOKLoveSong.setFont(new Font("Serif", Font.PLAIN, 20));
		EPVOKLoveSong.setFocusable(false);
		ContentPanel.add(EPVOKLoveSong);
		
		JButton beMyLoverSongButton = new JButton ("BE MY LOVER - WANSENTAI x HARMONIE");
		beMyLoverSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		beMyLoverSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, AlbumButtonWidth, AlbumButtonHeight);
		beMyLoverSongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		beMyLoverSongButton.setFocusable(false);
		ContentPanel.add(beMyLoverSongButton);
		beMyLoverSongButton.addActionListener(beMyLoverHandler);
		
		JButton boNhauPhiaSauSongButton = new JButton("BO NHAU PHIA SAU - VOK");
		boNhauPhiaSauSongButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		boNhauPhiaSauSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, AlbumButtonWidth, AlbumButtonHeight);
		boNhauPhiaSauSongButton.setFont(new Font("Serif", Font.PLAIN,20));
		boNhauPhiaSauSongButton.setFocusable(false);
		ContentPanel.add(boNhauPhiaSauSongButton);
		boNhauPhiaSauSongButton.addActionListener(boNhauPhiaSauHandler);
		
		JButton loveYouNeedYouSongButton = new JButton("LOVE YOU NEED YOU - WANSENTAI FT. JAYDEN");
		loveYouNeedYouSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		loveYouNeedYouSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, AlbumButtonWidth, AlbumButtonHeight);
		loveYouNeedYouSongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		loveYouNeedYouSongButton.setFocusable(false);
		ContentPanel.add(loveYouNeedYouSongButton);
		loveYouNeedYouSongButton.addActionListener(loveYouNeedYouHandler);
		
		JButton luVYouCusSongButton = new JButton("LUVYOU - CUSTHEKID");
		luVYouCusSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		luVYouCusSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, AlbumButtonWidth, AlbumButtonHeight);
		luVYouCusSongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		luVYouCusSongButton.setFocusable(false);
		ContentPanel.add(luVYouCusSongButton);
		luVYouCusSongButton.addActionListener(luVYouCusHandler);
		
		JButton goToAlbumHomeButton = new JButton("");
		goToAlbumHomeButton.setIcon(new ImageIcon(this.getClass().getResource("/backButton40x40.png")));
		goToAlbumHomeButton.setFocusable(false);
		//Color colorBackground = new Color();
		goToAlbumHomeButton.setBackground(new Color(238, 238, 238));
		goToAlbumHomeButton.setBorder(null);
		goToAlbumHomeButton.setBounds(5000,619,42,40);
		ContentPanel.add(goToAlbumHomeButton);
		
		//Go to Welcome Page Button
				JButton goToHomeButton = new JButton("");
				goToHomeButton.setIcon(new ImageIcon(this.getClass().getResource("/homeButton40x40.png")));
				goToHomeButton.setFocusable(false);
				goToHomeButton.setBackground(new Color(238,238,238));
				goToHomeButton.setBorder(null);
				goToHomeButton.setBounds(619,619,42,40);
				ContentPanel.add(goToHomeButton);
		
		EPVOKLoveSong.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				xSongButton = xSongStandardButton;
				musicSong.stop();
				EPVOKLoveSong.setBounds(xAlbumButtonOutBound,yVOKEPLoveSongButton,AlbumButtonWidth, AlbumButtonHeight);
				boNhauPhiaSauSongButton.setBounds(xSongButton, yBoNhauPhiaSauChillButton, AlbumButtonWidth, AlbumButtonHeight);
				beMyLoverSongButton.setBounds(xSongButton, ybeMyLoverButton, AlbumButtonWidth, AlbumButtonHeight);
				loveYouNeedYouSongButton.setBounds(xSongButton, yLoveYouNeedYouButton, AlbumButtonWidth, AlbumButtonHeight);
				luVYouCusSongButton.setBounds(xSongButton, yluVYouButton, AlbumButtonWidth, AlbumButtonHeight);
				
				
				goToAlbumHomeButton.setBounds(619,619,42,40);
				goToHomeButton.setBounds(5000,619,42,40);
				
			}
	});
		goToAlbumHomeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				xSongButton = xSongButtonOutBound;
				goToAlbumHomeButton.setBounds(5000,619,42,40);
				goToHomeButton.setBounds(619,619,42,40);
				EPVOKLoveSong.setBounds(xAlbumButton, yVOKEPLoveSongButton, AlbumButtonWidth, AlbumButtonHeight);
				boNhauPhiaSauSongButton.setBounds(xSongButton, yBoNhauPhiaSauChillButton, AlbumButtonWidth, AlbumButtonHeight);
				beMyLoverSongButton.setBounds(xSongButton, ybeMyLoverButton, AlbumButtonWidth, AlbumButtonHeight);
				loveYouNeedYouSongButton.setBounds(xSongButton, yLoveYouNeedYouButton, AlbumButtonWidth, AlbumButtonHeight);
				luVYouCusSongButton.setBounds(xSongButton, yluVYouButton, AlbumButtonWidth, AlbumButtonHeight);
			}
		});
		
		
		checKWanCusChill = "MusicWav/CHECK - WANSENTAI x CUSTHEKID x CHILLINGO (Prod. fewtile).wav";
		
		boNhauPhiaSau = "MusicWav/BO NHAU PHIA SAU - VOK.wav";
		beMylover = "MusicWav/BE MY LOVER - WANSENTAI x HARMONIE.wav";
		loveYouNeedYou = "MusicWav/LOVE YOU NEED YOU  JAYDEN FT WANSENTAI.wav";
		luVYouCus = "MusicWav/LUVYOU - Cus.wav";
		
		goToHomeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Welcome home = new Welcome();
				home.setVisible(true);
				musicSong.stop();
				dispose();
			}
		
	});
		
		musicSong.setFile(checKWanCusChill);

}
public class musicSong{
	Clip clip ; 
	
	public void setFile(String soundFileName)
	{
		try {
			File file = new File(soundFileName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(sound);
		}
		catch(Exception e)
		{
			
		}
	}
	public void play() {
		clip.setFramePosition(0);
		clip.start();
	}
	public void stop() {
		clip.stop();
	}
}
public class checKWanCusChillButtonHandler implements ActionListener{

	//@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		musicSong.stop();
		musicSong = currentSong;
		currentSong.setFile(checKWanCusChill);
		currentSong.play();
		
	}
	
}
public class beMyLoverButtonHandler implements ActionListener{

	//@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub;
		
		musicSong.stop();
		musicSong = currentSong;
		currentSong.setFile(beMylover);
		currentSong.play();
		
	}
	
}
public class boNhauPhiaSauButtonHandler implements ActionListener{
	
	//@Override
	public void actionPerformed(ActionEvent event) {
		//TODO Auto-generated method stub
		
		musicSong.stop();
		musicSong = currentSong;
		currentSong.setFile(boNhauPhiaSau);
		currentSong.play();
	}
}
public class loveYouNeedYouButtonHandler implements ActionListener{
	
	//@Override
	public void actionPerformed(ActionEvent event) {
		//TODO Auto-generated method stub
		
		musicSong.stop();
		musicSong = currentSong;
		currentSong.setFile(loveYouNeedYou);
		currentSong.play();
	}
}
public class luVYouCusButtonHandler implements ActionListener{
	
	//@Override
	public void actionPerformed(ActionEvent event) {
		//TODO Auto-generated method stub
		
		musicSong.stop();
		musicSong = currentSong;
		currentSong.setFile(luVYouCus);
		currentSong.play();
	}
}

}