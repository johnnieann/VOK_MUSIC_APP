package Client;

import Screen.*;

public class MainClient {
	public static void main(String [] args)
	{
		SplashScreen splashScreen = new SplashScreen();
		splashScreen.setVisible(true);
		try {
			for (int x=0; x<= 100; x++)
			{
				SplashScreen.progressBar.setValue(x);
				Thread.sleep(20);
				SplashScreen.lblNewLabel_1.setText(Integer.toString(x)+"%");
				if (x==100)
				{
					Welcome welcomeScreen = new Welcome();
					splashScreen.setVisible(false);
					welcomeScreen.setVisible(true);
					
				}
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
