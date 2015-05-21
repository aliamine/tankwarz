import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.util.*;

public class Tank {
	private double px = Map.getMapx()[10];
	private double py = Map.getMapy()[10];;
	private boolean m;
	private boolean h;
	private double rot = 0;
	int ind = Tank.getIndex(Map.getMapx(), px);

	public Tank(double px, double py, boolean m) {
		this.px = px;
		this.py = py;
		this.m = m;
	}

	public static int getIndex(double[] list, double value) {
		for (int i = 0; i < list.length; i++) {
			if (value == list[i]) {
				return i;
			}

		}
		return -1;
	}

	public void rotation(Tank tank, boolean h) {
		if (h == true && rot<85) {
			rot++;
		} else if (h == false && rot>-30) {
			rot--;
		}
	}

	public void move(Tank tank, boolean b) {

		if (b == true) {
			ind = ind + 1;
			px = Map.getMapx()[ind];
			py = Map.getMapy()[ind] + 35;
			m = true;

		} else if (b == false) {
			if (ind - 1 > 0){
				ind = ind - 1;
				px = Map.getMapx()[ind];
				py = Map.getMapy()[ind] + 35;
				m = false;
			}
		}
	}

	public void afficher(Tank tank) {
		if (m == true) {
			StdDraw.picture(px, py, "files/pictures/tankvert1.png");
			StdDraw.picture(px + 20, py + 30,
					"C:files/pictures/canon123.png", 100, 50, rot);
		} else if (m == false) {
			StdDraw.picture(px, py, "files/pictures/tankvertdt.png");
			StdDraw.picture(px - 20, py + 30,
					"files/pictures/canon123d.png", 100, 50, rot);
		}

	}

}
