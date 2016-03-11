
public abstract class Missile {
	
	double bulletX;
	double bulletY;
	double speedBulletX;
	double speedBulletY;
	double time = 0;
	double initRadius;
	final double grav = 9.8;
	public boolean changeJoueur = false;
	boolean chute = false;
	double bulletYpre = 0;
	
	public Missile(double initRadius, double initPosXTank, double initPosYTank, double speedBulletX, double speedBulletY){
		this.initRadius = initRadius;
		this.bulletX = initPosXTank;
		this.bulletY = initPosYTank;
		this.speedBulletX = speedBulletX;
		this.speedBulletY = speedBulletY;

	}

}
