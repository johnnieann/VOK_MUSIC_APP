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


public class Song extends JFrame {
	private JPanel topPane;
	int xWindow = 1280, yWindow = 720; 
	int borderWindowThickness = 1;
	
	int xContentPanel = borderWindowThickness;
	int yContentPanel = 50;
	
	int mouseXPos, mouseYPos;
	int SongButtonWidth = 650; 
	int SongButtonHeight = 50; 
	int xSongButtonStandard = (xWindow/2) - (SongButtonWidth/2);
	int xSong1Button = (xWindow/2) - (SongButtonWidth/2);
	int xSong1ButtonOutBound = 5000;
	int xSong2Button = (xWindow/2) - (SongButtonWidth/2);
	int xSong2ButtonOutBound = 5000; 
	
	//initial beMyLoverSongButton variables
	int yBeMyLoverButton = 50;
	
	//initial boNhauPhiaSauSongButton variables
	int yBoNhauPhiaSauButton = 150;
	
	//initial checkSongButton variables
	int yCheckButton = 250;
	
	//initial loveYouNeedYouSongButton variables
	int yLoveYouNeedYouButton = 350;
	
	//initial luVYouCusSongButton variables 
	int yluVYouCusSongButton = 450;
	
	//initial marioLouiesSongButton variables
	int ymarioLouiesSongButton = 550; 
	
	
	//initial mhere variables
	int ymhereCusButton = 50; 
	//initial naughtyBoys variables
	int ynaughtyBoysButton = 150;
		
	//initial Nicetry variables
	int yniceTryButton = 250;
					
	//initial pickYouUp variables
	int ypickYouUpButton = 350;
	
	//initial pure Variables
	int ypureButton = 450;
	

	

	
	String boNhauPhiaSau;
	boNhauPhiaSauButtonHandler boNhauPhiaSauHandler = new boNhauPhiaSauButtonHandler();
	String beMylover;
	beMyLoverButtonHandler beMyLoverHandler = new beMyLoverButtonHandler();
	String checKWanCusChill;
	checKWanCusChillButtonHandler checkHandler = new checKWanCusChillButtonHandler();
	String loveYouNeedYou; 
	loveYouNeedYouButtonHandler loveYouNeedYouHandler = new loveYouNeedYouButtonHandler();
	String luVYouCus;
	luVYouCusButtonHandler luVYouCusHandler = new luVYouCusButtonHandler();
	String marioLouies;
	marioLouiesButtonHandler marioLouiesHandler = new marioLouiesButtonHandler();
	
	String mhereCus; 
	mhereCusButtonHandler mhereCusHandler = new mhereCusButtonHandler();
	String naughtyBoys;
	naughtyBoysButtonHandler naughtyBoysHandler = new naughtyBoysButtonHandler();
	String niceTry;
	niceTryButtonHandler niceTryHandler = new niceTryButtonHandler();
	String pickYouUp;
	pickYouUpButtonHandler pickYouUpHandler = new pickYouUpButtonHandler();	
	String pureWildeDwalker; 
	pureButtonHandler pureHandler = new pureButtonHandler();
	
	musicSong musicSong = new musicSong();
	musicSong currentSong = new musicSong();
	

	
	
	public Song() {
		
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
		
		//add next Button 
		JButton goToPage2Button = new JButton("");
		goToPage2Button.setIcon(new ImageIcon(this.getClass().getResource("/nextButton40x20.png")));
		goToPage2Button.setBackground(new Color(238, 238, 238));
		goToPage2Button.setBorder(null);
		goToPage2Button.setFocusable(false);
		goToPage2Button.setBounds(1236, 619, 42, 40);
		ContentPanel.add(goToPage2Button);
		
		//add previous button
		JButton goToPage1Button = new JButton("");
		goToPage1Button.setIcon(new ImageIcon(this.getClass().getResource("/backButton40x40.png")));
		goToPage1Button.setBackground(new Color(238, 238, 238));
		goToPage1Button.setBorder(null);
		goToPage1Button.setFocusable(false);
		goToPage1Button.setBounds(5000,619,42,40);
		ContentPanel.add(goToPage1Button);
		
		//add Go to Home Button
		JButton goToHomeButton = new JButton("");
		
		goToHomeButton.setBounds(619,619,42,40);
		goToHomeButton.setIcon(new ImageIcon(this.getClass().getResource("/homeButton40x40.png")));
		goToHomeButton.setFocusable(false);
		goToHomeButton.setBackground(new Color(238,238,238));
		goToHomeButton.setBorder(null);
		ContentPanel.add(goToHomeButton);
		
		
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
		
		
		// BE MY LOVER Song Button
		
		JButton beMyLoverSongButton = new JButton ("BE MY LOVER - WANSENTAI x HARMONIE");
		beMyLoverSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		beMyLoverSongButton.setBounds(xSong1Button, yBeMyLoverButton, SongButtonWidth, SongButtonHeight);
		beMyLoverSongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		beMyLoverSongButton.setFocusable(false);
		ContentPanel.add(beMyLoverSongButton);
		beMyLoverSongButton.addActionListener(beMyLoverHandler);
		
		

		//Bo Nhau Phia Sau Song Button
		
		JButton boNhauPhiaSauSongButton = new JButton("BO NHAU PHIA SAU - VOK");
		boNhauPhiaSauSongButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		boNhauPhiaSauSongButton.setBounds(xSong1Button, yBoNhauPhiaSauButton, SongButtonWidth, SongButtonHeight);
		boNhauPhiaSauSongButton.setFont(new Font("Serif", Font.PLAIN,20));
		boNhauPhiaSauSongButton.setFocusable(false);
		ContentPanel.add(boNhauPhiaSauSongButton);
		boNhauPhiaSauSongButton.addActionListener(boNhauPhiaSauHandler);
		//Check Song Button 
		JButton checkSongButton = new JButton("CHECK - WANSENTAI x CUSTHEKID x CHILLINGO (PROD. FEWTILE)");
		checkSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		checkSongButton.setBounds(xSong1Button, yCheckButton, SongButtonWidth, SongButtonHeight);
		checkSongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		checkSongButton.setFocusable(false);
		ContentPanel.add(checkSongButton);
		checkSongButton.addActionListener(checkHandler);
		
		//loveYouNeedYou Song Button
		JButton loveYouNeedYouSongButton = new JButton("LOVE YOU NEED YOU - WANSENTAI FT. JAYDEN");
		loveYouNeedYouSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		loveYouNeedYouSongButton.setBounds(xSong1Button, yLoveYouNeedYouButton, SongButtonWidth, SongButtonHeight);
		loveYouNeedYouSongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		loveYouNeedYouSongButton.setFocusable(false);
		ContentPanel.add(loveYouNeedYouSongButton);
		loveYouNeedYouSongButton.addActionListener(loveYouNeedYouHandler);
		
		//luVYou Song Button
		JButton luVYouCusSongButton = new JButton("LUVYOU - CUSTHEKID");
		luVYouCusSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		luVYouCusSongButton.setBounds(xSong1Button, yluVYouCusSongButton, SongButtonWidth, SongButtonHeight);
		luVYouCusSongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		luVYouCusSongButton.setFocusable(false);
		ContentPanel.add(luVYouCusSongButton);
		luVYouCusSongButton.addActionListener(luVYouCusHandler);
		
		//marioLouies Song Button
		JButton marioLouiesSongButton = new JButton("MARIO - LOUIES FT. YANG E");
		marioLouiesSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		marioLouiesSongButton.setBounds(xSong1Button, ymarioLouiesSongButton, SongButtonWidth, SongButtonHeight);
		marioLouiesSongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		marioLouiesSongButton.setFocusable(false);
		ContentPanel.add(marioLouiesSongButton);
		marioLouiesSongButton.addActionListener(marioLouiesHandler);
		
		
		
		//Song 2nd page 
		JButton mhereCusSongButton = new JButton ("MHERE - CUSTHEKID");
		mhereCusSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mhereCusSongButton.setBounds(xSong2ButtonOutBound, ymhereCusButton, SongButtonWidth, SongButtonHeight);
		mhereCusSongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		mhereCusSongButton.setFocusable(false);
		ContentPanel.add(mhereCusSongButton);
		mhereCusSongButton.addActionListener(mhereCusHandler);
		
		// Nice Try Song Button
		
		JButton niceTrySongButton = new JButton ("NICE TRY - CHILLINGO FT. WANSENTAI, CUSTHEKID, JAYDEN");
		niceTrySongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		niceTrySongButton.setBounds(xSong2ButtonOutBound, yniceTryButton, SongButtonWidth, SongButtonHeight);
		niceTrySongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		niceTrySongButton.setFocusable(false);
		ContentPanel.add(niceTrySongButton);
		niceTrySongButton.addActionListener(niceTryHandler);

		//Naughty Boys Song Button
		
		JButton naughtyBoysSongButton = new JButton("NAUGHTY BOYS - CHILLINGO FT. WANSENTAI, GAVIN G");
		naughtyBoysSongButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		naughtyBoysSongButton.setBounds(xSong2ButtonOutBound, ynaughtyBoysButton, SongButtonWidth, SongButtonHeight);
		naughtyBoysSongButton.setFont(new Font("Serif", Font.PLAIN,20));
		naughtyBoysSongButton.setFocusable(false);
		ContentPanel.add(naughtyBoysSongButton);
		naughtyBoysSongButton.addActionListener(naughtyBoysHandler);
		
		//Check Song Button 
		JButton pickYouUpSongButton = new JButton("PICK YOU UP - WANSENTAI FT. JAYDEN, GEN JI");
		pickYouUpSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		pickYouUpSongButton.setBounds(xSong2ButtonOutBound, ypickYouUpButton, SongButtonWidth, SongButtonHeight);
		pickYouUpSongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		pickYouUpSongButton.setFocusable(false);
		ContentPanel.add(pickYouUpSongButton);
		pickYouUpSongButton.addActionListener(pickYouUpHandler);
		
		JButton pureSongButton = new JButton ("PURE - WILDDE FT. DWALKER (PROD. ROKOTENSEI");
		pureSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		pureSongButton.setBounds(xSong2ButtonOutBound, ypureButton, SongButtonWidth, SongButtonHeight);
		pureSongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		pureSongButton.setFocusable(false);
		ContentPanel.add(pureSongButton);
		pureSongButton.addActionListener(pureHandler);
		
		//page2
		goToPage2Button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				xSong1Button = xSong1ButtonOutBound;
				beMyLoverSongButton.setBounds(xSong1Button, yBeMyLoverButton, SongButtonWidth, SongButtonHeight);
				boNhauPhiaSauSongButton.setBounds(xSong1Button, yBoNhauPhiaSauButton, SongButtonWidth, SongButtonHeight);
				checkSongButton.setBounds(xSong1Button, yCheckButton, SongButtonWidth, SongButtonHeight);
				loveYouNeedYouSongButton.setBounds(xSong1Button, yLoveYouNeedYouButton, SongButtonWidth, SongButtonHeight);
				luVYouCusSongButton.setBounds(xSong1Button, yluVYouCusSongButton, SongButtonWidth, SongButtonHeight);
				marioLouiesSongButton.setBounds(xSong1Button, ymarioLouiesSongButton, SongButtonWidth, SongButtonHeight);
				
				xSong2Button = xSongButtonStandard;
				mhereCusSongButton.setBounds(xSong2Button, ymhereCusButton, SongButtonWidth, SongButtonHeight);
				naughtyBoysSongButton.setBounds(xSong2Button, ynaughtyBoysButton, SongButtonWidth, SongButtonHeight);
				niceTrySongButton.setBounds(xSong2Button, yniceTryButton, SongButtonWidth, SongButtonHeight);
				pickYouUpSongButton.setBounds(xSong2Button, ypickYouUpButton, SongButtonWidth, SongButtonHeight);
				pureSongButton.setBounds(xSong2Button, ypureButton, SongButtonWidth, SongButtonHeight);
				
				goToPage1Button.setBounds(0,619,42,40);
				goToPage2Button.setBounds(5000,619,42,40);
			}
		});
		
		goToPage1Button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				xSong1Button = xSongButtonStandard;
				beMyLoverSongButton.setBounds(xSong1Button, yBeMyLoverButton, SongButtonWidth, SongButtonHeight);
				boNhauPhiaSauSongButton.setBounds(xSong1Button, yBoNhauPhiaSauButton, SongButtonWidth, SongButtonHeight);
				checkSongButton.setBounds(xSong1Button, yCheckButton, SongButtonWidth, SongButtonHeight);
				loveYouNeedYouSongButton.setBounds(xSong1Button, yLoveYouNeedYouButton, SongButtonWidth, SongButtonHeight);
				luVYouCusSongButton.setBounds(xSong1Button, yluVYouCusSongButton, SongButtonWidth, SongButtonHeight);
				marioLouiesSongButton.setBounds(xSong1Button, ymarioLouiesSongButton, SongButtonWidth, SongButtonHeight);
				
				xSong2Button = xSong2ButtonOutBound;
				mhereCusSongButton.setBounds(xSong2Button, ymhereCusButton, SongButtonWidth, SongButtonHeight);
				naughtyBoysSongButton.setBounds(xSong2Button, ynaughtyBoysButton, SongButtonWidth, SongButtonHeight);
				niceTrySongButton.setBounds(xSong2Button, yniceTryButton, SongButtonWidth, SongButtonHeight);
				pickYouUpSongButton.setBounds(xSong2Button, ypickYouUpButton, SongButtonWidth, SongButtonHeight);
				pureSongButton.setBounds(xSong2Button, ypureButton, SongButtonWidth, SongButtonHeight);
				
				goToPage1Button.setBounds(5000,619,42,40);
				goToPage2Button.setBounds(1236,619,42,40);
				
			}
		});
		
		goToHomeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Welcome home = new Welcome();
				home.setVisible(true);
				musicSong.stop();
				dispose();
			}
		
	});
		
		
		//song file
		//song 1st page
		boNhauPhiaSau = "MusicWav/BO NHAU PHIA SAU - VOK.wav";
		beMylover = "MusicWav/BE MY LOVER - WANSENTAI x HARMONIE.wav";
		checKWanCusChill = "MusicWav/CHECK - WANSENTAI x CUSTHEKID x CHILLINGO (Prod. fewtile).wav";
		loveYouNeedYou = "MusicWav/LOVE YOU NEED YOU  JAYDEN FT WANSENTAI.wav";
		luVYouCus = "MusicWav/LUVYOU - Cus.wav";
		marioLouies = "MusicWav/MARIO  LOUIES ft YANG E prod Fantom XXX.wav";
		//Song 2nd page 
		mhereCus = "MusicWav/MHERE  CUSTHEKID ft HURRYKNG.wav";
		naughtyBoys = "MusicWav/NAUGHTY BOYS  CHILLINGO x GAVIN G x WANSENTAI PROD TÚ  OFFICIAL LYRIC VIDEO.wav";
		niceTry = "MusicWav/NICE TRY  JAYDEN x CHILLINGO x CUSTHEKID x WANSENTAI PROD TÚ  OFFICIAL VERTICAL MUSIC VIDEO.wav";
		pickYouUp = "MusicWav/PICK YOU UP  JAYDEN x WANSENTAI x GEN.wav";
		pureWildeDwalker = "MusicWav/PURE  WILDDE FT DWALKER PROD ROKO TENSEI.wav";
		
	
		//set an initial musicSong to cause action stop(); 
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
	
	//Song 1st Page
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
	public class marioLouiesButtonHandler implements ActionListener{
		
		//@Override
		public void actionPerformed(ActionEvent event) {
			//TODO Auto-generated method stub
			
			musicSong.stop();
			musicSong = currentSong;
			currentSong.setFile(marioLouies);
			currentSong.play();
		}
	}
	//Song 2 
	public class mhereCusButtonHandler implements ActionListener{

		//@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			musicSong.stop();
			musicSong = currentSong;
			currentSong.setFile(mhereCus);
			currentSong.play();
			
		}
	}
	
	public class naughtyBoysButtonHandler implements ActionListener{

		//@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			musicSong.stop();
			musicSong = currentSong;
			currentSong.setFile(naughtyBoys);
			currentSong.play();
			
		}
	}
	
	public class niceTryButtonHandler implements ActionListener{

		//@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			musicSong.stop();
			musicSong = currentSong;
			currentSong.setFile(niceTry);
			currentSong.play();
			
		}
	}
	
	public class pickYouUpButtonHandler implements ActionListener{

		//@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			musicSong.stop();
			musicSong = currentSong;
			currentSong.setFile(pickYouUp);
			currentSong.play();
			
		}
	}
	
	public class pureButtonHandler implements ActionListener{

		//@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			musicSong.stop();
			musicSong = currentSong;
			currentSong.setFile(pureWildeDwalker);
			currentSong.play();
			
		}
	}
}

