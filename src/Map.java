
import java.awt.Color;

public class Map {
	public static double[] xMap;
	public static double[] yMap;
	double RADIUS = 15;

	public Map() {
		double[] x = new double[900];
		double[] y = new double[900];

		double randA = (Math.random()+0.1)*100;
		double randB = (Math.random()+0.1)*100;

		if(randA >=50){
			randA = randA- 40;
		}
		if(randB >=50){
			randB = randB- 40;
		}
		
		for (int i = 2; i <= x.length - 1; i++) {
			x[i] = i;
			y[i] = 200 +randA* Math.cos(0.01* i) + randB * Math.cos(0.02 * i) ;

		}
		// On fixe les extrémités du polygone qui sert de terrain
		y[0] = 1;
		y[1] = 250;
		y[899] = 0;
		this.xMap = x;
		this.yMap = y;

	}


	public void polyG(Map map) {
		// for (int i = 0; i < 5; i++) {
		StdDraw.setPenColor(105,48,33);
		StdDraw.filledPolygon(xMap, yMap);
		

		// }

	}

	public static double[] getMapy() {
		return yMap;

	}

	public static double[] getMapx() {
		return xMap;
	}

}