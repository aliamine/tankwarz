import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;

public class Main {
	
	public static void main(String[] args) {
		StdDraw.setCanvasSize(900, 600);
		StdDraw.setXscale(0, 600);
		StdDraw.setYscale(0, 600);
		Map poly = new Map();
		Tank tankVert = new Tank(Map.getMapx()[10], Map.getMapy()[10], true);
		
		//Code de Salah
		Tank tankVert2 = new Tank(Map.getMapx()[50], Map.getMapy()[20], true);
		
		// TODO Auto-generated method stub
		while (true) {
			//poly.bezier(100);
			StdDraw.clear(StdDraw.WHITE);
			poly.polyG(poly);
			//poly.display();
			tankVert.afficher(tankVert);
			
			tankVert2.afficher(tankVert2);
			// tankVert.afficher(tankVert);
			if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
				tankVert.move(tankVert, true);
			}

			if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
				tankVert.move(tankVert, false);
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
				tankVert.rotation(tankVert,true);
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
				tankVert.rotation(tankVert,false);
			}

			StdDraw.show(3);
		}

	}

}
