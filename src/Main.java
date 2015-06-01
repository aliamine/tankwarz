import java.awt.event.KeyEvent;

public class Main {
	public static Tank tankVert;
	public static Bullet fireball;
	public static Bullet fireballG;

	public static void main(String[] args) {

		StdDraw.setCanvasSize(900, 600);
		StdDraw.setXscale(0, 900);
		StdDraw.setYscale(0, 600);
		boolean tir = false;
		Map poly = new Map();
		Tank[] tankListe = new Tank[2];

		// Création d'une liste de Tank pour pouvoir en générer plusieurs
		for (int i = 0; i < 2; i++) {
			tankListe[i] = new Tank(Map.getMapx()[100 + 100 * i],
					Map.getMapy()[100 + 100 * i], true);
		}
		tankVert = tankListe[0];

		while (true) {
			
			StdDraw.clear(StdDraw.WHITE);
			poly.polyG(poly);
			tankVert.afficher(tankVert);

			if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
				tankVert.move(tankVert, true);
			}

			if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
				tankVert.move(tankVert, false);
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
				tankVert.rotation(tankVert, true);
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
				tankVert.rotation(tankVert, false);
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
				if(tankVert.getDirection()){
					fireball = new Bullet(tankVert.getRotD(),tankVert.getPosx() + 10, tankVert.getPosy() + 25, 20,17);
				}
				else if (tankVert.getDirection()==false){
					fireball = new Bullet(tankVert.getRotG(),tankVert.getPosx() - 7, tankVert.getPosy() + 25, 20,17);
				}
				tir = true;
			}

			if (tir) {

				fireball.fire();

			}

			StdDraw.show(5);
		}

	}

}
