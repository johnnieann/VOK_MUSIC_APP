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


public class Artist extends JFrame {
	private JPanel topPane;
	int xWindow = 1280, yWindow = 720; 
	int borderWindowThickness = 1;
	
	int xContentPanel = borderWindowThickness;
	int yContentPanel = 50;
	
	int mouseXPos, mouseYPos;
	
	int ArtistButtonWidth = 650; 
	int ArtistButtonHeight = 50; 
	int xArtistButtonStandard = (xWindow/2) - (ArtistButtonWidth/2);
	int xArtistButton = (xWindow/2) - (ArtistButtonWidth/2);
	int xArtistButtonOutBound = 5000;
	
	int SongButtonWidth = 650; 
	int SongButtonHeight = 50; 
	int xSongButtonOutBound = 5000; 
	int ySongButtonOutBound = 5000;
	int xSongButton = (xWindow/2) - (ArtistButtonWidth/2);
	int xSongStandardButton = (xWindow/2) - (ArtistButtonWidth/2);
	
	int yChillingoButton = 50;
	int yBoNhauPhiaSauChillButton = 50; 
	int yCheckChillButton = 150; 
	int yNaughtyBoysChillButton = 250; 
	int yNiceTryChillButton = 350;
	
	int yCusthekidButton = 150;
	int yluVYouCusSongButton = 250;
	int yMhereCusSongButton = 350;
	
	int yDWalkerButton = 250;
	int yPureDWalkerButton = 50;
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

	
public Artist() {
		
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
		
		// BE MY LOVER Song Button
		
		JButton beMyLoverSongButton = new JButton ("BE MY LOVER - WANSENTAI x HARMONIE");
		beMyLoverSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		beMyLoverSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, SongButtonWidth, SongButtonHeight);
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
		boNhauPhiaSauSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, SongButtonWidth, SongButtonHeight);
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
		checkSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, SongButtonWidth, SongButtonHeight);
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
		loveYouNeedYouSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, SongButtonWidth, SongButtonHeight);
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
		luVYouCusSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, SongButtonWidth, SongButtonHeight);
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
		marioLouiesSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, SongButtonWidth, SongButtonHeight);
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
		mhereCusSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, SongButtonWidth, SongButtonHeight);
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
		niceTrySongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, SongButtonWidth, SongButtonHeight);
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
		naughtyBoysSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, SongButtonWidth, SongButtonHeight);
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
		pickYouUpSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, SongButtonWidth, SongButtonHeight);
		pickYouUpSongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		pickYouUpSongButton.setFocusable(false);
		ContentPanel.add(pickYouUpSongButton);
		pickYouUpSongButton.addActionListener(pickYouUpHandler);
		
		JButton pureSongButton = new JButton ("PURE - WILDDE FT. DWALKER (PROD. ROKOTENSEI)");
		pureSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		pureSongButton.setBounds(xSongButtonOutBound, ySongButtonOutBound, SongButtonWidth, SongButtonHeight);
		pureSongButton.setFont(new Font("Serif", Font.PLAIN, 20));
		pureSongButton.setFocusable(false);
		ContentPanel.add(pureSongButton);
		pureSongButton.addActionListener(pureHandler);

		//add Go to Home Button
		JButton goToArtistHomeButton = new JButton("");
		goToArtistHomeButton.setIcon(new ImageIcon(this.getClass().getResource("/backButton40x40.png")));
		goToArtistHomeButton.setFocusable(false);
		//Color colorBackground = new Color();
		goToArtistHomeButton.setBackground(new Color(238, 238, 238));
		goToArtistHomeButton.setBorder(null);
		goToArtistHomeButton.setBounds(5000,619,42,40);
		ContentPanel.add(goToArtistHomeButton);
		
		//Go to Welcome Page Button
		JButton goToHomeButton = new JButton("");
		goToHomeButton.setIcon(new ImageIcon(this.getClass().getResource("/homeButton40x40.png")));
		goToHomeButton.setFocusable(false);
		goToHomeButton.setBackground(new Color(238,238,238));
		goToHomeButton.setBorder(null);
		goToHomeButton.setBounds(619,619,42,40);
		ContentPanel.add(goToHomeButton);
		
				
		JButton chillingoButton = new JButton ("Chillingo's Song");
		chillingoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		chillingoButton.setBounds(xArtistButton, yChillingoButton, ArtistButtonWidth, ArtistButtonHeight);
		chillingoButton.setFont(new Font("Serif", Font.PLAIN, 20));
		chillingoButton.setFocusable(false);
		ContentPanel.add(chillingoButton);
		
		JButton custhekidButton= new JButton("Custhekid's Song");
		custhekidButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		custhekidButton.setBounds(xArtistButton, yCusthekidButton, ArtistButtonWidth, ArtistButtonHeight);
		custhekidButton.setFont(new Font("Serif", Font.PLAIN,20));
		custhekidButton.setFocusable(false);
		ContentPanel.add(custhekidButton);
		
		JButton dwalkerButton = new JButton("DWalker's Song");
		dwalkerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		dwalkerButton.setBounds(xArtistButton,yDWalkerButton,ArtistButtonWidth,ArtistButtonHeight);
		dwalkerButton.setFont(new Font("Serif", Font.PLAIN,20));
		dwalkerButton.setFocusable(false);
		ContentPanel.add(dwalkerButton);
				
		chillingoButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				xSongButton = xSongStandardButton;
				yNiceTryChillButton = 350;
				musicSong.stop();
				chillingoButton.setBounds(xArtistButtonOutBound,yChillingoButton,ArtistButtonWidth, ArtistButtonHeight);
				boNhauPhiaSauSongButton.setBounds(xSongButton, yBoNhauPhiaSauChillButton, SongButtonWidth, SongButtonHeight);
				checkSongButton.setBounds(xSongButton, yCheckChillButton, SongButtonWidth, SongButtonHeight);
				naughtyBoysSongButton.setBounds(xSongButton, yNaughtyBoysChillButton, SongButtonWidth, SongButtonHeight);
				niceTrySongButton.setBounds(xSongButton, yNiceTryChillButton, SongButtonWidth, SongButtonHeight);
				goToArtistHomeButton.setBounds(619,619,42,40);
				custhekidButton.setBounds(xArtistButtonOutBound,619,42,40);
				dwalkerButton.setBounds(xArtistButtonOutBound,619,42,40);
				goToHomeButton.setBounds(xArtistButtonOutBound,619,42,40);
				
			}
	});
		
		custhekidButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
			xSongButton = xSongStandardButton;
			yNiceTryChillButton = 450;
			musicSong.stop();
			boNhauPhiaSauSongButton.setBounds(xSongButton, yBoNhauPhiaSauChillButton, SongButtonWidth, SongButtonHeight);
			checkSongButton.setBounds(xSongButton, yCheckChillButton, SongButtonWidth, SongButtonHeight);
			luVYouCusSongButton.setBounds(xSongButton,yluVYouCusSongButton,ArtistButtonWidth,ArtistButtonHeight);
			mhereCusSongButton.setBounds(xSongButton,yMhereCusSongButton,ArtistButtonWidth,ArtistButtonHeight);
			niceTrySongButton.setBounds(xSongButton, yNiceTryChillButton, SongButtonWidth, SongButtonHeight);
			goToArtistHomeButton.setBounds(619,619,42,40);
			custhekidButton.setBounds(xArtistButtonOutBound,619,42,40);
			chillingoButton.setBounds(xArtistButtonOutBound,619,42,40);
			dwalkerButton.setBounds(xArtistButtonOutBound,619,42,40);
			goToHomeButton.setBounds(xArtistButtonOutBound,619,42,40);
			
			}
		});
		
		dwalkerButton.addMouseListener(new MouseAdapter()
				{
			public void mouseClicked(MouseEvent arg0) {
				xSongButton = xSongStandardButton;
				musicSong.stop();
				pureSongButton.setBounds(xSongButton,yPureDWalkerButton, SongButtonWidth, SongButtonHeight);
				goToArtistHomeButton.setBounds(619,619,42,40);
				custhekidButton.setBounds(xArtistButtonOutBound,619,42,40);
				chillingoButton.setBounds(xArtistButtonOutBound,619,42,40);
				dwalkerButton.setBounds(xArtistButtonOutBound,619,42,40);
				goToHomeButton.setBounds(xArtistButtonOutBound,619,42,40);
			}
				});
		
		goToArtistHomeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				xSongButton = xSongButtonOutBound;
				goToArtistHomeButton.setBounds(5000,5000,42,40);
				boNhauPhiaSauSongButton.setBounds(xSongButton, yBoNhauPhiaSauChillButton, SongButtonWidth, SongButtonHeight);
				checkSongButton.setBounds(xSongButton, yCheckChillButton, SongButtonWidth, SongButtonHeight);
				naughtyBoysSongButton.setBounds(xSongButton, yNaughtyBoysChillButton, SongButtonWidth, SongButtonHeight);
				niceTrySongButton.setBounds(xSongButton, yNiceTryChillButton, SongButtonWidth, SongButtonHeight);			
				luVYouCusSongButton.setBounds(xSongButton,yluVYouCusSongButton,ArtistButtonWidth,ArtistButtonHeight);
				mhereCusSongButton.setBounds(xSongButton,yMhereCusSongButton,ArtistButtonWidth,ArtistButtonHeight);
				pureSongButton.setBounds(xSongButton,yMhereCusSongButton,ArtistButtonWidth,ArtistButtonHeight);
				goToHomeButton.setBounds(619,619,42,40);
				chillingoButton.setBounds(xArtistButton,yChillingoButton, ArtistButtonWidth, ArtistButtonHeight);
				custhekidButton.setBounds(xArtistButton,yCusthekidButton,ArtistButtonWidth, ArtistButtonHeight);
				dwalkerButton.setBounds(xArtistButton,yDWalkerButton,ArtistButtonWidth, ArtistButtonHeight);
				
			}
		});

		
		
		//song file
		boNhauPhiaSau = "MusicWav/BO NHAU PHIA SAU - VOK.wav";
		beMylover = "MusicWav/BE MY LOVER - WANSENTAI x HARMONIE.wav";
		checKWanCusChill = "MusicWav/CHECK - WANSENTAI x CUSTHEKID x CHILLINGO (Prod. fewtile).wav";
		loveYouNeedYou = "MusicWav/LOVE YOU NEED YOU  JAYDEN FT WANSENTAI.wav";
		luVYouCus = "MusicWav/LUVYOU - Cus.wav";
		marioLouies = "MusicWav/MARIO  LOUIES ft YANG E prod Fantom XXX.wav";
		mhereCus = "MusicWav/MHERE  CUSTHEKID ft HURRYKNG.wav";
		naughtyBoys = "MusicWav/NAUGHTY BOYS  CHILLINGO x GAVIN G x WANSENTAI PROD TÚ  OFFICIAL LYRIC VIDEO.wav";
		niceTry = "MusicWav/NICE TRY  JAYDEN x CHILLINGO x CUSTHEKID x WANSENTAI PROD TÚ  OFFICIAL VERTICAL MUSIC VIDEO.wav";
		pickYouUp = "MusicWav/PICK YOU UP  JAYDEN x WANSENTAI x GEN.wav";
		pureWildeDwalker = "MusicWav/PURE  WILDDE FT DWALKER PROD ROKO TENSEI.wav";
		
	
		goToHomeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Welcome home = new Welcome();
				home.setVisible(true);
				musicSong.stop();
				dispose();
			}
		
	});
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