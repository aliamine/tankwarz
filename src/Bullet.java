

public class Bullet extends Missile{

	

	public Bullet(double initRadius, double initPosXTank, double initPosYTank,
			int speedBulletX, int speedBulletY) {
		super(initRadius, initPosXTank, initPosYTank, speedBulletX, speedBulletY);

	}

	public void fire() {
		
		int indexBullet = Tank.getIndex(Map.getMapx(),(int)(bulletX)); //récupère les index i des x[i] que la bullet parcour au dessus de la map
		
		if (bulletX > 30 && bulletX < 878) {// pour que les balles ne dépassent pas le cadre
			
			
			// HIT BOX
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.circle(bulletX, bulletY, 6);
			if(Main.tankPlayer==Main.tankListe[0]){
				if(bulletX < Main.tankListe[1].getPosx() +36 && bulletX > Main.tankListe[1].getPosx() -36
				&& bulletY < Main.tankListe[1].getPosy() +26 && bulletY > Main.tankListe[1].getPosy() -26){
					Round.healthTank1 = Round.healthTank1 - 10;
					StdDraw.picture(bulletX,bulletY,"files/pictures/explosion.png");
					Round.changePlayer();
					Main.tir=0;
				}
			}
			if(Main.tankPlayer==Main.tankListe[1]){
				if(bulletX < Main.tankListe[0].getPosx() +36 && bulletX > Main.tankListe[0].getPosx() -36
				&& bulletY < Main.tankListe[0].getPosy() +26 && bulletY > Main.tankListe[0].getPosy() -26){
					Round.healthTank0 = Round.healthTank0 - 10;
					StdDraw.picture(bulletX,bulletY,"files/pictures/explosion.png");
					Round.changePlayer();
					Main.tir=0;
				}
			}
			// FIN HIT BOX
			
			if (bulletY <= Map.getMapy()[indexBullet]){			//Si la balle touche la map
				
				Main.tir = 0;	//on arrete la balle
				int trou = 0;
				for (int l = indexBullet - 25; l < indexBullet + 1; l++) {  //destruction du terrain à gauche de la zone d'impact
					if (trou < 25) {
						Map.getMapy()[l] = Map.getMapy()[l] - 0.8 * trou;
						trou++;
					}
				}

				int trou1 = 0;
				for (int l = indexBullet; l < indexBullet + 26; l++) {		//destruction du terrain à droite de la zone d'impact
					if (trou1 < 25) {
						Map.getMapy()[l] = Map.getMapy()[l] - 0.8
								* (25 - trou1);
						trou1++;
					}else{
						
					}

				}
				StdDraw.picture(bulletX,bulletY,"files/pictures/explosion.png");
				Round.changePlayer(); //changement de joueur
			
				
			}
			
			else{// Si les balles sont au dessus de la Map
				time = time + 0.1;
				bulletX = bulletX + speedBulletX 
						* Math.cos(Math.toRadians(initRadius));
				bulletY = -0.5 * grav * time + bulletY + speedBulletY
						* Math.sin(Math.toRadians(initRadius));
				StdDraw.setPenColor(33, 33, 33);
				StdDraw.filledCircle(bulletX, bulletY, 5);
					
				
			
			}
	
		} else {	// si la balle dépasse le cadre
			Main.tir = 0;
			Round.changePlayer();
		}
		
		
	
	
	}	
}
