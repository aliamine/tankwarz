
public class Bullet {
	
	double initPosXTank;
	double initPosYTank;
	double speedBulletX;
	double speedBulletY;
	double time=0;
	double initRadius;
	final double grav = 9.8;
	
	
	
	public Bullet(double initRadius, double initPosXTank, double initPosYTank,int speedBulletX,int speedBulletY){
		this.initRadius = initRadius;
		this.initPosXTank= initPosXTank;
		this.initPosYTank= initPosYTank;
		this.speedBulletX= speedBulletX;
		this.speedBulletY=speedBulletY;
		
	}
	
	public void fire(){
		time = time + 0.1;
		initPosXTank = initPosXTank + speedBulletX * Math.cos(Math.toRadians(initRadius));
		initPosYTank = -0.5*grav*time + initPosYTank + speedBulletY * Math.sin(Math.toRadians(initRadius));
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(initPosXTank,initPosYTank,7);
	}
}
