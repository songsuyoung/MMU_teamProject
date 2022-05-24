package StageThree;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MoveCharacterKey extends KeyAdapter { // 캐릭터 키보드로 이동 할 때 쓸 class
	@Override
	public void keyPressed(KeyEvent e) { // 키를 누르면 그에 맞는 ()Move 가 true로 바뀐다.
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			PlatformScene_Three.leftMove = true;
		}

		if (key == KeyEvent.VK_RIGHT) {
			PlatformScene_Three.rightMove = true;
		}

		if (key == KeyEvent.VK_UP) { // isJumping 사용법 맞는지...
			if (PlatformScene_Three.isJumping == false) {
				PlatformScene_Three.jumping = true;
				PlatformScene_Three.isJumping = true;
				
			      
			    sound();   
				
			}
			
		}
/*---------------------------------------------------------------------------------- */
		if (key == KeyEvent.VK_A) {
			PlatformScene_Three.leftMove_2p = true;
		}

		if (key == KeyEvent.VK_D) {
			PlatformScene_Three.rightMove_2p = true;
		}

		if (key == KeyEvent.VK_W) { // isJumping 사용법 맞는지...
			if (PlatformScene_Three.isJumping_2p == false) {
				PlatformScene_Three.jumping_2p = true;
				PlatformScene_Three.isJumping_2p = true;
				
			    sound();
			      
			}
			
		}
		

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			PlatformScene_Three.leftMove = false;
			Character.img = Character.icon1.getImage();
		}

		if (key == KeyEvent.VK_RIGHT) {
			PlatformScene_Three.rightMove = false;
			Character.img = Character.icon2.getImage();
		}

/*---------------------------------------------------------------------------------- */
		
		if (key == KeyEvent.VK_A) {
			PlatformScene_Three.leftMove_2p = false;
			Character_2p.img2 = Character_2p.icon1_2p.getImage();
		}

		if (key == KeyEvent.VK_D) {
			PlatformScene_Three.rightMove_2p = false;
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
	         //e1.printStackTrace();
	      }  
	}

}
