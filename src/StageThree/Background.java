package StageThree;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class Background extends GameObject{
	static int background_setN; //����� �ٸ��� ���ڸ� �־��ּ���.
	
	ImageIcon icon = new ImageIcon("images/07.jpg");
	Image img = icon.getImage();
	/*ImageIcon image = new ImageIcon("images/wall_25x20_w.png");
	Image b_img_w = image.getImage();
	ImageIcon b_image = new ImageIcon("images/width_wall.png");
	Image b_img_h = b_image.getImage();
	ArrayList<GameObject> gamebackground;*/
	
	public Background() {
		/*gamebackground = new ArrayList<GameObject>();
		
		gamebackground.add(new BlockObject(940,40,40,40*18)); //��ü�� ���� ���
		gamebackground.add(new BlockObject(0,0,40*20,40));
		gamebackground.add(new BlockObject(0,40,40,40*18));
		gamebackground.add(new BlockObject(0,720,40,40*18));
	*/
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(background_setN==1) { //ù��° ���
			g.drawImage(img,0,0,1010,800,null);
		}else if(background_setN==2) { //2��° ���
			
		}else { //3��° ���
			//g.drawImage(img,0,0,1010,800,null);
		}
	/*	g2d.drawImage(b_img_h,960,40,null);
		g2d.drawImage(b_img_w,0,0,null);
		g2d.drawImage(b_img_h,0,40,null);
		g2d.drawImage(b_img_w,0,720,null);*/
	}

	@Override
	public void updateLocation() {
		// TODO Auto-generated method stub
		
	}
}
