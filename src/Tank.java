import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.util.*;

public class Tank {
	public double px ;
	public double py ;
	public static boolean direction;
	public static double rotD = 0;
	public static double rotG = 180;
	int ind = Tank.getIndex(Map.getMapx(), px);

	public Tank(double px, double py, boolean direction) {
		this.px = px;
		this.py = py;
		this.direction = direction;
	}

	public static int getIndex(double[] list, double value) {
		for (int i = 0; i < list.length; i++) {
			if (value == list[i]) {
				return i;
			}

		}
		return -1;
	}

	public void afficher(Tank tank) {
		if (direction == true) {
			StdDraw.picture(px, py + 15, "files/pictures/TankDeOuf.png");
			StdDraw.picture(px, py+23, "C:files/pictures/canonunique.png", 100, 50,
					rotD);
		} else if (direction == false) {
			StdDraw.picture(px, py + 15, "files/pictures/TankDeOufG.png");
			StdDraw.picture(px, py+23, "files/pictures/canonunique.png", 100, 50, rotG);
		}

	}

	public void move(Tank tank, boolean directSens) {

		if (directSens == true) {
			if (ind + 1 < 899)
				ind = ind + 1;
			px = Map.getMapx()[ind];
			py = Map.getMapy()[ind] + 1;
			direction = true;

		} else if (directSens == false) {
			if (ind - 1 > 0) {
				ind = ind - 1;
				px = Map.getMapx()[ind];
				py = Map.getMapy()[ind] + 1;
				direction = false;
			}
		}
	}

	public void rotation(Tank tank, boolean h) {
		if (h == true) {
			if (direction == true && rotD < 89) {
				rotD++;
			} else if (direction == false && rotG >91) {
				rotD++;
				rotG = 180-rotD;
			}
		}
		if (h == false) {
			if (direction == true && rotD > -20) {
				rotD--;
			} else if (direction == false && rotG < 210) {
				rotD--;
				rotG=180 - rotD;
			}

		}
	}

	public double getRotG() {
		return rotG;
	}
	public double getRotD() {
		return rotD;
	}
	public double getPosx() {
		return px;
	}
	public double getPosy() {
		return py;
	}
	public  boolean getDirection(){
		return direction;
	}
}
