import java.awt.event.KeyEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Main {
	public static Tank tankPlayer;
	public static Tank[] tankListe;
	public static boolean game = false;
	public static Bullet fireball;
	public static Bullet1 fireball1;
	public static int tir = 0;
	public static boolean menudisplay = true;

	

	public static void main(String[] args) {

		StdDraw.setCanvasSize(900, 600);
		StdDraw.setXscale(0, 900);
		StdDraw.setYscale(0, 600);
		if(menudisplay){
			playSound("menu6sec.wav",3.0f);
		}
		while(menudisplay){
			Menu.gameMenu();
		}
		
		
		if(game){
			playSound("mw2MainMenu.wav",3.0f);
		}
		
		
		Map mountain = new Map();
		Cloud petitnuage = new Cloud();
		
		tankListe = new Tank[2];

		tankListe[0] = new Tank(Map.getMapx()[100], Map.getMapy()[100], true);
		tankListe[1] = new Tank(Map.getMapx()[700], Map.getMapy()[700], false);

		tankPlayer = tankListe[0];
		
		
		while (game) {
			StdDraw.clear(StdDraw.WHITE);
			mountain.buildMap(mountain);
			petitnuage.wind(petitnuage);
			Round.chrono(tankListe);
			Round.distance(tankListe);
			Round.gameScore();
			
			
			//Map.wind();
			if(game){
				Cloud.viewWind();
				for (int k = 0; k < 2; k++) {
					tankListe[k].afficher();
				}
			}
			
			if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
				tankPlayer.move(true);
			}

			if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
				tankPlayer.move(false);
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
				tankPlayer.rotation(true);
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
				tankPlayer.rotation(false);
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
				if (tankPlayer.getDirection()) {
					fireball = new Bullet(tankPlayer.getRotD(),
							tankPlayer.getPosx() + 10,
							tankPlayer.getPosy() + 25, 20 + (int)Cloud.cloudSpeed, 17);
				} else if (tankPlayer.getDirection() == false) {
					fireball = new Bullet(tankPlayer.getRotG(),
							tankPlayer.getPosx() - 7,
							tankPlayer.getPosy() + 25, 20 - (int) Cloud.cloudSpeed, 17);
				}
				tir = 1;
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_CONTROL)) {
				if (tankPlayer.getDirection()) {
					fireball1 = new Bullet1(tankPlayer.getRotD(),
							tankPlayer.getPosx() + 10,
							tankPlayer.getPosy() + 25, 20 + (int)Cloud.cloudSpeed, 17);
				} else if (tankPlayer.getDirection() == false) {
					fireball1 = new Bullet1(tankPlayer.getRotG(),
							tankPlayer.getPosx() - 7,
							tankPlayer.getPosy() + 25, 20 - (int) Cloud.cloudSpeed, 17);
				}
				tir = 2;
			}

			if (tir == 1) {
				fireball.fire();
			}else if(tir == 2){
				fireball1.fire();
			}
			StdDraw.show(6);
		}

	}
	
	public static synchronized void playSound(final String url,
			final float value) {									// Musique d'ambiance
		new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem
							.getAudioInputStream(Main.class
									.getResourceAsStream("ressources/" + url));
					clip.open(inputStream);
					FloatControl volume = (FloatControl) clip
							.getControl(FloatControl.Type.MASTER_GAIN);
					volume.setValue(value);

					clip.loop(0);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
	}

}
