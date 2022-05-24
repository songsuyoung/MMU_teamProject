package StageThree;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Character_2p extends CharacterObject {
	
	static ImageIcon icon1_2p = new ImageIcon("images/ch_2p_left.png");
	static ImageIcon icon1_2_2p = new ImageIcon("images/left_move_2p.png");
	static ImageIcon leftjump_2p = new ImageIcon("images/ch_2p_leftjump.png");
	
	static ImageIcon icon2_2p = new ImageIcon("images/ch_2p_right.png");
	static ImageIcon icon2_2_2p = new ImageIcon("images/right_move_2p.png");
	static ImageIcon rightjump_2p = new ImageIcon("images/ch_2p_rightjump.png");
	
	static Image img2 = icon1_2p.getImage();

	int upperMax = 70;
	static int dy_2p = 0;
	int jumpspeed = 3;
	int dx_2p = 0;
	int movecheck = 0;

	public Character_2p(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 2;
	}

	public int getY() {
		return y;
	}

	@Override
	public void updateLocation() {
		if (PlatformScene_Three.checkleft_2p && PlatformScene_Three.leftMove_2p) {
			//img = icon1.getImage();
			if (img2 != icon1_2p.getImage()) {
				img2 = icon1_2p.getImage();
			}
			
			if (PlatformScene_Three.isJumping_2p == false && img2 == icon1_2p.getImage() && dx_2p >= 5) {
				img2 = icon1_2_2p.getImage();
				dx_2p = 0;
			}

			x -= speed;
			dx_2p += 1;

		}

		if (PlatformScene_Three.checkright_2p && PlatformScene_Three.rightMove_2p) {
			//img = icon2.getImage();
			
			if (img2 != icon2_2p.getImage()) {
				img2 = icon2_2p.getImage();
			}
			
			if (PlatformScene_Three.isJumping_2p == false && img2 == icon2_2p.getImage() && dx_2p >= 5) {
				img2 = icon2_2_2p.getImage();
				dx_2p = 0;
			}

			
			x += speed;
			dx_2p += 1;
			

		}

		if (PlatformScene_Three.onTop_2p) { // ��� �ö� ���� ��
			if (img2 == rightjump_2p.getImage())
				img2 = icon2_2p.getImage();
			else if (img2 == leftjump_2p.getImage())
				img2 = icon1_2p.getImage();

		}

		{
			if (PlatformScene_Three.jumping_2p) {// ���� ��ġ, ���� ��ġ
				if (img2 == icon2_2p.getImage())
					img2 = rightjump_2p.getImage();
				else if (img2 == icon1_2p.getImage())
					img2 = leftjump_2p.getImage();

				PlatformScene_Three.isJumping_2p = true;

				y -= jumpspeed;
				dy_2p += jumpspeed;

				if (dy_2p >= upperMax) {
					PlatformScene_Three.jumping_2p = false;
					// FlatformScene.falling = true;
					dy_2p = 0;
				}
			}

			else if (PlatformScene_Three.falling_2p) {

				y += jumpspeed;
				PlatformScene_Three.isJumping_2p = true;

				if (img2 == rightjump_2p.getImage())
					img2 = icon2_2p.getImage();
				else if (img2 == leftjump_2p.getImage())
					img2 = icon1_2p.getImage();
			}
		}

		if (y <= PlatformScene_Three.height) {
			PlatformScene_Three.falling_2p = true;
		}

	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img2, x, y, width, height, null); // this? null?
		//
		// �ڵ� �߰�
		//
	}
}
