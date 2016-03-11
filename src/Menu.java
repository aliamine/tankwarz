import java.awt.Font;
import java.awt.event.KeyEvent;

public class Menu {


	public static void gameMenu() {

		StdDraw.picture(450, 300, "files/pictures/tankFond.png", 990, 660);
		StdDraw.setPenColor(248, 132, 16);
		StdDraw.setFont(new Font("Arial", Font.BOLD,40));
		StdDraw.text(450, 115, "PRESS ENTER TO START GAME");
		StdDraw.setFont(new Font("Arial", Font.ITALIC,15));
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(800, 20, "by ALI & SAYED PRODUCTION");
		StdDraw.setFont(new Font("Arial", Font.CENTER_BASELINE,15));

		if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
			Main.menudisplay = false;
			Main.game = true;
			

		}

	}
}
