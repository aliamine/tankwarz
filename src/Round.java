import java.awt.Font;


public class Round {
	
	public static int compteur = 0;
	public static int temps = 10;
	public static int compte = 0;
	public static int healthTank0 = 50;
	public static int healthTank1 = 50;
	

	public Round() {

	}
	public static void changePlayer(){
		try {
		    Thread.sleep(100);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		 
		}
		
		if (Main.tankPlayer == Main.tankListe[1]) {
			Main.tankPlayer = Main.tankListe[0];
			Tank.oil = 110;
			temps = 10;

		} else {
			Main.tankPlayer = Main.tankListe[1];
			Tank.oil = 110;
			temps = 10;

		}
	}

	public static void chrono(Tank[] tankListe) {
		compteur++;
		StdDraw.picture(320, 560, "files/pictures/chrono.png");
		StdDraw.setPenColor(26, 214, 16);
		StdDraw.filledRectangle(450, 560, 11*temps, 5);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(450, 558, Integer.toString(temps));
		if (compteur >= 60) {
			temps--;
			compteur = 0;

		}
		if (temps < 0) {

			changePlayer();

		}
	}


	public static void distance(Tank[] tankListe) {
		StdDraw.picture(320, 520, "files/pictures/oil.png");
		StdDraw.setPenColor(250, 0, 0);
		StdDraw.filledRectangle(450, 520, Tank.oil, 5);
		if (Tank.oil < 1) {
			changePlayer();

		}
	}
	
	public static void gameScore(){
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.picture(75, 550, "files/pictures/mecano.png");
		StdDraw.picture(825, 550, "files/pictures/mecano.png");
		StdDraw.filledRectangle(75, 520, healthTank0, 10);
		StdDraw.filledRectangle(825, 520, healthTank1, 10);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(75, 520, Integer.toString(2*healthTank0 )+"%");
		StdDraw.text(825, 520, Integer.toString(2*healthTank1 )+"%");
		if(healthTank0 <1){
			StdDraw.picture(450, 200, "files/pictures/fondend.png",900,800);
			StdDraw.setFont(new Font("Arial", Font.BOLD,20));
			StdDraw.text(450, 340, "player 2 a gagné !");
			Main.game=false;
			Main.menudisplay = true;
		}
		if(healthTank1 <1){
			StdDraw.picture(450, 200, "files/pictures/fondend.png",900,800);
			StdDraw.setFont(new Font("Arial", Font.BOLD,20));
			StdDraw.text(450, 340, "player 1 a gagné !");
			Main.game=false;
			Main.menudisplay = true;
		}
	}
	
	

}
