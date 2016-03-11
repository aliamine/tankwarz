
public class Tank {
	public double px ;
	public double py ;
	private boolean direction;
	public double rotD = 0;
	public double rotG = 180;
	public static int oil = 110;
	


	public Tank(double px, double py, boolean direction) {
		this.px = px;
		this.py = py;
		this.direction = direction;
	}

	public static int getIndex(double[] list, int value) {
		for (int i = 0; i < list.length; i++) {
			if (value == list[i]) {
				return i;
			}

		}
		return -1;
	}

	public void afficher() {
		if (direction == true) {
			StdDraw.picture(px, py + 15, "files/pictures/TankDeOuf.png");
			StdDraw.picture(px, py + 23, "C:files/pictures/canonunique.png",100, 50, rotD);
		} else if (direction == false) {
			StdDraw.picture(px, py + 15, "files/pictures/TankDeOufG.png");
			StdDraw.picture(px, py + 23, "files/pictures/canonunique.png", 100,50, rotG);
		}

	}

	public void move(boolean directSens) {
		
		int ind = getIndex(Map.getMapx(), (int) px);
		if (directSens) {
			if (ind + 1 < 899)
				ind = ind + 1;
			px = Map.getMapx()[ind];
			py = Map.getMapy()[ind];
			direction = true;
			oil--;

		} else if (directSens == false) {
			if (ind - 1 > 5) {
				ind = ind - 1;
				px = Map.getMapx()[ind];
				py = Map.getMapy()[ind];
				direction = false;
				oil--;
			}
		}
	}

	public void rotation(boolean press) {
		if (press == true) {
			if (direction == true && rotD < 89) {
				rotD++;
			} else if (direction == false && rotG > 91) {
				rotD++;
				rotG = 180 - rotD;
			}
		}
		else if(press == false) {
			if (direction == true && rotD > -20) {
				rotD--;
			} else if (direction == false && rotG < 210) {
				rotD--;
				rotG = 180 - rotD;
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

	public boolean getDirection() {
		return direction;
	}
}
