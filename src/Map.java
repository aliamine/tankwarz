import java.awt.Color;

public class Map {
	public static double[] x;
	public static double[] y;
	double RADIUS = 15;
	
	

	public Map() {
		double[] x = new double[500];
		double[] y = new double[500];
		x[0] = 1;
		x[1] = 1;
		x[499] = 600;
		y[0] = 1;
		y[1] = 250;
		double yMin = 20;
		double yMax = 20;
		double xMin = 30;
		double xMax = 130;
		for (int i = 2; i < x.length - 1; i++) {
			y[i] = (y[i - 1] - yMin) + Math.random() * (yMax + yMin);
			x[i] =5*i;
		
		}
		this.x = x;
		this.y = y;

	}

	private int cos(double d) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void polyG(Map map) {
		// for (int i = 0; i < 5; i++) {
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.filledPolygon(x, y);

		// }

	}
	/*public void display(){
		for (int i = 2; i < x.length -1; i++) {
			StdDraw.filledCircle(x[i], y[i]-15, RADIUS); //cercle sur chaque point du polygone
		}
		
	}*/
	
	public static double[] getMapy() {
		return y;

	}

	public static double[] getMapx() {
		return x;
	}
	
	public static int bezier(double x[],double y[],int n){
		int sum = 0;
		//int i = 0;
		for (int i=0; i <= n; i++){
			int random = (int) (1 + Math.random() * 5);
			sum = sum + ((factiorielle(n)/(factiorielle(i)*(factiorielle((n-i))))) * puissance(random, i) * puissance((1 - random), n - i)); // * Pi;
			StdDraw.point(i + 50, sum + 450);
		}
		
		return sum;
	}

	
	public static int factiorielle(int n)
	{
		if (n == 0)
			return 1;
		else
		{
			int i = 1;
			int sum = i;
			while (i <= n)
			{
				sum = i * sum;
				i++;
			}
			
			return sum;
		}
	}
	
	public static int puissance(int nombre , int puissance)
	{
		int i = 1;
		int sum = 0;
		
		while (i <= puissance){
			sum = sum * puissance;
			i++;
		}
		return sum;
	}
}