package StageTwo;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class GameOver extends JPanel{
	ImageIcon game_over = new ImageIcon("images/gameover.png");
	Image game=game_over.getImage();
	public void paintComponent(Graphics g) { // ���α���, ���α��� �޾Ƽ�, ������ ��ü ȣ��
		super.paintComponent(g); // JPanel�� ������ paintComponent() ȣ�� -> �ڱ� �ڽ��� �׸���...
		
		g.drawImage(game,0,0,1015,800,this);
	}
}
