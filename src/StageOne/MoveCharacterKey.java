package StageOne;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MoveCharacterKey extends KeyAdapter { // ĳ���� Ű����� �̵� �� �� �� class
	@Override
	public void keyPressed(KeyEvent e) { // Ű�� ������ �׿� �´� ()Move �� true�� �ٲ��.
		int key = e.getKeyCode();
		/*FlatformScene stage = new FlatformScene();
		
		if (key == KeyEvent.VK_R) {
			stage.repaint();
		}*/
		
		if (key == KeyEvent.VK_LEFT) {
			PlatformScene_One.leftMove = true;
		}

		if (key == KeyEvent.VK_RIGHT) {
			PlatformScene_One.rightMove = true;
		}

		if (key == KeyEvent.VK_UP) { // isJumping ���� �´���...
			if (PlatformScene_One.isJumping == false) {
				PlatformScene_One.jumping = true;
				PlatformScene_One.isJumping = true;
			
			    sound();   
				
			}
			
		}
/*---------------------------------------------------------------------------------- */
		if (key == KeyEvent.VK_A) {
			PlatformScene_One.leftMove_2p = true;
		}

		if (key == KeyEvent.VK_D) {
			PlatformScene_One.rightMove_2p = true;
		}

		if (key == KeyEvent.VK_W) { // isJumping ���� �´���...
			if (PlatformScene_One.isJumping_2p == false) {
				PlatformScene_One.jumping_2p = true;
				PlatformScene_One.isJumping_2p = true;
				
			    sound();
			      
			}
			
		}
		

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			PlatformScene_One.leftMove = false;
			Character_1p.img = Character_1p.icon1.getImage();
		}

		if (key == KeyEvent.VK_RIGHT) {
			PlatformScene_One.rightMove = false;
			Character_1p.img = Character_1p.icon2.getImage();
		}

/*---------------------------------------------------------------------------------- */
		
		if (key == KeyEvent.VK_A) {
			PlatformScene_One.leftMove_2p = false;
			Character_2p.img2 = Character_2p.icon1_2p.getImage();
		}

		if (key == KeyEvent.VK_D) {
			PlatformScene_One.rightMove_2p = false;
			Character_2p.img2 = Character_2p.icon2_2p.getImage();
		}

	}
	
	public void sound() {	 
	      try {
	    	  
	    	 File file = new File("music/jump_5.wav");	 
	         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
	         Clip clip = AudioSystem.getClip();
	         clip.open(stream);
	         clip.start();
	         

	      } catch(Exception e1) {
	        // e1.printStackTrace();
	      }  
	}

}
