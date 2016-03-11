
public class Cloud {
	public static double line;
	public static double line1 ;
	public static double cloudX;
	public static double cloudSpeed;
	public static double progression = 500;
	public static double progression1 = 20 ;
	
	public Cloud(){
		double windSens = Math.random()+0.1;
		double windForce = 10*(Math.random()+0.1);
		
		if(windSens >0.5){
			windForce = +windForce;
		}
		else{
			windForce = -windForce;
		}
		
		cloudSpeed=windForce;
	}
	
	public void wind(Cloud cloud){
		line = 0.1;
		line1 = 0.1;
			 
		
		 
		 StdDraw.picture(progression, 340,"files/pictures/clouds.png" );
		 StdDraw.picture(progression1 , 475,"files/pictures/clouds.png" );
		 
		if(progression >=890){
			progression = 15;
			
		}
		if(progression1 >=890){
			progression1 = 15;
			
		}
		if(progression <=10){
			progression = 885;
			
		}
		if(progression1 <=10){
			progression1 = 885;
			
			
		}
		else{
			progression = progression+  cloudSpeed * line;
			progression1 =progression1+ cloudSpeed *line1;
		}
		
	}
	
	public static void viewWind(){
		if (cloudSpeed>0){
			StdDraw.picture(200,550,"files/pictures/windD.png");
		}
		if (cloudSpeed<0){
			StdDraw.picture(200,550,"files/pictures/windG.png");
		}
	}
	
	public static double getCloud(){
		return cloudX;
	}
}
